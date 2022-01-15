package com.example.zaali.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.zaali.userprofileFragments.userfragment1
import com.example.zaali.userprofileFragments.userfragment2
import com.example.zaali.userprofileFragments.userfragment3

class ViewPagerFragmentAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount()=3
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->userfragment1()
            1->userfragment2()
            2->userfragment3()
            else ->userfragment1()

        }
    }

}