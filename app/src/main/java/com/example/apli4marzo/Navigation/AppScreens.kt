package com.example.apli4marzo.Navigation


sealed class AppScreens (val route: String){
    object Home : AppScreens(route = "AppAlumnos")
    object AddScreen : AppScreens(route = "AddScreen")
}