package com.buggily.skeleton.events

import java.util.Objects

open class EventWithValue<T>(
    private val value: T,
    isHandled: Boolean = false,
) {

    private var _isHandled: Boolean = isHandled

    private val isHandled: Boolean
        get() = _isHandled

    fun getValueIfUnhandled(): T? = if (isHandled) {
        null
    } else {
        handleValue()
    }

    private fun handleValue(): T {
        _isHandled = true
        return value
    }

    override fun equals(other: Any?): Boolean {
        val event: EventWithValue<*>? = other as? EventWithValue<*>
        return value == event?.value && isHandled == event?.isHandled
    }

    override fun hashCode(): Int = Objects.hashCode(value)
}
