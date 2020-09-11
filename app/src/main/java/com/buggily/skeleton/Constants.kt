package com.buggily.skeleton

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType

object Constants {
    object Media {
        object Type {
            private const val APPLICATION = "application"
            private const val JSON = "json"

            private const val SEPARATOR = "/"

            val APPLICATION_JSON: MediaType
                get() = getType(APPLICATION, JSON)

            private fun getType(
                vararg types: String
            ): MediaType = types.joinToString(SEPARATOR).toMediaType()
        }
    }

    object Url {
        const val BASE = ""
    }
}