package com.buggily.skeleton

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.buggily.skeleton.ui.SkeletonApplication

class SkeletonTestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application = super.newApplication(
        cl,
        SkeletonApplication::class.java.name,
        context
    )
}
