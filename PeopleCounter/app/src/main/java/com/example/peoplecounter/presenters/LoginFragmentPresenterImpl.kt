package com.example.peoplecounter.presenters

import android.util.Log
import com.example.peoplecounter.statemachine.WireStateMachine
import com.example.peoplecounter.statemachine.WireStateMachineEventModel
import com.example.peoplecounter.view.WireRequestDomesticView
import io.reactivex.disposables.CompositeDisposable

class LoginFragmentPresenterImpl {

    private val view: WireRequestDomesticView
    private val compositeDisposable: CompositeDisposable
    private val wireStateMachineEventModel: WireStateMachineEventModel

    constructor(view: WireRequestDomesticView) : this(view,
        CompositeDisposable(), WireStateMachineEventModel.INSTANCE)

    constructor(view: WireRequestDomesticView,
                compositeDisposable: CompositeDisposable, wireStateMachineEventModel: WireStateMachineEventModel) {
        this.view = view
        this.compositeDisposable = compositeDisposable
        this.wireStateMachineEventModel = wireStateMachineEventModel
    }


    fun onLoginClicked() {
        Log.d("LoginFragmentPresenter","next")
        wireStateMachineEventModel.nextScreen(WireStateMachine.LAUNCH_REGISTER_SCREEN)
    }
}