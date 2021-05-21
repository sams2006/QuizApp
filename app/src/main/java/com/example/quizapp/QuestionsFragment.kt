package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.quizapp.databinding.FragmentAboutBinding
import com.example.quizapp.databinding.FragmentQuestionsBinding


class QuestionsFragment : Fragment() {

    private lateinit var binding : FragmentQuestionsBinding
    private var mQuestionList   = ArrayList<Question>()
    private var mCurrentQuestionIndex : Int = 0
    private var mSelectedOption : Int = -1

    private lateinit var question:Question
    private var correctAnswer : Int = 0
    private var wrongAnswer : Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(inflater , R.layout.fragment_questions , container , false)

        // fill ArrayList
        mQuestionList.add(
            Question(
            1 ,
            "How to write Integer variable in kotlin ?" ,
            "Int" ,
            "Integer" ,
            "int" ,
            0

        ))


        mQuestionList.add(
            Question(
                2 ,
                "How to write Integer variable in kotlin ?" ,
                "Int" ,
                "Integer" ,
                "int" ,
                1

            )
        )

        mQuestionList.add(
            Question(
                3 ,
                "How to write Integer variable in kotlin ?" ,
                "Int" ,
                "Integer" ,
                "int" ,
                2

            )
        )

        mQuestionList.add(
            Question(
                4 ,
                "How to write Integer variable in kotlin ?" ,
                "Int" ,
                "Integer" ,
                "int" ,
                0

            )
        )

        mQuestionList.add(
            Question(
                5 ,
                "How to write Integer variable in kotlin ?" ,
                "Int" ,
                "Integer" ,
                "int" ,
                2

            )
        )

        // fill the views

        setQuestion()

        // submit button

        binding.submitButton.setOnClickListener { view : View ->
         mSelectedOption  = binding.radioGroup2.checkedRadioButtonId
            question = mQuestionList[mCurrentQuestionIndex]
            var answerIndex = 0
            when(mSelectedOption) {
                R.id.firstAnswerRadioButton -> answerIndex = 0
                R.id.secondAnswerRadioButton -> answerIndex = 1
                R.id.thirdAnswerRadioButton -> answerIndex = 2
            }
            if (answerIndex == question.correctAnswer) {
                // correct
                correctAnswer++
                mCurrentQuestionIndex++
                if (mCurrentQuestionIndex < mQuestionList.size){
                    // advance to next question
                    setQuestion()
                    binding.invalidateAll()
                } else {
                    // result screen
                    view.findNavController().navigate(QuestionsFragmentDirections.actionQuestionsFragmentToWinFragment(correctAnswer , wrongAnswer))
                }

            } else {

                // if the user have wrong answer
                wrongAnswer++
                mCurrentQuestionIndex++

                if (wrongAnswer >= 3){
                    view.findNavController().navigate(QuestionsFragmentDirections.actionQuestionsFragmentToGameOverFragment(correctAnswer , wrongAnswer))
                } else {
                    if (mCurrentQuestionIndex < mQuestionList.size){
                        setQuestion()
                        binding.invalidateAll()
                    }else {
                        // result screen
                        view.findNavController().navigate(QuestionsFragmentDirections.actionQuestionsFragmentToWinFragment(correctAnswer , wrongAnswer))
                    }
                }
            }



        }


        return binding.root
    }

    private fun setQuestion(){
       question = mQuestionList[mCurrentQuestionIndex]

        binding.questionText.text = question.questionText
        binding.firstAnswerRadioButton.text = question.optionOne
        binding.secondAnswerRadioButton.text = question.optionTwo
        binding.thirdAnswerRadioButton.text = question.optionThree
    }


}