package com.iwex.quickmath.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iwex.quickmath.R

class GameFinishedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_finished, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = GameFinishedFragment()
    }
}