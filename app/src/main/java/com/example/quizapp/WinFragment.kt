package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.quizapp.databinding.FragmentAboutBinding
import com.example.quizapp.databinding.FragmentWinBinding


class WinFragment : Fragment() {

    private lateinit var args:WinFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWinBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_win , container , false)

        setHasOptionsMenu(true)

        binding.tryAgainButton.setOnClickListener ( Navigation.createNavigateOnClickListener(R.id.action_winFragment_to_questionsFragment) )
         args = WinFragmentArgs.fromBundle(requireArguments())
        binding.totalScore.text = args.numCorrect.toString()
        binding.wrongAnswer.text = args.numWrong.toString()
        return binding.root
    }

    private fun getIntent(): Intent {
        args = WinFragmentArgs.fromBundle(requireArguments())
        // create new intent
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT , getString(R.string.share_text , args.numWrong , args.numCorrect))
        return shareIntent
    }

    private fun sendIntent(){

        startActivity(getIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu , menu)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> sendIntent()
        }
        return super.onOptionsItemSelected(item)
    }
}