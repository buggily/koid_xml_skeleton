package com.buggily.skeleton.models.validatable

interface BooleanValidatable : PrimitiveValidatable<Boolean> {

    override val defaultValue: Boolean

    override val value: Boolean
        get() = super.value ?: defaultValue

    override val isValid: Boolean
        get() = value
}
