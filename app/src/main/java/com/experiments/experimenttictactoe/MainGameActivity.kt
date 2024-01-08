package com.experiments.experimenttictactoe

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.experiments.experimenttictactoe.ticTacToe.BoardLogic
import com.experiments.experimenttictactoe.databinding.ActivityMainGameBinding
import com.experiments.experimenttictactoe.ticTacToe.GameLogic

class MainGameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainGameBinding
    private val boardLogic = BoardLogic()
    private val gameLogic = GameLogic()
    private var player = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (row in 0 until 3)
            for (col in 0 until 3) {
                val square = boardLogic.createBoard(this, row, col) {
                    player = gameLogic.handleSquareSelected(player, it.getChildAt(0) as TextView)
                }
                binding.gridLayout.addView(square)
            }
    }

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainGameActivity::class.java)
            context.startActivity(intent)
        }
    }
}