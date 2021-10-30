package com.aleksandrkunevich.android.androidtestlesson

val exampleText = listOf("Hello", "Good bay", "Job", "Humor", "Logcat", "Alexandr")
val exampleColor = listOf(R.color.black, R.color.blue, R.color.green, R.color.red)
val exampleTextSize = listOf(10f, 20f, 30f, 40f, 50f)

data class StructureFragment(
    val structureTextColor: Int = exampleColor[(exampleColor.indices).random()],
    val structureText: String = exampleText[(exampleText.indices).random()],
    val structureTextSize: Float = exampleTextSize[(exampleTextSize.indices).random()]
)
