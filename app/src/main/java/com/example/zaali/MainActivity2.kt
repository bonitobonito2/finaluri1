package com.example.zaali

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.zaali.adapter.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity2 : AppCompatActivity() {
    lateinit var toppager: TabLayout
    lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        toppager=findViewById(R.id.tapbar)
        viewPager=findViewById(R.id.fragments)

        var viewPagerFragmentAdapter= ViewPagerFragmentAdapter(this)

        viewPager.adapter=viewPagerFragmentAdapter


        TabLayoutMediator(toppager,viewPager){tab,position->
            if (position ==0){
                tab.text="body parts"
            }
            if (position==1){
                tab.text="favorites"
            }
            if (position==2){
                tab.text="profile"
            }


        }.attach()
    }
}