package com.example.student_information_exchange_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.student_information_exchange_app.R

class EnrollRemoveFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_enroll_remove, container, false)
        configureRemoveButton(view)
        return view
    }
    private fun configureRemoveButton(v:View){
        var button: Button =v.findViewById(R.id.ds_submit)
        button.isEnabled=false
    }
}