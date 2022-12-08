package com.example.student_information_exchange_app.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.student_information_exchange_app.fragments.StudentOptionsFragment
import com.example.student_information_exchange_app.fragments.TutorOptionsFragment

class TutoringServiceAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                TutorOptionsFragment()
            }
            1->{
                StudentOptionsFragment()
            }
            else->{
                TutorOptionsFragment()
            }
        }

    }
}