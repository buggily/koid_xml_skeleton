package com.buggily.skeleton.networks.skeleton

import com.buggily.skeleton.Constants
import com.buggily.skeleton.interfaces.networks.Network
import com.buggily.skeleton.interfaces.networks.skeleton.SkeletonApi
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
object SkeletonNetwork : Network<SkeletonApi> {

    override val api: SkeletonApi by lazy {
        retrofit.create(SkeletonApi::class.java)
    }

    override val baseUrl: String
        get() = Constants.Url.BASE
}