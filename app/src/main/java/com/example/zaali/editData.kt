package com.example.zaali

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class editData : AppCompatActivity() {
    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("userinfo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_data)
        var name = findViewById<EditText>(R.id.editname)
        var lastname = findViewById<EditText>(R.id.editlastname)
        var url = findViewById<EditText>(R.id.editurl)
        var edit = findViewById<Button>(R.id.edit)
        var name1 = ""
        var lastname1 = ""
        var url1 = ""
        db.child(FirebaseAuth.getInstance().currentUser?.uid!!)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var Userinfo = snapshot.getValue(userinfo::class.java) ?: return
                    name1 = Userinfo.name
                    lastname1 = Userinfo.lastname
                    url1 =Userinfo.photourl
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })
        edit.setOnClickListener {
            var Userinfo = userinfo(name1,lastname1,url1)
            if(name.text.toString().isEmpty() or lastname.text.toString().isEmpty() or url.text.toString().isEmpty()){
                Toast.makeText(this, "full the values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                Userinfo = userinfo(name.text.toString(),lastname.text.toString(),url.text.toString())
                db.child(FirebaseAuth.getInstance().currentUser?.uid!!).setValue(Userinfo)
                Toast.makeText(this, "values has been changed", Toast.LENGTH_SHORT).show()
                var int = Intent(this,MainActivity2::class.java)
                startActivity(int)
            }

        }

    }
}