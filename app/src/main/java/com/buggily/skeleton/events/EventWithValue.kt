package com.buggily.skeleton.events

import java.util.Objects

open class EventWithValue<T>(
    private val value: T,
    isHandled: Boolean = false,
) {

    private var _isHandled: Boolean = isHandled
    private val isHandled: Boolean get() = _isHandled

    fun onEventIfUnhandled(onEventIfUnhandled: (T) -> Unit) {
        getValueIfUnhandled()?.let { onEventIfUnhandled(it) }
    }

    private fun getValueIfUnhandled(): T? = if (isHandled) {
        null
    } else {
        handleValue()
    }

    private fun handleValue(): T {
        setIsHandled()
        return value
    }

    override fun equals(other: Any?): Boolean {
        val event: EventWithValue<*>? = other as? EventWithValue<*>
        return value == event?.value && isHandled == event?.isHandled
    }

    override fun hashCode(): Int = Objects.hashCode(value)

    private fun setIsHandled() {
        setIsHandled(true)
    }

    private fun setIsHandled(isHandled: Boolean) {
        _isHandled = isHandled
    }
}
