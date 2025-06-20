package com.example.shopapp.app.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shopapp.features.auth.view.CartView
import com.example.shopapp.features.auth.view.HomeView
import com.example.shopapp.features.auth.view.LoginView

@Composable
fun Navigation(context: Context){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "loginView"
    ){

        composable(route = "loginView"){
            LoginView(navController)
        }

        composable(route = "cartView"){
            CartView(navController)
        }

        composable(route = "homeView"){
            HomeView(navController)
        }

    }

}