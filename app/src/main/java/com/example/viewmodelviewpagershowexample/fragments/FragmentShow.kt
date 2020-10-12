package com.example.viewmodelviewpagershowexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.viewmodelviewpagershowexample.AppViewModel
import com.example.viewmodelviewpagershowexample.R

class FragmentShow():Fragment()
{
    private lateinit var rootView:View

    // View Elemente:
    private lateinit var tvA:TextView
    private lateinit var tvB:TextView
    private lateinit var tvC:TextView
    private lateinit var btn: Button
    private lateinit var switch: Switch

    // ViewModel:
    private lateinit var viewModel:AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_show,container,false)

        tvA = rootView.findViewById(R.id.show_tv_a)
        tvB = rootView.findViewById(R.id.show_tv_b)
        tvC = rootView.findViewById(R.id.show_tv_c)

        btn = rootView.findViewById(R.id.btn_update)
        btn.setOnClickListener {  }

        switch = rootView.findViewById(R.id.show_switch)
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            initObserver()
        }

        viewModel = ViewModelProvider(requireParentFragment()).get(AppViewModel::class.java)

        loadOfflineData()
        initObserver()



        return rootView
    }

    private fun initObserver()
    {
        if(switch.isChecked)
        {
            viewModel.getValueA().observe(viewLifecycleOwner, Observer {value ->
                tvA.text = value
            })

            viewModel.getValueB().observe(viewLifecycleOwner, Observer {value ->
                tvB.text = value
            })

            viewModel.getValueC().observe(viewLifecycleOwner, Observer {value ->
                tvC.text = value
            })
        }

    }


    private fun loadOfflineData()
    {
        tvA.text = viewModel.value_a
        tvB.text = viewModel.value_b
        tvC.text = viewModel.value_c
    }


}
