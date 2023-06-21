package com.example.productscleanarchit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.productscleanarchit.ui.ProductsList
import com.example.productscleanarchit.ui.theme.ProductsCleanArchitTheme
import com.example.productscleanarchit.ui.viewmodels.ProductsState
import com.example.productscleanarchit.ui.viewmodels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ProductsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProductsCleanArchitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(viewModel)
                }
            }
        }
    }
}

@Composable
fun App(viewModel:ProductsViewModel) {
    val state = viewModel.products.collectAsState()
    viewModel.fetchData()
    GetAllProducts(state = state.value)
}

@Composable
fun GetAllProducts(state: ProductsState) {
    when (state) {
        is ProductsState.Success -> {
            ProductsList(productsObject = state.data)
        }

        is ProductsState.Error -> {
            Log.d("TAG", "getAllProducts: ${state.e}")
        }

        else -> {}
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProductsCleanArchitTheme {
        Greeting("Android")
    }
}