package com.buggily.skeleton.ui.fragments.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.buggily.skeleton.interfaces.networks.skeleton.SkeletonApi

class HomeViewModel @ViewModelInject constructor(
    private val api: SkeletonApi
) : ViewModel()