package com.example.lab7_fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val selectedDate = MutableLiveData<String>()

    val value: MutableLiveData<String>
        get() = selectedDate

    init {
        selectedDate.value = "default"
    }
}