package com.jeezzzz.firebasetut

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class LoginScreen : AppCompatActivity() {

    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        emailEt=findViewById(R.id.emailEt)
        passwordEt=findViewById(R.id.passwordEt)


        val reset=findViewById<TextView>(R.id.reset)
        reset.setOnClickListener {
           startActivity(Intent(this,ResetPassword::class.java))
        }


        val loginButton=findViewById<Button>(R.id.signInButton)

        loginButton.setOnClickListener {
            val email=emailEt.text.toString()
            val password=passwordEt.text.toString()
            auth= Firebase.auth
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("hello", "signInWithEmail:success")
                        val intent= Intent(this,HomeScreen::class.java)
                        intent.putExtra("email",email)
                        startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("bye", "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }

        }

    }
}