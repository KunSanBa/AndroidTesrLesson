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
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFirstFragment()
    }

    override fun onStart() {
        super.onStart()

        activity_main_button_click_me.setOnClickListener {
            openFragment()
        }
    }

    private fun openFragment() {
        when (count) {
            0 -> changeFragment(FragmentOne.newInstance(), FragmentOne.TAG)
            1 -> changeFragment(FragmentTwo.newInstance(), FragmentTwo.TAG)
            2 -> changeFragment(FragmentThird.newInstance(), FragmentThird.TAG)
        }
        count = (count + 1) % 3
    }

    private fun changeFragment(fragment: Fragment, tagUse: String) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(tagUse)
            .replace(
                R.id.activity_main_framelayout_container,
                fragment,
                tagUse
            )
            .commit()
    }

    private fun addFirstFragment() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(FragmentOne.TAG)
            .add(R.id.activity_main_framelayout_container, FragmentOne.newInstance())
            .commit()
    }
}
