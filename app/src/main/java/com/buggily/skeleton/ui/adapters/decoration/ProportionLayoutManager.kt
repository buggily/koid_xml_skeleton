package com.buggily.skeleton.ui.adapters.decoration

import androidx.recyclerview.widget.RecyclerView

interface ProportionLayoutManager {

    val ori: Int
    val proportion: Float

    fun checkLayoutParams(
        width: Int,
        height: Int,
        lp: RecyclerView.LayoutParams?,
    ): Boolean {
        when (ori) {
            RecyclerView.HORIZONTAL -> lp?.width = getDimension(width)
            RecyclerView.VERTICAL -> lp?.height = getDimension(height)
        }

        return true
    }

    private fun getDimension(dimension: Int): Int = (dimension * proportion).toInt()
}
