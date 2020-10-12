package com.example.viewmodelviewpagershowexample


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel():ViewModel()
{
    private var live_value_a:MutableLiveData<String> = MutableLiveData()
    private var live_value_b:MutableLiveData<String> = MutableLiveData()
    private var live_value_c:MutableLiveData<String> = MutableLiveData()

    var value_a = ""
    var value_b = ""
    var value_c = ""

    // Setter:
    fun setValueA(value:String)
    {
        value_a = value
        live_value_a.value = value
    }

    fun setValueB(value:String)
    {
        value_b = value
        live_value_b.value = value
    }

    fun setValueC(value:String)
    {
        value_c = value
        live_value_c.value = value
    }

    // Getters:
    fun getValueA():LiveData<String> {return live_value_a}
    fun getValueB():LiveData<String> {return live_value_b}
    fun getValueC():LiveData<String> {return live_value_c}

}