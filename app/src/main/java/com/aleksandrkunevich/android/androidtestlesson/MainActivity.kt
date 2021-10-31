/*
2. Реализовать activity с заголовком (TextView) и одной кнопкой.
Заголовок вверху экрана, кнопка внизу экрана.
По первому нажатию на кнопку открывается первый фрагмент, по второму второй, по третьему третий.
Контент внутри фрагментов произвольный. Фоны фрагментов разных цветов.

Добавить отступы: кнопки от низа, TextView от верха. Значения отступы произвольны
 */

package com.aleksandrkunevich.android.androidtestlesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        activity_main_button_click_me.setOnClickListener {
            openFragment()
        }
    }

    private fun openFragment() {
        when (count) {
            0 -> addFirstFragment()
            1 -> addSecondFragment()
            2 -> addThirdFragment()
        }
        count = (count + 1) % 3
    }

    private fun addFirstFragment() {
        if (supportFragmentManager.findFragmentByTag(FragmentThird.TAG) != null) {
            supportFragmentManager
                .beginTransaction()
                .remove(FragmentThird.newInstance())
                .addToBackStack(FragmentOne.TAG)
                .add(R.id.activity_main_framelayout_container, FragmentOne.newInstance())
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .addToBackStack(FragmentOne.TAG)
                .add(R.id.activity_main_framelayout_container, FragmentOne.newInstance())
                .commit()
        }
    }

    private fun addSecondFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.activity_main_framelayout_container,
                FragmentTwo.newInstance(),
                FragmentTwo.TAG
            )
            .commit()
    }

    private fun addThirdFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.activity_main_framelayout_container,
                FragmentThird.newInstance(),
                FragmentThird.TAG
            )
            .commit()
    }
}
