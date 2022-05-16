package com.neocaptainnemo.navappmay16th

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class InputValueFragment : Fragment(R.layout.fragment_input_value) {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edit: EditText = view.findViewById(R.id.value)

        view.findViewById<Button>(R.id.publish).setOnClickListener {

            val toPublish = edit.text.toString()

            viewModel.publish(toPublish)

        }
    }
}