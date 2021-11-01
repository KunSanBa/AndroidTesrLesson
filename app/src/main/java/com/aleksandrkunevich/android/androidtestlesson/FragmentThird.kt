package com.aleksandrkunevich.android.androidtestlesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentThird : Fragment() {

    companion object {
        const val TAG = "Third"

        fun newInstance() = FragmentThird()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_three, container, false)
}
