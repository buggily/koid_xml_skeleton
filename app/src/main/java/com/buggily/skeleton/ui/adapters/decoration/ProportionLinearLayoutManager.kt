package com.buggily.skeleton.ui.adapters.decoration

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProportionLinearLayoutManager (
    context: Context?,
    orientation: Int,
    reverseLayout: Boolean,
    override val proportion: Float,
) : LinearLayoutManager(
    context,
    orientation,
    reverseLayout
), ProportionLayoutManager {

    override val ori: Int = orientation

    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean = checkLayoutParams(
        width = width,
        height = height,
        lp = lp,
    )
}
