package com.example.zaali

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class trapeziusActivity : AppCompatActivity() {
    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("userinfo2")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trapezius)
        var btn = findViewById<Button>(R.id.eddtofavoritesChest4)

        btn.setOnClickListener {
            var info = addfavorites("trapezius","https://images.immediate.co.uk/production/volatile/sites/34/2021/05/Trapezius-stretches-d9d0383.jpg?quality=90&resize=620%2C413")
            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("trapezius").setValue(info)
            Toast.makeText(this, "trapezius added to favorites", Toast.LENGTH_SHORT).show()
        }
    }
}