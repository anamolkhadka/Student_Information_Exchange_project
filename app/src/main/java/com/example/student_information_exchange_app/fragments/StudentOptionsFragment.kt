package com.example.student_information_exchange_app.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.student_information_exchange_app.CardActivity
import com.example.student_information_exchange_app.EnrollmentActivity
import com.example.student_information_exchange_app.R
import com.example.student_information_exchange_app.RatingActivity

class StudentOptionsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment_student_options, container, false)

        if(true) {
            disableEnrollButton(view)
            disableRatingButton(view)
        }else{
            enableEnrollButton(view)
            enableRatingButton(view)
        }
        configureEnrollButton(view)
        configureRatingButton(view)
        configureBankButton(view)
        return view
    }
    //Disables the enroll button
    private fun disableEnrollButton(v: View) {
        val button: Button=v.findViewById(R.id.em_button)
        button.isEnabled = false
    }
    //Enables the enroll button
    private fun enableEnrollButton(v: View) {
        val button: Button=v.findViewById(R.id.em_button)
        button.isEnabled = true
    }
    //Disables the rating button
    private fun disableRatingButton(v: View) {
        val button: Button=v.findViewById(R.id.rt_button)
        button.isEnabled = false
    }
    //Enables the rating button
    private fun enableRatingButton(v: View) {
        val button: Button=v.findViewById(R.id.rt_button)
        button.isEnabled = true
    }
    //Handling the enroll button for student's options
    private fun configureEnrollButton(v: View) {
        val button: Button=v.findViewById(R.id.em_button)
        button.setOnClickListener {
            val page = Intent(activity, EnrollmentActivity::class.java)
            startActivity(page)
        }
    }
    //Handling the rating button for student's options
    private fun configureRatingButton(v: View) {
        val button: Button=v.findViewById(R.id.rt_button)
        button.setOnClickListener {
            val page = Intent(activity, RatingActivity::class.java)
            startActivity(page)
        }
    }
    //Handling the configure bank button for student's options
    private fun configureBankButton(v: View) {
        val bankButton: Button=v.findViewById(R.id.cc_button)
        bankButton.setOnClickListener {
            val page = Intent(activity, CardActivity::class.java)
            startActivity(page)
        }
    }
}