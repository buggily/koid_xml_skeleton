package com.buggily.skeleton.ui.adapters.decoration

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProportionGridLayoutManager(
    context: Context?,
    spanCount: Int,
    orientation: Int,
    reverseLayout: Boolean,
    proportion: Float,
): GridLayoutManager(
    context,
    spanCount,
    orientation,
    reverseLayout
), ProportionLayoutManager {

    override val ori: Int = orientation
    override val proportion: Float = proportion * 1 / spanCount.toFloat()

    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean = checkLayoutParams(
        width = width,
        height = height,
        lp = lp,
    )
}
