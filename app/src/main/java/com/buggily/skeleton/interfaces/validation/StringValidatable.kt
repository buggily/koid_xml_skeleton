package com.buggily.skeleton.interfaces.validation

interface StringValidatable : PrimitiveValidatable<String> {

    override val defaultValue: String
        get() = DEFAULT

    override val value: String
        get() = initValue ?: defaultValue

    private companion object {
        private const val DEFAULT = ""
    }
}