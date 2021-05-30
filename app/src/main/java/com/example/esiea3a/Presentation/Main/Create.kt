package com.example.esiea3a.Presentation.Main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.esiea3a.Domain.User
import com.example.esiea3a.R
import org.koin.android.ext.android.inject

class Create : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creation_compte)



        //soucie

        Create_account.setOnClickListener(){
            val monIntentRetour =  Intent(this,MainActivity::class.java)
            val user = User((loginAccount_edit.text.toString().trim()),passwordAccount_edit.text.toString())
            if(user.email !="" && user.password != "") {
                mainViewModel.onClickedLoginAccount(user)
                startActivity(monIntentRetour)
            }else{
                Toast.makeText(applicationContext,"add a password or a user", Toast.LENGTH_SHORT).show()
            }
        }
    }
}