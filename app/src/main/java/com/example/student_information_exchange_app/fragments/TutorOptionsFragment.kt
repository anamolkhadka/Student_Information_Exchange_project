package com.example.student_information_exchange_app.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.student_information_exchange_app.*

class TutorOptionsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment_tutor_options, container, false)

        if(false){
            disableSessionButton(view)
            disableAnnouncementButton(view)
            disableRequestsButton(view)
        }else{
            enableSessionButton(view)
            enableAnnouncementButton(view)
            enableRequestsButton(view)
        }
        configureSessionButton(view)
        configureAnnouncementButton(view)
        configureRequestsButton(view)
        configureBankButton(view)
        return view
    }
    //Disables the session button
    private fun disableSessionButton(v: View) {
        val button: Button=v.findViewById(R.id.sm_button)
        button.isEnabled = false
    }
    //Enables the session button
    private fun enableSessionButton(v: View) {
        val button: Button=v.findViewById(R.id.sm_button)
        button.isEnabled = true
    }
    //Disables the announcement button
    private fun disableAnnouncementButton(v: View) {
        val button: Button=v.findViewById(R.id.am_button)
        button.isEnabled = false
    }
    //Enables the announcement button
    private fun enableAnnouncementButton(v: View) {
        val button: Button=v.findViewById(R.id.am_button)
        button.isEnabled = true
    }
    //Disables the requests button
    private fun disableRequestsButton(v: View) {
        val button: Button=v.findViewById(R.id.vm_button)
        button.isEnabled = false
    }
    //Enables the requests button
    private fun enableRequestsButton(v: View) {
        val button: Button=v.findViewById(R.id.vm_button)
        button.isEnabled = true
    }
    //Handling the manage sessions button for tutor's options
    private fun configureSessionButton(v: View) {
        val button: Button=v.findViewById(R.id.sm_button)
        button.setOnClickListener {
            val page = Intent(activity, TutoringSessionActivity::class.java)
            startActivity(page)
        }
    }
    //Handling the announcement button for tutor's options
    private fun configureAnnouncementButton(v: View) {
        val button: Button=v.findViewById(R.id.am_button)
        button.setOnClickListener {
            val page = Intent(activity, TutoringAnnouncementActivity::class.java)
            startActivity(page)
        }
    }
    //Handling the view requests button for tutor's options
    private fun configureRequestsButton(v: View) {
        val button: Button=v.findViewById(R.id.vm_button)
        button.setOnClickListener {
            val page = Intent(activity, TutoringRequestActivity::class.java)
            startActivity(page)
        }
    }
    //Handling the configure bank button for tutor's options
    private fun configureBankButton(v: View) {
        val button: Button=v.findViewById(R.id.cb_button)
        button.setOnClickListener {
            val page = Intent(activity, BankActivity::class.java)
            startActivity(page)
        }
    }
}