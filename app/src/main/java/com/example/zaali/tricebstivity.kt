package com.example.zaali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class tricebstivity : AppCompatActivity() {
    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("userinfo2")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tricebstivity)
        var btn = findViewById<Button>(R.id.eddtofavoritesChest3)

        btn.setOnClickListener {
            var info = addfavorites("tricebs","https://i.shgcdn.com/c39f9e9e-8e0a-4fa9-9ead-7ab7c3415c9d/-/format/auto/-/preview/3000x3000/-/quality/lighter/")
            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("tricebs").setValue(info)
            Toast.makeText(this, "tricebs added to favorites", Toast.LENGTH_SHORT).show()
            var intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

    }
}