package com.example.student_information_exchange_app.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.student_information_exchange_app.fragments.SessionAddFragment
import com.example.student_information_exchange_app.fragments.SessionEditFragment
import com.example.student_information_exchange_app.fragments.SessionRemoveFragment

class TutoringSessionAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                SessionAddFragment()
            }
            1->{
                SessionEditFragment()
            }
            2->{
                SessionRemoveFragment()
            }
            else->{
                SessionAddFragment()
            }
        }

    }
}