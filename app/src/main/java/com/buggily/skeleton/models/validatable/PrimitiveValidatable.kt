package com.buggily.skeleton.models.validatable

interface PrimitiveValidatable<T> : Validatable {

    val initValue: T?

    val defaultValue: T?
        get() = null

    val value: T?
        get() = initValue ?: defaultValue

    val valueIfValid: T?
        get() = if (isValid) value else null
}
