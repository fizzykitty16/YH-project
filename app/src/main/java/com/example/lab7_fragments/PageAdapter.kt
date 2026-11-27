package com.example.lab7_fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fa: FragmentActivity, private val mNumOfTabs: Int) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return mNumOfTabs
    }
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Screen1()
            1 -> Screen2()
            2 -> Screen3()
            else -> Screen1()
        }
    }
}