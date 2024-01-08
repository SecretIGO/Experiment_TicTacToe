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
    private val gameLogic = GameLogic()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gameLogic.playGame(this@MainGameActivity, binding)

        gameLogic.gameOverLiveData.observe(this, Observer { gameOver ->
            if (gameOver) {
                Toast.makeText(this, "Player${gameLogic.player} victory!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainGameActivity::class.java)
            context.startActivity(intent)
        }
    }
}