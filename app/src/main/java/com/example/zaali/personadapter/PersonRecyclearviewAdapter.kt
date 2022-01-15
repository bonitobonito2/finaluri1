package com.example.zaali.personadapter

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zaali.*

import com.example.zaali.userprofileFragments.userfragment1
import java.security.AccessController.getContext

class PersonRecyclearviewAdapter(private val list:List<person>): RecyclerView.Adapter<PersonRecyclearviewAdapter.PersonViewHolder>()  {
    class PersonViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val imageView:ImageView

        val meore: TextView
        init{
            imageView = itemView.findViewById(R.id.imageView)

            meore= itemView.findViewById(R.id.nameofmuscule)




        }

        fun setData(person:person){
            Glide.with(itemView.context)
                .load(person.imageurl)
                .centerCrop()
                .into(imageView)

            meore.text = person.name
            itemView.setOnClickListener { v:View->
                if (meore.text=="chest"){
                    val intent = Intent(itemView.context,chestactivity::class.java)
                    itemView.context.startActivity(intent)

                }
                if (meore.text=="back"){
                    val intent = Intent(itemView.context,backactivity::class.java)
                    itemView.context.startActivity(intent)

                }
                if (meore.text=="bicebs"){
                    val intent = Intent(itemView.context,bicebsactivity::class.java)
                    itemView.context.startActivity(intent)

                }
                if (meore.text=="triceps"){
                    val intent = Intent(itemView.context,tricebstivity::class.java)
                    itemView.context.startActivity(intent)

                }
                if (meore.text=="deltoids"){
                val intent = Intent(itemView.context,deltoidsActivity::class.java)
                itemView.context.startActivity(intent)

            }
                if (meore.text=="trapezius"){
                    val intent = Intent(itemView.context,trapeziusActivity::class.java)
                    itemView.context.startActivity(intent)

                }



            }




        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
     val itemView=    LayoutInflater.from(parent.context).inflate(R.layout.itemperson,parent,false)

        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {

        val person = list[position]
        holder.setData(person)


    }

    override fun getItemCount()= list.size

}