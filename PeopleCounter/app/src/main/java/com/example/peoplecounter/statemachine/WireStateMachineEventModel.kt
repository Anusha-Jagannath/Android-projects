package com.example.peoplecounter.statemachine

import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.*

//class WireStateMachineEventModel {
//
//    private var subject: PublishSubject<WireStateMachineDataModel> = PublishSubject.create()
//
//    object Holder {
//        val accountsStateMachineModelEvent = WireStateMachineEventModel()
//    }
//
//    companion object {
//        val INSTANCE: WireStateMachineEventModel by lazy { Holder.accountsStateMachineModelEvent }
//    }
//
//    fun nextScreen(screenName: Int) {
//        Log.d("trigger","move to register screen")
//        subject.onNext(WireStateMachineDataModel(screenName))
//    }
//
//    fun getNextScreen(): PublishSubject<WireStateMachineDataModel> {
//        return subject
//    }
//
//
//}

class WireStateMachineEventModel private constructor(){
    private var subject: PublishSubject<WireStateMachineDataModel> = PublishSubject.create()

    object Holder {
        val accountsStateMachineModelEvent = WireStateMachineEventModel()
    }

    companion object {
        val INSTANCE: WireStateMachineEventModel by lazy { Holder.accountsStateMachineModelEvent }
    }

    fun nextScreen(screenName: Int) {
        Log.d("state","model")
        subject.onNext(WireStateMachineDataModel(screenName))
    }

    fun getNextScreen(): Observable<WireStateMachineDataModel> {
        Log.d("state2","model")
        return subject
    }
}