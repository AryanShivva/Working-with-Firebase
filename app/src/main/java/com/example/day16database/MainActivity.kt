package com.example.day16database

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.example.day16database.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {


   lateinit var database: DatabaseReference
    //created database variable and name is databasereference
    //lateinit means we are creating variable and give value later

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        //create the variables//to know where they are
        // indirectly calling and assigning val to it
        val signButton = findViewById<Button>(R.id.btnSignUp)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etMail = findViewById<TextInputEditText>(R.id.etMail)
        val userId = findViewById<TextInputEditText>(R.id.etUserName)
        val userPassword = findViewById<TextInputEditText>(R.id.etPassword)


        //performing actions when we click on sign in button

        signButton.setOnClickListener {

            //tostring beacuse to convert to string
            // taking input
            // naming creating variable name etc
            val name = etName.text.toString()
            val mail = etMail.text.toString()
            val uniqueId = userId.text.toString()
            val password = userPassword.text.toString()


            //class because all data will be stored under user class
            val user = User(name, mail, password, uniqueId)


            //to create the user when we click the button//initialising database variable
           database = FirebaseDatabase.getInstance().getReference("Users")


            //entering data to database
            //addOnSuccessListener to add toast message "successfully regestired" etc
            database.child(uniqueId).setValue(user).addOnSuccessListener {
                etName.text?.clear()
                //syntax for message toast or fail message
                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }

        //when we click it will go to another activity
        val signIntext = findViewById<TextView>(R.id.tvSignIN)
         signIntext.setOnClickListener {
             val openSignInActivity = Intent(this, SignInActivity::class.java)
             startActivity(openSignInActivity)
         }

    }
}