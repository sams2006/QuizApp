package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.quizapp.databinding.FragmentAboutBinding
import com.example.quizapp.databinding.FragmentStartBinding

// TODO: Rename parameter arguments, choose names that match

class StartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentStartBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_start , container , false)
        return binding.root
    }


}