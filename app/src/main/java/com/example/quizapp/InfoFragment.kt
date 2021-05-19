package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.quizapp.databinding.FragmentAboutBinding
import com.example.quizapp.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentInfoBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_info , container , false)
        return binding.root
    }

    
}