package com.example.lab7_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
//imports below are for code from AI prompt 1
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

class Screen2 : Fragment() {
    lateinit var viewModel: MyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = activity?.run {
            ViewModelProvider(this)[MyViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        val view = inflater.inflate(R.layout.screen2, container, false)
        val dateDisplay = view.findViewById<TextView>(R.id.dateText)
        val but = view.findViewById<Button>(R.id.vbutton)
        val value = view.findViewById<EditText>(R.id.editValue)
        but.setOnClickListener {
            viewModel.value.setValue(value.getText().toString())
        }

        //AI-assisted code block, from prompt 1
        setFragmentResultListener("dateResult") {_, bundle ->
            val selectedDate = bundle.getString("selectedDate")
            dateDisplay.text = selectedDate
        }

        return view
    }
}