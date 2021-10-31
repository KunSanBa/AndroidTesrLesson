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

private var countNumberFragment = 0
private const val NUMBEROFFRAGMENT = 3
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
        if (supportFragmentManager
                .findFragmentByTag(tag[countNumberFragment]) == null
        ) {
            Log.d("TAGt", "find0 = ${supportFragmentManager
                .findFragmentByTag(tag[0])}")
            Log.d("TAGt", "find1 = ${supportFragmentManager
                .findFragmentByTag(tag[1])}")
            Log.d("TAGt", "find2 = ${supportFragmentManager
                .findFragmentByTag(tag[2])}")
            Log.d("TAGt", "find = ${supportFragmentManager
                .findFragmentByTag(tag[countNumberFragment])}")
            Log.d("TAGt", "tag = ${tag[countNumberFragment]}")
            Log.d("TAGt", "count = $countNumberFragment")
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.activity_main_framelayout_container,
                    fragment[countNumberFragment]
                )
                .commit()
            countNumberFragment = (countNumberFragment + 1) % NUMBEROFFRAGMENT
        }
    }
}
