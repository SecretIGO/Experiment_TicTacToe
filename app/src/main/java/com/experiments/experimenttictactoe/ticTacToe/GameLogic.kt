package com.experiments.experimenttictactoe.ticTacToe

import android.widget.TextView

class GameLogic {
    // all codes here must only be related to how the game works
        // like win conditions, ai logic, moves list, possible win and defense strategies

    fun handleSquareSelected(player : Int, textView: TextView) : Int{
        return if (player == 1) {
            textView.text = "X"
            player + 1
        } else {
            textView.text = "O"
            player - 1
        }
    }

    fun checkWinConditions() : Boolean{
        return false
    }
}