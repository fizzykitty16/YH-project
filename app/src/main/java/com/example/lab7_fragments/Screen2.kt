package com.example.lab7_fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class Screen2 : Fragment() {
    lateinit var viewModel: MyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = activity?.run {
            ViewModelProvider(this)[MyViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        val view = inflater.inflate(R.layout.screen2, container, false)
        val dateValue = view.findViewById<TextView>(R.id.dateText) //the date display
        val but = view.findViewById<Button>(R.id.vbutton) //a button
        val value = view.findViewById<EditText>(R.id.editValue) //an editable text field
        but.setOnClickListener {
            viewModel.value.setValue(value.getText().toString())
        }

        val valueObserver = Observer<String> { newValue ->
            Log.d("Screen2", "observed: $newValue")
            dateValue.visibility = View.VISIBLE
            dateValue.text = newValue //updates the date whenever new date selected on screen1
        }
        viewModel.selectedDate.observe(viewLifecycleOwner, valueObserver)

        return view
    }
}