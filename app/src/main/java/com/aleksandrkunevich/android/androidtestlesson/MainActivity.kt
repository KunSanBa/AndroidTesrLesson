package com.aleksandrkunevich.android.androidtestlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        btn.setOnClickListener {
            openFragment()
        }

    }

    private fun openFragment() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(FirstFragment.TAG)
            .add(R.id.container, FirstFragment.newInstance())
            .commit()
    }

}