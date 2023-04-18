package com.example.myassignment.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true) var SRNU:Int,
    @ColumnInfo("Name") var Fname:String,
    @ColumnInfo("Mo.number")var Mobile:String,
    var Email:String,
    @ColumnInfo("Password") var Password:String,
    @ColumnInfo("Conform Password") var ConPassword:String)
