package com.example.apli4marzo.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apli4marzo.Navigation.AppScreens
import com.example.apli4marzo.R
import com.example.apli4marzo.models.Alumno
import com.example.apli4marzo.models.AlumnoViewModel

@Composable
fun AlumnoCard(alumno: Alumno){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
    ){
        Column(modifier = Modifier.fillMaxWidth()){
            Text(text = "Nombre : ${alumno.nombre}", color = Color.Gray, fontSize = 16.sp)
            Text(text = "Curso : ${alumno.grupo}", color = Color.Gray, fontSize = 16.sp)
            Text(text = "Codigo : ${alumno.codigo}", color = Color.Gray, fontSize = 16.sp)
        }
    }
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppAlumnos( navController: NavController , viewModel: AlumnoViewModel,) {
  val logo = painterResource(R.drawable.michi)
    Scaffold(
        topBar = {
            TopAppBar { }
        },
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.size(23.dp),
                onClick = { navController.navigate(route = AppScreens.AddScreen.route) }) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Agregar",
                    tint = Color.White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column() {
                Image(
                    logo, contentDescription = "Alumnos",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 32.dp)
                )
                LazyColumn() {
                    items(viewModel.alumnos.value) { alumno ->
                        AlumnoCard(alumno)
                    }
                }
            }
        }
    }
}