package com.example.zaali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class deltoidsActivity : AppCompatActivity() {
    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("userinfo2")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deltoids)
        var btn = findViewById<Button>(R.id.eddtofavoritesChest5)

        btn.setOnClickListener {
            var info = addfavorites("deltoids","https://images.squarespace-cdn.com/content/v1/5ebef943272c1041d83b1d15/1590177449617-S0FV8E560EHBBFFVNYZO/Anterior+Deltoid+Muscle?format=500w")
            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("deltoids").setValue(info)
            Toast.makeText(this, "deltoids added to favorites", Toast.LENGTH_SHORT).show()
            var intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

    }
}