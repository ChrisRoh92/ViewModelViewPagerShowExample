package com.example.viewmodelviewpagershowexample.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.viewmodelviewpagershowexample.AppViewModel
import com.example.viewmodelviewpagershowexample.R

class FragmentC():Fragment()
{
    private lateinit var rootView:View

    // View:
    private lateinit var et: EditText
    private lateinit var btn: Button

    // ViewModel
    private lateinit var viewModel: AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_c,container,false)


        et = rootView.findViewById(R.id.c_et)
        btn = rootView.findViewById(R.id.c_btn_save)
        btn.setOnClickListener { saveData() }

        viewModel = ViewModelProvider(requireParentFragment()).get(AppViewModel::class.java)



        return rootView
    }

    private fun saveData()
    {
        if(!TextUtils.isEmpty(et.text))
        {
            viewModel.setValueC(et.text.toString())
        }
        else
        {
            viewModel.setValueC("")
        }
    }


}
