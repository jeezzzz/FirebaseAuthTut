package com.jeezzzz.firebasetut

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class HomeScreen() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        val email=intent.getStringExtra("email")
        val text=findViewById<TextView>(R.id.emailTxt)
        text.text="Welcome\n"+email

        val signOutButton=findViewById<Button>(R.id.signOutButton)
        signOutButton.setOnClickListener{
            Firebase.auth.signOut()
            val intent=Intent(this,LoginScreen::class.java)
        }
    }
}