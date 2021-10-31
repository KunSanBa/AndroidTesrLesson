/*
2. Реализовать activity с заголовком (TextView) и одной кнопкой.
Заголовок вверху экрана, кнопка внизу экрана.
По первому нажатию на кнопку открывается первый фрагмент, по второму второй, по третьему третий.
Контент внутри фрагментов произвольный. Фоны фрагментов разных цветов.

Добавить отступы: кнопки от низа, TextView от верха. Значения отступы произвольны
 */

package com.aleksandrkunevich.android.androidtestlesson

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

private const val NUMBEROFFRAGMENT = 3
private var countNumberFragment = 0
private val fragment = listOf(FragmentOne(), FragmentTwo(), FragmentThird())
private val tag = listOf("0", "1", "2")

class MainActivity : AppCompatActivity() {
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
//        val fragment = MainFragment()
//        Log.d("TAGfragment", "id = ${fragment.tagStruct}")
//        Log.d("TAGfragment", "text = ${fragment.structure.structureText}")
//        Log.d("TAGfragment", "color = ${fragment.structure.structureTextColor}")
//        Log.d("TAGfragment", "size = ${fragment.structure.structureTextSize}")
//        Log.d("TAGfragment", "layout = ${fragment.layoutRes}")
        if (!fragment[countNumberFragment].isAdded
        ) {
            supportFragmentManager
                .beginTransaction()
                .addToBackStack(tag[countNumberFragment])
                .add(
                    R.id.activity_main_framelayout_container,
                    fragment[countNumberFragment]
                )
                .commit()
            Log.d(
                "TAGt",
                "number $countNumberFragment isAdded = ${!fragment[countNumberFragment].isAdded}"
            )
        } else {
            fragment.forEach {
                if (it.isVisible) {
                    supportFragmentManager
                        .beginTransaction()
                        .hide(it)
                        .commit()
                }
            }
            supportFragmentManager
                .beginTransaction()
                .show(fragment[countNumberFragment])
                .commit()
            Log.d(
                "TAGt",
                "number $countNumberFragment show"
            )
        }
        countNumberFragment = (countNumberFragment + 1) % NUMBEROFFRAGMENT
    }
}
