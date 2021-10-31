package com.aleksandrkunevich.android.androidtestlesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.view.*

private val fragmentList = mutableListOf(
    R.layout.fragment_main,
    R.layout.fragment_second,
    R.layout.fragment_three
)

class MainFragment : Fragment() {
    val structure: StructureFragment = StructureFragment()
    val tagStruct: String = (0..100_000_000).random().toString()
    val layoutRes = fragmentList[(fragmentList.indices).random()]

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(layoutRes, container, false)
        view.fragment_textview.text = structure.structureText
        view.fragment_textview.setTextColor(structure.structureTextColor)
        view.fragment_textview.textSize = structure.structureTextSize
        return view
    }
}