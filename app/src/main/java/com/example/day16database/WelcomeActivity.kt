package com.example.day16database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        supportActionBar?.hide()
        //we are getting the 3 things from signinactivity
        val name =intent.getStringExtra(SignInActivity.KEY2)
        val mail =intent.getStringExtra(SignInActivity.KEY1)
        val userId =intent.getStringExtra(SignInActivity.KEY3)


        //we are finding and editing the meassage that will be displayed to the user
        val welcomeText =findViewById<TextView>(R.id.tVWelcome)
        val mailText =findViewById<TextView>(R.id.btnMail)
        val idText =findViewById<TextView>(R.id.btnUnique)

        welcomeText.text="HELL0 $name"
        mailText.text="Email : $mail"
        idText.text="ID : $userId"


    }
}