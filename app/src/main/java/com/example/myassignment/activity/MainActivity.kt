package com.example.myassignment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myassignment.R
import com.example.myassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding:ActivityMainBinding
    lateinit var Factory: Dbfactroy
    lateinit var viewmodel: Dbviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Factory = Dbfactroy(DbRepojetry(DataBaseStudent.myobjct(this).studentdao()))
        viewmodel = ViewModelProvider(this, Factory)[Dbviewmodel::class.java]


        val toolbar=binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }
    fun Loginbutton(view:View){
        if(binding.editMobile.text.toString().length!=10){
            binding.editMobile.setError("Fill valid Mo.Number")

        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(binding.editEmail.text).matches()){
            binding.editEmail.setError("Fill valid Email")
        }
        else if(binding.editPassword.text.toString().isEmpty()){
            binding.editPassword.setError("fill this field")
        }
        else if(binding.editConpassword.text.toString().isEmpty()){
            binding.editConpassword.setError("fill this field")
        }
        else if(!binding.editPassword.text.toString().equals(binding.editConpassword.text.toString())) {
            binding.editConpassword.setError("password does not match")
        }
        else {
            CoroutineScope(Dispatchers.IO).launch {

                viewmodel.insertdata(
                    Student(
                        0,
                        binding.editFname.text.toString(),
                        binding.editMobile.text.toString(),
                        binding.editEmail.text.toString(),
                        binding.editPassword.text.toString(),
                        binding.editConpassword.text.toString()
                    )
                )
                startActivity(Intent(this@MainActivity, Login_Activity::class.java))
            }
        }
    }
}

