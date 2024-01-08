package com.experiments.experimenttictactoe

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.experiments.experimenttictactoe.ticTacToe.BoardLogic
import com.experiments.experimenttictactoe.databinding.ActivityMainGameBinding
import com.experiments.experimenttictactoe.ticTacToe.GameLogic

class MainGameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainGameBinding
    private val boardLogic = BoardLogic()
    private val gameLogic = GameLogic()

    private var player = 1
    private var numRows = 3
    private var numColumns = 3
    private var board = Array(numRows) { Array(numColumns) { 0 } }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (row in 0 until numRows)
            for (col in 0 until numColumns) {
                val square = boardLogic.createBoard(this, row, col) {
                    if (!gameLogic.isGameOver()){
                        board[row][col] = player
                        gameLogic.checkPlayerVictory(board, player)
                        player = gameLogic.handleSquareSelected(player, it.getChildAt(0) as TextView)

                        Log.d("BoardObserver", "Current board state:\n${boardToString()}")
                    }
                    else {
                        Log.d("BoardObserver", "Game is Over!!")
                    }
                }
                binding.gridLayout.addView(square)
            }

        gameLogic.gameOverLiveData.observe(this, Observer { gameOver ->
            if (gameOver) {
                Toast.makeText(this, "Player$player victory!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun boardToString(): String {
        val builder = StringBuilder()
        for (row in board) {
            builder.append(row.joinToString(" "))
            builder.append("\n")
        }
        return builder.toString()
    }

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainGameActivity::class.java)
            context.startActivity(intent)
        }
    }
}