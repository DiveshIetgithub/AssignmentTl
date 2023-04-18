package com.example.myassignment.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myassignment.repository.DbRepository
import com.example.myassignment.viewModel.Dbviewmodel

class Dbfactory(private val repogetry:DbRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Dbviewmodel::class.java)){
            return Dbviewmodel(repogetry) as T
        }
        throw IllegalArgumentException("Unknown class")
    }


}
