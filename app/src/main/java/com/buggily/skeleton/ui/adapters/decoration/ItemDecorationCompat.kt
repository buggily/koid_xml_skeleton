package com.buggily.skeleton.ui.adapters.decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemDecorationCompat(
    val layout: LayoutOrientation,
    paddingMajor: Float? = null,
    paddingMinor: Float? = null,
    private val hasMajorDecoration: Boolean = false,
    private val hasMinorDecoration: Boolean = false,
) : RecyclerView.ItemDecoration() {

    private val zero: Int
    private val major: Int
    private val minor: Int

    private val horizontal: Int
    private val vertical: Int

    init {
        val orientation: LayoutOrientation.Orientation = layout.orientation

        zero = getPadding(null)
        major = getPadding(paddingMajor)
        minor = getPadding(paddingMinor)

        horizontal = when (orientation) {
            LayoutOrientation.Orientation.HORIZONTAL -> major
            LayoutOrientation.Orientation.VERTICAL -> minor
        }

        vertical = when (orientation) {
            LayoutOrientation.Orientation.HORIZONTAL -> minor
            LayoutOrientation.Orientation.VERTICAL -> major
        }
    }

    sealed class LayoutOrientation(
        open val orientation: Orientation,
        open val spanCount: Int,
    ) {
        data class Linear(
            override val orientation: Orientation,
            override val spanCount: Int,
        ) : LayoutOrientation(
            orientation = orientation,
            spanCount = spanCount
        ) {

            companion object {
                val HORIZONTAL: Linear = Linear(
                    orientation = Orientation.HORIZONTAL,
                    spanCount = LINEAR_SPAN_COUNT,
                )

                val VERTICAL: Linear = Linear(
                    orientation = Orientation.VERTICAL,
                    spanCount = LINEAR_SPAN_COUNT,
                )
            }
        }

        data class Proportion(
            override val orientation: Orientation,
            override val spanCount: Int,
            val proportion: Float,
        ) : LayoutOrientation(
            orientation = orientation,
            spanCount = spanCount,
        )

        enum class Orientation {
            HORIZONTAL,
            VERTICAL;

            val value: Int
                get() = when (this) {
                    HORIZONTAL -> RecyclerView.HORIZONTAL
                    VERTICAL -> RecyclerView.VERTICAL
                }
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position: Int = parent.getChildLayoutPosition(view)
        val spanCount: Int = layout.spanCount
        val remainder: Int = position % spanCount

        val orientation: LayoutOrientation.Orientation = layout.orientation
        val isLastMajor: Boolean = position + spanCount - remainder > state.itemCount - 1
        val isLastMinor: Boolean = remainder == spanCount - 1

        val hasMajor: Boolean = isLastMajor || hasMajorDecoration
        val hasMinor: Boolean = isLastMinor || hasMinorDecoration

        val isLastHorizontal: Boolean = when (orientation) {
            LayoutOrientation.Orientation.HORIZONTAL -> hasMajor
            LayoutOrientation.Orientation.VERTICAL -> hasMinor
        }

        val isLastVertical: Boolean = when (orientation) {
            LayoutOrientation.Orientation.HORIZONTAL -> hasMinor
            LayoutOrientation.Orientation.VERTICAL -> hasMajor
        }

        outRect.run {
            left = horizontal
            top = vertical

            right = if (isLastHorizontal) horizontal else zero
            bottom = if (isLastVertical) vertical else zero
        }
    }

    fun getLayoutManager(
        context: Context?,
        reverseLayout: Boolean = false,
    ): RecyclerView.LayoutManager {
        val orientation: Int = layout.orientation.value

        val spanCount: Int = layout.spanCount
        val isLinear: Boolean = spanCount == LINEAR_SPAN_COUNT

        return when (layout) {
            is LayoutOrientation.Linear -> if (isLinear) {
                LinearLayoutManager(
                    context,
                    orientation,
                    reverseLayout,
                )
            } else {
                GridLayoutManager(
                    context,
                    spanCount,
                    orientation,
                    reverseLayout,
                )
            }
            is LayoutOrientation.Proportion -> {
                val proportion: Float = layout.proportion

                if (isLinear) {
                    ProportionLinearLayoutManager(
                        context = context,
                        orientation = orientation,
                        proportion = proportion,
                        reverseLayout = reverseLayout,
                    )
                } else {
                    ProportionGridLayoutManager(
                        context = context,
                        orientation = orientation,
                        spanCount = spanCount,
                        proportion = proportion,
                        reverseLayout = reverseLayout,
                    )
                }
            }
        }
    }

    private fun getPadding(padding: Float?): Int = padding?.toInt() ?: 0

    companion object {
        const val LINEAR_SPAN_COUNT = 1
    }
}
