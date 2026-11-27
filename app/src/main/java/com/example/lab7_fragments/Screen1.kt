package com.example.lab7_fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
//imports below are for code from AI prompt 1
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

class Screen1 : Fragment() {
    lateinit var viewModel: MyViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = activity?.run {
            ViewModelProvider(this)[MyViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        val view = inflater.inflate(R.layout.screen1, container, false)
        val valueView = view.findViewById<TextView>(R.id.textView)
        val datePicker = view.findViewById<DatePicker>(R.id.datePicker)

        //AI-assisted code block, from prompt 1
        datePicker.setOnDateChangedListener {_, year, month, date ->
            val selectedDate = "$date/${month + 1}/$year"
            setFragmentResult("dateResult", bundleOf("selectedDate" to selectedDate))
        }
        //end of AI-assisted code block

        val valueObserver = Observer<String> { newValue ->
            valueView.text = newValue.toString()
        }
        viewModel.value.observe(viewLifecycleOwner, valueObserver)

        return view;
    }
}