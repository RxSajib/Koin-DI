package com.example.koinretrofit.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.koinretrofit.databinding.ActivityMainBinding
import com.example.koinretrofit.ui.adapter.ItemAdapter
import com.example.koinretrofit.utils.NetworkResult
import com.example.koinretrofit.viewmodel.DataStoreViewModel
import com.example.koinretrofit.viewmodel.DatabaseViewModel
import com.example.koinretrofit.viewmodel.MyViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private val viewmodel : MyViewModel by viewModel()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val itemAdapter : ItemAdapter by inject()
    private val roomViewModel : DatabaseViewModel by viewModel()
    private val dataStoreViewModel : DataStoreViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        lifecycleScope.launch { 
            dataStoreViewModel.getIntData(key = "ABC").collectLatest {
                Log.d(TAG, "onCreate: ${it}")
            }
        }
        
        
       binding.apply {
            RecyclerView.apply {
                setHasFixedSize(true)
                adapter = itemAdapter
            }
        }

        lifecycleScope.launch {
            viewmodel.stateFlow.collectLatest {
                when(it){
                    is NetworkResult.Success -> {

                        itemAdapter.submitList(it.data)
                    }
                    is NetworkResult.Loading -> {

                        Toast.makeText(this@MainActivity, "Loading ...", Toast.LENGTH_LONG).show()
                    }
                    is NetworkResult.Error -> {

                    }
                    is NetworkResult.Empty -> {
                        
                    }
                }
            }
        }
        
        getListOfFav()

    }
    
    private fun getListOfFav(){
        lifecycleScope.launch { 
            roomViewModel.getBookMark().collect{
                Log.d(TAG, "getListOfFav: ${it.size.toString()}")
            }
        }
    }
}