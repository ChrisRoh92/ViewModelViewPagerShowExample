package com.example.viewmodelviewpagershowexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.viewmodelviewpagershowexample.AppViewModel
import com.example.viewmodelviewpagershowexample.R
import com.example.viewmodelviewpagershowexample.adapter.ViewPager2Adapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment():Fragment()
{
    private lateinit var rootView: View

    // ViewPager2:
    private lateinit var viewPager2:ViewPager2
    private lateinit var tabLayout:TabLayout
    private lateinit var adapter: ViewPager2Adapter


    // ViewModel:
    private lateinit var viewModel:AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_home,container,false)

        initViewPager2()

        viewModel = ViewModelProvider(this).get(AppViewModel::class.java)




        return rootView
    }

    private fun initViewPager2()
    {
        viewPager2 = rootView.findViewById(R.id.viewpager2)
        adapter = ViewPager2Adapter(childFragmentManager,lifecycle)
        viewPager2.adapter = adapter

        // TabLayout:
        tabLayout = rootView.findViewById(R.id.tablayout)
        val tabNames = arrayOf("Show","A","B","C")
        TabLayoutMediator(tabLayout,viewPager2){tab,position ->
            tab.text = tabNames[position]
        }.attach()
    }




}