package com.example.myassignment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myassignment.R

class UserDetails : AppCompatActivity() {
    private lateinit var binding: ActivityUserdetailsBinding
    lateinit var factroy: Dbfactroy
    lateinit var viewmodel: Dbviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_userdetails)
        factroy = Dbfactroy(DbRepojetry(DataBaseStudent.myobjct(this).studentdao()))
        viewmodel = ViewModelProvider(this, factroy)[Dbviewmodel::class.java]
    }
}
