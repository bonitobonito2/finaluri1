package com.example.zaali.pragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.zaali.R
import com.google.firebase.auth.FirebaseAuth

class fragment3:Fragment(R.layout.changepasswordfragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var btn = view.findViewById<Button>(R.id.confirmbtn)
        var email = view.findViewById<EditText>(R.id.changepassinput)

        btn.setOnClickListener {
            var email=email.text.toString()
            if(email.isEmpty()){
                Toast.makeText(activity , "email is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task->
                    if(task.isSuccessful){
                        Toast.makeText(activity,"check gmail, we sent u sms",Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(activity, "eror", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}