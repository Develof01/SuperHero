package com.superheros.mx.features.splash.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * SplashViewModel
 *
 * @author (c) 2022, UVI TECH SAPI De CV, KAVAK
 **/

class SplashViewModel: ViewModel() {

    companion object {
        const val TIME_TO_SHOW_SPLASH = 3000L
    }

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(TIME_TO_SHOW_SPLASH)
            _isLoading.value = true
        }
    }

}