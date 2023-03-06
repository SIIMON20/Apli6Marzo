package com.example.apli4marzo.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.apli4marzo.Navigation.AppScreens
import com.example.apli4marzo.models.Alumno
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable

fun AddScreen(navController: NavController){
    Scaffold(
        topBar = {TopAppBar{ }},
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.size(32.dp),
                onClick = {navController.navigate(route = AppScreens.Home.route)}){
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        BodyContent()
    }
}

@Composable
fun BodyContent() {
    var nombre by remember { mutableStateOf("")}
    var grupo by remember { mutableStateOf("")}
    var codigo by remember { mutableStateOf("")}

    Box( modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)) {
            TextField(modifier = Modifier.fillMaxWidth(),
                value = nombre,
                onValueChange = {nombre = it} ,
                label = { Text("Nombre")}
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = grupo,
                onValueChange = {grupo = it} ,
                label = {Text("Grupo") } ,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = codigo,
                onValueChange = {codigo = it} ,
                label = {Text("Codigo") } ,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
            val alumno = Alumno(nombre, grupo, codigo.toInt())
                Firebase.firestore.collection("alumnos").add(alumno)
            },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Añadir Alumno")
            }
        }
    }
}
