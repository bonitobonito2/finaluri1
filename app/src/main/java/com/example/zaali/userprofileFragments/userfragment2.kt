package com.example.zaali.userprofileFragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.zaali.*
import com.example.zaali.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class userfragment2:Fragment(R.layout.userfragment2) {
    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("userinfo2")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var photo = view.findViewById<ImageView>(R.id.photo)
        var musculename = view.findViewById<TextView>(R.id.musculename)
        var deleteButton = view.findViewById<Button>(R.id.removebutton)


        var photo1 = view.findViewById<ImageView>(R.id.photo1)
        var musculename1 = view.findViewById<TextView>(R.id.musculename1)
        var deleteButton1 = view.findViewById<Button>(R.id.removebutton1)


        var photo2 = view.findViewById<ImageView>(R.id.photo2)
        var musculename2 = view.findViewById<TextView>(R.id.musculename2)
        var deleteButton2 = view.findViewById<Button>(R.id.removebutton2)


        var photo3 = view.findViewById<ImageView>(R.id.photo3)
        var musculename3 = view.findViewById<TextView>(R.id.musculename3)
        var deleteButton3 = view.findViewById<Button>(R.id.removebutton3)



        var photo4 = view.findViewById<ImageView>(R.id.photo4)
        var musculename4 = view.findViewById<TextView>(R.id.musculename4)
        var deleteButton4 = view.findViewById<Button>(R.id.removebutton4)

        var photo5 = view.findViewById<ImageView>(R.id.photo5)
        var musculename5 = view.findViewById<TextView>(R.id.musculename5)
        var deleteButton5 = view.findViewById<Button>(R.id.removebutton5)



        db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("chest")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var Userinfo1 =
                        snapshot.getValue(addfavorites::class.java) ?: return
                    if (!Userinfo1.name.isEmpty()) {
                        deleteButton.visibility = View.VISIBLE
                        photo.visibility=View.VISIBLE
                        musculename.visibility=View.VISIBLE
                        musculename.text=Userinfo1.name
                        Glide.with(this@userfragment2)
                            .load(Userinfo1.photUrl)
                            .centerCrop()
                            .into(photo)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

        db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("back")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var Userinfo1 =
                        snapshot.getValue(addfavorites::class.java) ?: return
                    if (!Userinfo1.name.isEmpty()) {
                        deleteButton1.visibility = View.VISIBLE
                        photo1.visibility=View.VISIBLE
                        musculename1.visibility=View.VISIBLE
                        musculename1.text=Userinfo1.name
                        Glide.with(this@userfragment2)
                            .load(Userinfo1.photUrl)
                            .centerCrop()
                            .into(photo1)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

//bicebs
        db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("bicebs")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var Userinfo1 =
                        snapshot.getValue(addfavorites::class.java) ?: return
                    if (!Userinfo1.name.isEmpty()) {
                        deleteButton2.visibility = View.VISIBLE
                        photo2.visibility=View.VISIBLE
                        musculename2.visibility=View.VISIBLE
                        musculename2.text=Userinfo1.name
                        Glide.with(this@userfragment2)
                            .load(Userinfo1.photUrl)
                            .centerCrop()
                            .into(photo2)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

        db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("tricebs")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var Userinfo1 =
                        snapshot.getValue(addfavorites::class.java) ?: return
                    if (!Userinfo1.name.isEmpty()) {
                        deleteButton3.visibility = View.VISIBLE
                        photo3.visibility=View.VISIBLE
                        musculename3.visibility=View.VISIBLE
                        musculename3.text=Userinfo1.name
                        Glide.with(this@userfragment2)
                            .load(Userinfo1.photUrl)
                            .centerCrop()
                            .into(photo3)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

        db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("trapezius")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var Userinfo1 =
                        snapshot.getValue(addfavorites::class.java) ?: return
                    if (!Userinfo1.name.isEmpty()) {
                        deleteButton4.visibility = View.VISIBLE
                        photo4.visibility=View.VISIBLE
                        musculename4.visibility=View.VISIBLE
                        musculename4.text=Userinfo1.name
                        Glide.with(this@userfragment2)
                            .load(Userinfo1.photUrl)
                            .centerCrop()
                            .into(photo4)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("deltoids")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var Userinfo1 =
                        snapshot.getValue(addfavorites::class.java) ?: return
                    if (!Userinfo1.name.isEmpty()) {
                        deleteButton5.visibility = View.VISIBLE
                        photo5.visibility=View.VISIBLE
                        musculename5.visibility=View.VISIBLE
                        musculename5.text=Userinfo1.name
                        Glide.with(this@userfragment2)
                            .load(Userinfo1.photUrl)
                            .centerCrop()
                            .into(photo5)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

                deleteButton.setOnClickListener {
            var info = addfavorites("","")
            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("chest").setValue(info)
            photo.visibility=View.GONE
            musculename.visibility=View.GONE
            deleteButton.visibility=View.GONE
                    Toast.makeText(activity, "chest removed from favorites", Toast.LENGTH_SHORT).show()

        }
        deleteButton1.setOnClickListener {
            var info = addfavorites("","")
            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("back").setValue(info)
            photo1.visibility=View.GONE
            musculename1.visibility=View.GONE
            deleteButton1.visibility=View.GONE
            Toast.makeText(activity, "back removed from favorites", Toast.LENGTH_SHORT).show()

        }

        deleteButton2.setOnClickListener {
            var info = addfavorites("","")
            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("bicebs").setValue(info)
            photo2.visibility=View.GONE
            musculename2.visibility=View.GONE
            deleteButton2.visibility=View.GONE
            Toast.makeText(activity, "bicebs removed from favorites", Toast.LENGTH_SHORT).show()

        }
        deleteButton3.setOnClickListener {
            var info = addfavorites("","")
            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("tricebs").setValue(info)
            photo3.visibility=View.GONE
            musculename3.visibility=View.GONE
            deleteButton3.visibility=View.GONE
            Toast.makeText(activity, "tricebs removed from favorites", Toast.LENGTH_SHORT).show()

        }
        deleteButton4.setOnClickListener {
            var info = addfavorites("","")
            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("trapezius").setValue(info)
            photo4.visibility=View.GONE
            musculename4.visibility=View.GONE
            deleteButton4.visibility=View.GONE
            Toast.makeText(activity, "trapezius removed from favorites", Toast.LENGTH_SHORT).show()

        }
        deleteButton5.setOnClickListener {
            var info = addfavorites("","")
            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).child("deltoids").setValue(info)
            photo5.visibility=View.GONE
            musculename5.visibility=View.GONE
            deleteButton5.visibility=View.GONE
            Toast.makeText(activity, "deltoids removed from favorites", Toast.LENGTH_SHORT).show()

        }

        photo.setOnClickListener {
            var intent = Intent(activity,chestactivity::class.java)
            startActivity((intent))
        }
        photo1.setOnClickListener {
            var intent = Intent(activity,backactivity::class.java)
            startActivity((intent))
        }
        photo2.setOnClickListener {
            var intent = Intent(activity,bicebsactivity::class.java)
            startActivity((intent))
        }
        photo3.setOnClickListener {
            var intent = Intent(activity,tricebstivity::class.java)
            startActivity((intent))
        }
        photo4.setOnClickListener {
            var intent = Intent(activity,trapeziusActivity::class.java)
            startActivity((intent))
        }
        photo5.setOnClickListener {
            var intent = Intent(activity,deltoidsActivity::class.java)
            startActivity((intent))
        }
    }
}