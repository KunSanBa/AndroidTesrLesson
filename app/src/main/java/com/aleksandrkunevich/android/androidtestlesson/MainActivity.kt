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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        activity_main_button_click_me.setOnClickListener {
            openRandomFragment()
        }
    }

    private fun openRandomFragment() {
        val fragment = MainFragment()
        Log.d("TAGfragment", "id = ${fragment.tagStruct}")
        Log.d("TAGfragment", "text = ${fragment.structure.structureText}")
        Log.d("TAGfragment", "color = ${fragment.structure.structureTextColor}")
        Log.d("TAGfragment", "size = ${fragment.structure.structureTextSize}")
        Log.d("TAGfragment", "layout = ${fragment.layoutRes}")
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(fragment.tagStruct)
            .add(
                R.id.activity_main_framelayout_container,
                fragment
            )
            .commit()
    }
}
