package com.example.apli4marzo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.apli4marzo.Screen.AppNavigation
import com.example.apli4marzo.models.AlumnoViewModel
import com.example.apli4marzo.ui.theme.Apli4MarzoTheme

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<AlumnoViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Apli4MarzoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}
//    val alumnos = listOf(
//        Alumno("Pedro Perez","123345", 987654),
//        Alumno("Simon","28465", 9863577),
//    )

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    Apli4MarzoTheme {
//        AppAlumnos(viewModel)
//    }
//}

