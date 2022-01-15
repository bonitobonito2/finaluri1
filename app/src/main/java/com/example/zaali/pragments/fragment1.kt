package com.example.zaali.pragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.zaali.MainActivity
import com.example.zaali.MainActivity2
import com.example.zaali.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class fragment1: Fragment(R.layout.fragment1) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if(FirebaseAuth.getInstance().currentUser !=null ) {
            var intent = Intent(getActivity(), MainActivity2::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        var btnsignup = view.findViewById<Button>(R.id.btn)
        var email = view.findViewById<TextView>(R.id.email1)
        var password = view.findViewById<TextView>(R.id.password1)
        var btnsignin = view.findViewById<Button>(R.id.signin)
        btnsignup.setOnClickListener {
            findNavController().navigate(R.id.action_fragment1_to_fragment2)

        }

        btnsignin.setOnClickListener {
           var emailvalue = email.text.toString()
           var passwordvalue = password.text.toString()
           FirebaseAuth.getInstance()
               .signInWithEmailAndPassword(emailvalue,passwordvalue)
               .addOnCompleteListener{ task->
                   if(task.isSuccessful){
                       var intent = Intent(getActivity(),MainActivity2::class.java)
                       startActivity(intent)
                   }else{
                       Toast.makeText(activity, "email or password is incorect", Toast.LENGTH_SHORT).show()
                   }

               }
        }
    }
}