package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Resource IDs are of the form R.<type>.<name>
        //rollButton save the reference to the Button object , not the Button object itself
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener() { rollDice() }
        //Once user open application no Dice will be weird
        rollDice()
    }

    private fun rollDice() {
        //dice is object of Dice
        val dice = Dice(6)

        //roll a dice (the result is 1 - numSides) and equals to diceRoll
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        // when must be exhaustive (means handle all the possible cases)
        // So '6' change to 'else'
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct resource ID
        /* Not yet Optimize version :
        when (diceRoll) {
                1 -> diceImage.setImageResource(R.drawable.dice_1)
                2 -> diceImage.setImageResource(R.drawable.dice_2)
                3 -> diceImage.setImageResource(R.drawable.dice_3)
                4 -> diceImage.setImageResource(R.drawable.dice_4)
                5 -> diceImage.setImageResource(R.drawable.dice_5)
                6 -> diceImage.setImageResource(R.drawable.dice_6)
        } */

        // Update the ImageView with the correct drawable resource ID
        // Use setImageResource() to change the image that's displayed in an ImageView
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        //numSides -> dice side can be updated to 8,12,... if hard-coded need to change many place
        return (1..numSides).random()
    }
}