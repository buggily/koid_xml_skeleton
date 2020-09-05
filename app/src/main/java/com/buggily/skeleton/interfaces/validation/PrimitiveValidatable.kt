package com.buggily.skeleton.interfaces.validation

interface PrimitiveValidatable<T> : Validatable {

    val initValue: T?
    val defaultValue: T?

    val value: T?
        get() = initValue ?: defaultValue

    val valueIfValid: T?
        get() = if (isValid) value else null
}