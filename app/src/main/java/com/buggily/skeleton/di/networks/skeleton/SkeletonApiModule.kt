package com.buggily.skeleton.di.networks.skeleton

import com.buggily.skeleton.interfaces.networks.skeleton.SkeletonApi
import com.buggily.skeleton.networks.skeleton.SkeletonNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object SkeletonApiModule {

    @Provides
    @Singleton
    fun provideSkeletonApi(): SkeletonApi = SkeletonNetwork.api
}