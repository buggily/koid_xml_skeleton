package com.buggily.skeleton

import androidx.arch.core.executor.TaskExecutor

class InstantTaskExecutor : TaskExecutor() {
    override fun isMainThread(): Boolean = true
    override fun postToMainThread(runnable: Runnable) = runnable.run()
    override fun executeOnDiskIO(runnable: Runnable) = runnable.run()
}