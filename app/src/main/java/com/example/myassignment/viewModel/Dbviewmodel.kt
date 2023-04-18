package com.example.myassignment.viewModel

import androidx.lifecycle.ViewModel
import com.example.myassignment.repository.DbRepository
import com.example.myassignment.roomdb.Student

class Dbviewmodel(private val repogetry:DbRepository): ViewModel(){
    suspend fun insertdata(student:Student){
        repogetry.insersdata(student)
    }
    suspend fun getdata(email:String,password:String):Boolean{
        return repogetry.getdata(email,password)
    }
}
