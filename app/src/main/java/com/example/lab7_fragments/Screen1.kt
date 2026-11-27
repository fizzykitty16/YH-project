package com.example.lab7_fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class Screen1 : Fragment() {
    lateinit var viewModel: MyViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = activity?.run {
            ViewModelProvider(this)[MyViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        val view = inflater.inflate(R.layout.screen1, container, false)
        val datePicker = view.findViewById<DatePicker>(R.id.datePicker)
        Log.d("Screen1", "DatePicker found: $datePicker")

        //ai-assisted code block
        datePicker.setOnDateChangedListener { _, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month + 1}/$year" //update 'selectedDate' whenever new date selected
            Log.d("Screen1", "changed to: $selectedDate") //recommended by AI to use temporary logs while debugging the dateValue TextView
            viewModel.selectedDate.value = selectedDate //store in a LiveData object in viewModel for observer in Screen2 to read
        }
        //end of the code block
        return view
    }
}