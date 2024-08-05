package com.example.gameretrofit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.gameretrofit.ui.theme.GameRetrofitTheme
import com.example.gameretrofit.viewModel.GamesViewModel
import com.example.gameretrofit.views.HomeView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: GamesViewModel by viewModels()

        enableEdgeToEdge()
        setContent {
            GameRetrofitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    HomeView(viewModel)
                }
            }
        }
    }
}
