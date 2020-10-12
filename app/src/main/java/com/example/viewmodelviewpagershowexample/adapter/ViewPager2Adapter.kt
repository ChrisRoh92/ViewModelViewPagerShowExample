package com.example.viewmodelviewpagershowexample.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewmodelviewpagershowexample.fragments.FragmentA
import com.example.viewmodelviewpagershowexample.fragments.FragmentB
import com.example.viewmodelviewpagershowexample.fragments.FragmentC
import com.example.viewmodelviewpagershowexample.fragments.FragmentShow

class ViewPager2Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager, lifecycle)
{

    private val fragmentArray:Array<Fragment> = arrayOf(
        FragmentShow(),
        FragmentA(),
        FragmentB(),
        FragmentC()
    )


    override fun getItemCount(): Int {
        return fragmentArray.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentArray[position]
    }

}