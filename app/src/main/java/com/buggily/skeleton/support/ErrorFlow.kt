package com.buggily.skeleton.support

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

class ErrorFlow(
    val isValid: Flow<Boolean>,
    hadFocus: Boolean = false,
) {

    private var _hadFocus: Boolean = hadFocus

    private val hadFocus: Boolean
        get() = _hadFocus

    private val lostFocus: MutableStateFlow<Boolean> = MutableStateFlow(false)

    val hasError: Flow<Boolean> = isValid.combine(lostFocus) { isValid, lostFocus ->
        !isValid && lostFocus
    }

    fun setHasFocus(hasFocus: Boolean) {
        if (hasFocus) {
            _hadFocus = true
            return
        }

        if (hadFocus) lostFocus.value = true
    }
}
