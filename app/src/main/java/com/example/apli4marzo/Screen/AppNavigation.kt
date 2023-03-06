package com.example.apli4marzo.Screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apli4marzo.Navigation.AppScreens
import com.example.apli4marzo.models.AlumnoViewModel

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Home.route){
        composable(route = AppScreens.Home.route){AppAlumnos( navController, AlumnoViewModel() )}
        composable(route = AppScreens.AddScreen.route){AddScreen(navController,) }

    }
}