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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}