package com.experiments.experimenttictactoe.ticTacToe

import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.GridLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

class BoardLogic {
    // all codes here must only be related to the board

    fun createBoard(
        context: Context,
        row: Int,
        col: Int,
        clickCallback: (CardView) -> Unit
    ): CardView {
        val square = CardView(context)

        val textView = TextView(context)
        textView.gravity = Gravity.CENTER
        textView.textSize = 24f

        val textParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        square.addView(textView, textParams)

        val seatSizeInPixels = dp_to_px(context, 120)

        val params = GridLayout.LayoutParams()
        params.rowSpec = GridLayout.spec(row)
        params.columnSpec = GridLayout.spec(col)
        params.width = seatSizeInPixels
        params.height = seatSizeInPixels

        params.rightMargin = dp_to_px(context, 5)
        params.bottomMargin = dp_to_px(context, 5)

        square.layoutParams = params

        var isClicked = false
        square.setOnClickListener {
            if (!isClicked){
                clickCallback.invoke(square)
                isClicked = true
            }
        }

        return square
    }

    private fun dp_to_px(context : Context, dp : Int) : Int{
        return (dp * context.resources.displayMetrics.density).toInt()
    }
}