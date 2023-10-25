package br.edu.ifsp.scl.fastcalculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifsp.scl.fastcalculation.Extras.EXTRA_SCORE
import br.edu.ifsp.scl.fastcalculation.databinding.FragmentPointingBinding

class PointingFragment : Fragment() {

    private lateinit var fragmentPointingBinding: FragmentPointingBinding


    private lateinit var score: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            score = it.getString(EXTRA_SCORE).toString()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentPointingBinding = FragmentPointingBinding.inflate(inflater, container, false)

        fragmentPointingBinding.apply {
            finalScoreTv.text = score
            restartGameBt.setOnClickListener{
                (context as OnPLayGame).onPlayGame() //Polimorfismo
            }
        }


        return fragmentPointingBinding.root
    }

    companion object {
        fun newInstance(score: String) =
            PointingFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_SCORE, score)
                }
            }
    }
}