package com.example.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class UserActivity : AppCompatActivity() {

    lateinit var userName: TextView
    lateinit var signOutButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        mAuth = FirebaseAuth.getInstance();
        userName = findViewById(R.id.userName)
        signOutButton = findViewById(R.id.signOutButton)

        userName.text = "Registered Email Address:  " + mAuth.currentUser?.email

        signOutButton.setOnClickListener{
            mAuth.currentUser!!.delete()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}