package com.example.zaali.pragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.zaali.R
import com.example.zaali.userinfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class fragment2:Fragment(R.layout.fragment2) {
    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("userinfo")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var email = view.findViewById<EditText>(R.id.email2)
        var password =view.findViewById<EditText>(R.id.password2)
        var name = view.findViewById<EditText>(R.id.name)
        var lastname = view.findViewById<EditText>(R.id.lastname)
        var photourl = view.findViewById<EditText>(R.id.photourl)
        var btn = view.findViewById<Button>(R.id.signup2)
        btn.setOnClickListener {
            var email1 = email.text.toString()
            var password1 = password.text.toString()
            var name1 = name.text.toString()
            var lastname1 = lastname.text.toString()
            var  photourl1 = photourl.text.toString()
            var useInfo = userinfo(name1,lastname1,photourl1)
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email1,password1)
                .addOnCompleteListener{task->
                    if(task.isSuccessful){

                       db.child(FirebaseAuth.getInstance().currentUser?.uid!!).setValue(useInfo)

                               findNavController().navigate(R.id.action_fragment2_to_fragment1)
                               Toast.makeText(activity, "account created succsesfully", Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(activity, "eror", Toast.LENGTH_SHORT).show()

                    }

                }
        }
    }
}