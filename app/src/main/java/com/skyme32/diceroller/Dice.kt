package com.skyme32.diceroller

import java.util.*

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return Random().nextInt(numSides) + 1
        //return (1..numSides).random()
    }
}