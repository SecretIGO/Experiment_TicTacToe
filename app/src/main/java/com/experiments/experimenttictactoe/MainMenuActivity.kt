package com.experiments.experimenttictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.experiments.experimenttictactoe.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bind()
    }

    private fun bind(){
        with(binding){
            parentMainMenu.setOnClickListener {
                MainGameActivity.launch(this@MainMenuActivity)
            }
        }
    }
}