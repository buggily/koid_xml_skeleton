package com.buggily.skeleton.ui

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule

@HiltAndroidTest
class SkeletonAppTest {

    @get:Rule
    val rule = HiltAndroidRule(this)
}
