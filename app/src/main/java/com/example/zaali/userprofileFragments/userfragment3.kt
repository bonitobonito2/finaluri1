package com.example.zaali.userprofileFragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.zaali.MainActivity
import com.example.zaali.R
import com.example.zaali.editData
import com.example.zaali.userinfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserInfo
import com.google.firebase.database.*
import org.w3c.dom.Text

class userfragment3 : Fragment(R.layout.userfragment3) {
    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("userinfo")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var name = view.findViewById<TextView>(R.id.nameconvrted)
        var lastname = view.findViewById<TextView>(R.id.lastnameconverted)
        var url = view.findViewById<TextView>(R.id.urlconverted)
        var changelastnamebtn = view.findViewById<Button>(R.id.changelastname)
        var logutbtn = view.findViewById<Button>(R.id.logut)
        var profilepic = view.findViewById<ImageView>(R.id.profilepic)


        db.child(FirebaseAuth.getInstance().currentUser?.uid!!)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var Userinfo = snapshot.getValue(userinfo::class.java) ?: return
                    name.text = "your name:  ${Userinfo.name}"
                    lastname.text = "lastname: ${Userinfo.lastname}"
                    url.text ="your photo url: ${Userinfo.photourl}"
                    Glide.with(this@userfragment3)
                        .load(Userinfo.photourl)
                        .centerCrop()
                        .into(profilepic)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })
        changelastnamebtn.setOnClickListener {
            var intent = Intent(activity, editData::class.java)
            startActivity(intent)
        }
        logutbtn.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            FirebaseAuth.getInstance().signOut()

        }

    }
}