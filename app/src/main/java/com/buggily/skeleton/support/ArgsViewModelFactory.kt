package com.buggily.skeleton.support

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ArgsViewModelFactory<T>(
    private val args: T,
    private val argsClass: Class<T>,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(
        argsClass,
    ).newInstance(
        args,
    )
}