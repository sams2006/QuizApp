package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.quizapp.databinding.FragmentAboutBinding
import com.example.quizapp.databinding.FragmentWinBinding


class WinFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWinBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_win , container , false)

        binding.tryAgainButton.setOnClickListener ( Navigation.createNavigateOnClickListener(R.id.action_winFragment_to_questionsFragment) )
        val args = WinFragmentArgs.fromBundle(requireArguments())
        binding.totalScore.text = args.numCorrect.toString()
        binding.wrongAnswer.text = args.numWrong.toString()
        return binding.root
    }


}