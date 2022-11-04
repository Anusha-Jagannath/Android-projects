package com.example.peoplecounter.presenters

import androidx.lifecycle.DefaultLifecycleObserver

interface MainActivityPresenter: DefaultLifecycleObserver {
    fun handleFabExit()
}