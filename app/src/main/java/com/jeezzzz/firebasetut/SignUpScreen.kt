package com.jeezzzz.firebasetut

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignUpScreen : AppCompatActivity() {
    private lateinit var emailEt:EditText
    private lateinit var passwordEt:EditText
    private lateinit var signUpButton: Button
    private lateinit var auth: FirebaseAuth


//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if (currentUser != null) {
//            val intent=Intent(this,HomeScreen::class.java)
//            intent.putExtra("email", auth.currentUser?.email)
//            startActivity(intent)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_screen)

        emailEt=findViewById(R.id.emailEt)
        passwordEt=findViewById(R.id.passwordEt)
        signUpButton=findViewById(R.id.signUpButton)
        auth= Firebase.auth

        signUpButton.setOnClickListener {

            var email=emailEt.text.toString()
            var password=passwordEt.text.toString()

            var cnfpass=findViewById<EditText>(R.id.cnfPasswordEt)
            var cnfpassvalue=cnfpass.text.toString()

            if(cnfpassvalue==password)
            {
                signUp(email,password)
            }
            else{

            }


    }

        val login=findViewById<Button>(R.id.Login)
        login.setOnClickListener {
            val intent =Intent(this,LoginScreen::class.java)
            startActivity(intent)
        }


    }

    private fun signUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("hello", "createUserWithEmail:success")
                   val intent=Intent(this,HomeScreen::class.java)
                    intent.putExtra("email",email)
                    startActivity(intent)
                }
                else {
                    // If sign in fails, display a message to the user.
                    Log.w("bye", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }

}


