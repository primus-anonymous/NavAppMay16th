package com.neocaptainnemo.navappmay16th

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class PageFragment : Fragment(R.layout.fragment_page) {

    companion object {
        private const val ARG_NUMBER = "ARG_NUMBER"

        fun instance(number: Int) = PageFragment().apply {
            arguments = bundleOf(ARG_NUMBER to number)
        }
    }

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.number).text = arguments?.getInt(ARG_NUMBER)?.toString()

        viewModel.enteredValue.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.number).text = it
        }
    }
}