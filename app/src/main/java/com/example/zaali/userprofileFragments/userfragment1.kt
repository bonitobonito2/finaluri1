package com.example.zaali.userprofileFragments

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import com.example.zaali.R
import com.example.zaali.person
import com.example.zaali.personadapter.PersonRecyclearviewAdapter

class userfragment1:Fragment(R.layout.userfragment1) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var PersonRecyclearviewAdapter: PersonRecyclearviewAdapter
    lateinit var hm:Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)






      recyclerView = view.findViewById(R.id.recyclearView)
        PersonRecyclearviewAdapter= PersonRecyclearviewAdapter(getData())
       recyclerView.layoutManager=LinearLayoutManager(activity)
       recyclerView.adapter= PersonRecyclearviewAdapter



    }


    private fun getData():List<person>{
        val List = ArrayList<person>()
        List.add(
           person(
               "chest","chest is one of the largest muscule in our body","https://www.bodybuilding.com/images/2017/december/built-by-science-article-graphics-chest-1-700xh.jpg"

           )
        )
        List.add(
            person(
                "back","add to favorites","https://ix-cdn.b2e5.com/images/41628/41628_4d7bcffa446f416f8542fee1625260d0_1616757894.jpeg"

            )
        )
        List.add(
            person(
                "bicebs","add to favorites","https://iaom-us.com/wp-content/uploads/2018/11/Fotolia_110740333_S-693x675.jpg"

            )
        )
        List.add(
            person(
                "triceps","add to favorites","https://i.shgcdn.com/c39f9e9e-8e0a-4fa9-9ead-7ab7c3415c9d/-/format/auto/-/preview/3000x3000/-/quality/lighter/"

            )
        )
        List.add(
            person(
                "trapezius","add to favorites","https://images.immediate.co.uk/production/volatile/sites/34/2021/05/Trapezius-stretches-d9d0383.jpg?quality=90&resize=620%2C413"

            )

        )
        List.add(
            person(
                "deltoids","add to favorites","https://images.squarespace-cdn.com/content/v1/5ebef943272c1041d83b1d15/1590177449617-S0FV8E560EHBBFFVNYZO/Anterior+Deltoid+Muscle?format=500w"

            )


        )



return List
    }
}