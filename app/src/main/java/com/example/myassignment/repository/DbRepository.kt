package com.example.myassignment.repository

import com.example.myassignment.roomdb.Student
import com.example.myassignment.roomdb.StudentDao

class DbRepository (private val studentDao:StudentDao){
    suspend fun insersdata(student:Student){
        studentDao.insert(student)
    }
    suspend fun getdata(email:String,password:String):Boolean{
        return studentDao.getdata(email,password)

    }



}
