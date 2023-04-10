# database-firebase-

(CREATING MY OWN DATABASE) , (STORING USER ENTERED DATA INTO MY DATABASE) ,  (LINKING DATABASE(FIREBASE)) , (READING THE DATA STORED IN MY DATABASE)

APP : 

Opens with a Sign Up page.(User should register first).

Data will be get stored in my database.

Now user can sign in by clicking on SignIn text - User will be directed into another screen where user should enter registered username and click on SIGN IN

User will be directed into another page where the screen displays all his data stored in my database.

code of mainactivity.kt:


  
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

