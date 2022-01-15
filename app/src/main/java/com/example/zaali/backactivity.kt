package com.example.zaali

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class backactivity : AppCompatActivity() {
    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("userinfo2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backactivity2)
        var btn = findViewById<Button>(R.id.eddtofavoritesChest1)

        btn.setOnClickListener {
            var info = addfavorites("back","https://ix-cdn.b2e5.com/images/41628/41628_4d7bcffa446f416f8542fee1625260d0_1616757894.jpeg")
            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("back").setValue(info)
            Toast.makeText(this, "back added to favorites", Toast.LENGTH_SHORT).show()
        }

    }
}