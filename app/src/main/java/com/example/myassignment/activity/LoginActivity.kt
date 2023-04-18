package com.example.myassignment.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myassignment.R
import com.example.myassignment.databinding.ActivityLoginBinding
import com.example.myassignment.factory.Dbfactory
import com.example.myassignment.repository.DbRepository
import com.example.myassignment.roomdb.DataBaseStudent
import com.example.myassignment.viewModel.Dbviewmodel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    lateinit var factroy:Dbfactory
    lateinit var viewmodel:Dbviewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        factroy = Dbfactory(DbRepository(DataBaseStudent.myobjct(this).studentdao()))
        viewmodel = ViewModelProvider(this, factroy)[Dbviewmodel::class.java]
        binding.btnSingLogin.setOnClickListener {
            if(binding.editEmail.editText?.text.toString().isEmpty()&&binding.editPassword.editText?.text.toString().isEmpty()){
                binding.editEmail.editText?.setError("Fill Email")
                binding.editPassword.editText?.setError("Fill  Password")


            }

            else if(binding.editPassword.editText?.text.toString().isEmpty()){
                binding.editPassword.editText?.setError("Fill  Password")
            }
            else {

                CoroutineScope(Dispatchers.Main).launch {
                    val email = binding.editEmail.editText?.text.toString()
                    val password = binding.editPassword.editText?.text.toString()
                    if (viewmodel.getdata(email, password)) {
                        startActivity(Intent(this@LoginActivity, UserDetails::class.java))
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Please fill valid value ",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }


        }





    }
    fun SignUp(view:View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

}