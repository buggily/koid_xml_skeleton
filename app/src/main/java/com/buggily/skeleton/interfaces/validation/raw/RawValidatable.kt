package com.buggily.skeleton.interfaces.validation.raw

import com.buggily.skeleton.interfaces.validation.Validatable

interface RawValidatable<T : Validatable> {
    val validatable: T
}