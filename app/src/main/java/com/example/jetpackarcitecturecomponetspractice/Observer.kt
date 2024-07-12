package com.example.jetpackarcitecturecomponetspractice

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewpager2.widget.ViewPager2.Orientation

/*
->This is the observer class which observes the life cycle of other classes which are life cycle owners.
-> There will be certain methods that will be called when there will be any change in lifecycle of owner classess
*/
class Observer: LifecycleObserver {

    // This annotation is used to attach observer to the life Cycle methods
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateObserver(){
        // this is simple function which can be created by any name which will execute based on the life cycle change
        Log.d("Observer","OnCreateObserverCalled")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStartobserver(){
        Log.d("Observer","OnStartObserverCalled")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun  onPauseObserver(){
        Log.d("Observer","OnPauseObserverCalled")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeObserver(){
        Log.d("Observer","OnResumeObserverCalled")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        Log.d("Observer","OnStopObserverCalled")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        Log.d("Observer","OnDestroyObserverCalled")
    }
}