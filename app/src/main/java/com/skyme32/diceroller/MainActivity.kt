/*
 * Author: Marcos Mejias
 * marcosmejiasg@gmail.com
 *
 */
package com.skyme32.diceroller

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    lateinit var linearView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        linearView = findViewById(R.id.view)
        linearView.setOnClickListener {
            rollDice(diceImage)
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(diceImage: ImageView) {
        diceImage.setImageResource(getRandomDiceImage())
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun getRandomDiceImage() : Int {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)

        // Update the screen with the dice roll
        return when (dice.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}