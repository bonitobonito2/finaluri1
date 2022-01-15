package com.example.zaali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class bicebsactivity : AppCompatActivity() {
    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("userinfo2")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bicebsactivity)
        var btn = findViewById<Button>(R.id.eddtofavoritesChest2)
        btn.setOnClickListener {
            var info = addfavorites("bicebs","https://iaom-us.com/wp-content/uploads/2018/11/Fotolia_110740333_S-693x675.jpg")
            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("bicebs").setValue(info)
            Toast.makeText(this, "bicebs added to favorites", Toast.LENGTH_SHORT).show()
            var intent =Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
}