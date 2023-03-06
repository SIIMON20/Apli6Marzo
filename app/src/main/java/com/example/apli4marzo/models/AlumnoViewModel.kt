package com.example.apli4marzo.models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase

class AlumnoViewModel : ViewModel() {
    private val _alumnos = mutableStateOf<List<Alumno>>(emptyList())
    val alumnos : State<List<Alumno>>
    get() = _alumnos

    private val query = Firebase.firestore.collection("alumnos")

    init{
        query.addSnapshotListener{ value, _ ->
            if(value != null){
                _alumnos.value = value.toObjects()
            }//fin del if
        }//fin del listener
    }//fin del constructor init
}//fin de la clase