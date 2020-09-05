package com.buggily.skeleton

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.extension.*

@ExperimentalCoroutinesApi
class CoroutineTestExtension : TestInstancePostProcessor,
    BeforeAllCallback,
    AfterEachCallback,
    AfterAllCallback {

    private val dispatcher = TestCoroutineDispatcher()
    private val scope: TestCoroutineScope = TestCoroutineScope(dispatcher)

    override fun postProcessTestInstance(
        testInstance: Any?,
        context: ExtensionContext?
    ) {
        if (testInstance !is CoroutineTestable) return

        testInstance.dispatcher = dispatcher
        testInstance.scope = scope
    }

    override fun beforeAll(context: ExtensionContext?) {
        Dispatchers.setMain(dispatcher)
    }

    override fun afterEach(context: ExtensionContext?) {
        scope.cleanupTestCoroutines()
    }

    override fun afterAll(context: ExtensionContext?) {
        Dispatchers.resetMain()
    }
}