package com.buggily.skeleton.interfaces.validation

interface ListValidatable<T : Validatable> : PrimitiveValidatable<List<T?>> {

    override val defaultValue: List<T>
        get() = emptyList()

    override val value: List<T>
        get() = initValue?.filterNotNull()?.filter { it.isValid } ?: defaultValue

    override val valueIfValid: List<T>?
        get() = if (isValid) value else null

    override val isValid: Boolean
        get() = true
}