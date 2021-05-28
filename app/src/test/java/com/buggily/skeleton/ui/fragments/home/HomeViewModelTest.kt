package com.buggily.skeleton.ui.fragments.home

import com.buggily.skeleton.CoroutineTestable
import com.buggily.skeleton.InstantTestExtension
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(InstantTestExtension::class)
class HomeViewModelTest : CoroutineTestable {

    override lateinit var dispatcher: TestCoroutineDispatcher
    override lateinit var scope: TestCoroutineScope

    @Test
    fun `empty test`() = dispatcher.runBlockingTest {}
}
