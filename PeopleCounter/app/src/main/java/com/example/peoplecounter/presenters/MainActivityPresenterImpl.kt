package com.example.peoplecounter.presenters

import android.content.Context
import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LifecycleOwner
import com.example.peoplecounter.MainActivity
import com.example.peoplecounter.fragments.LoginFragment
import com.example.peoplecounter.statemachine.WireStateMachine
import com.example.peoplecounter.statemachine.WireStateMachineEventModel
import com.example.peoplecounter.view.MainActivityView
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class MainActivityPresenterImpl: MainActivityPresenter{


    private val wireStateMachineEventModel: WireStateMachineEventModel
    private val compositeDisposable: CompositeDisposable
    private val mainActivityView: MainActivityView

    constructor(mainActivityView: MainActivityView)
            : this(mainActivityView, CompositeDisposable(), WireStateMachineEventModel.INSTANCE)

    constructor(mainActivityView: MainActivityView, compositeDisposable: CompositeDisposable, wireStateMachineEventModel: WireStateMachineEventModel) {
        this.mainActivityView = mainActivityView
        this.compositeDisposable = compositeDisposable
        this.wireStateMachineEventModel = wireStateMachineEventModel
    }

    override fun onCreate(owner: LifecycleOwner) {
        subscribeWireStateMachine()
    }


    @VisibleForTesting
    fun subscribeWireStateMachine() {
        compositeDisposable.add(wireStateMachineEventModel.getNextScreen()
            .throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe(
                { wireStateMachineDataModel ->
                    when (wireStateMachineDataModel.screenName) {
                       // WireStateMachine.LAUNCH_LEARN_MORE_SCREEN -> wireActivityView.launchLearnMoreScreen(wireStateMachineDataModel.bundle)
                       WireStateMachine.LAUNCH_REGISTER_SCREEN -> mainActivityView.launchRegisterScreen()
                    }
                },
                { Log.d("ERROR","Login") }
            ))
    }

    override fun onDestroy(owner: LifecycleOwner) {
        compositeDisposable.clear()
        super.onDestroy(owner)
    }

    override fun handleFabExit() {
        TODO("Not yet implemented")
    }
}