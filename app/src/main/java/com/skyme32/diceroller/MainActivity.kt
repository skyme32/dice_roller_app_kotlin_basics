/*
 * Author: Marcos Mejias
 * marcosmejiasg@gmail.com
 *
 */
package com.skyme32.diceroller

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var diceImage : ImageView
    private lateinit var diceImage2 : ImageView
    private lateinit var linearView: View
    private lateinit var textTotal: TextView
    private var total: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        textTotal = findViewById(R.id.textView)

        linearView = findViewById(R.id.view)
        linearView.setOnClickListener {
            total = 0
            rollDice(diceImage)
            rollDice(diceImage2)
            textTotal.text = total.toString()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(diceImage: ImageView) {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        var roll = dice.roll()
        diceImage.setImageResource(getRandomDiceImage(roll))
        total += roll
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun getRandomDiceImage(num: Int) : Int {

        // Update the screen with the dice roll
        return when (num) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}