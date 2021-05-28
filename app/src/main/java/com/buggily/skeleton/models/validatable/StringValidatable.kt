package com.buggily.skeleton.models.validatable

interface StringValidatable : PrimitiveValidatable<String> {

    override val defaultValue: String
        get() = DEFAULT

    override val value: String
        get() = initValue ?: defaultValue

    private companion object {
        private const val DEFAULT = ""
    }
}
