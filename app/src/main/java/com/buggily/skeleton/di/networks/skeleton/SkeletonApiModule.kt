package com.buggily.skeleton.di.networks.skeleton

import com.buggily.skeleton.interfaces.networks.skeleton.SkeletonApi
import com.buggily.skeleton.networks.skeleton.SkeletonNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object SkeletonApiModule {

    @Provides
    fun provideSkeletonApi(): SkeletonApi = SkeletonNetwork.api
}