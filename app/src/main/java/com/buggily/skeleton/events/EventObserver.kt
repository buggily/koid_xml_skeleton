package com.buggily.skeleton.events

import androidx.lifecycle.Observer

class EventObserver<T>(
    private val onEventIfUnhandled: (value: T) -> Unit,
) : Observer<EventWithValue<T>?> {

    override fun onChanged(event: EventWithValue<T>?) {
        event?.onEventIfUnhandled(onEventIfUnhandled)
    }
}
