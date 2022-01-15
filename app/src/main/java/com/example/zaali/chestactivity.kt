package com.example.zaali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class chestactivity : AppCompatActivity() {
    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("userinfo2")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chestactivity)
        var btn = findViewById<Button>(R.id.eddtofavoritesChest)

        btn.setOnClickListener {
            var info = addfavorites("chest","https://www.bodybuilding.com/images/2017/december/built-by-science-article-graphics-chest-1-700xh.jpg")
            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("chest").setValue(info)
            Toast.makeText(this, "chest added to favorites", Toast.LENGTH_SHORT).show()
            var intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
}