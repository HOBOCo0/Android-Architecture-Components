package com.example.jetpackarcitecturecomponetspractice.lifecycleobserver

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jetpackarcitecturecomponetspractice.R

// our observer is created and we need to attach the observer here..
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // this is how we attach observer to the lifecycle methods
        lifecycle.addObserver(Observer())
        Log.d("Observer", "ActivityOnCreateCalled")
    }

    override fun onStart() {
        super.onStart()
        lifecycle.addObserver(Observer())
        Log.d("Observer", "ActivityOnStartCalled")
    }


    override fun onResume() {
        super.onResume()
        lifecycle.addObserver(Observer())
        Log.d("Observer", "ActivityOnResumeCalled")
    }

    override fun onPause() {
        super.onPause()
        lifecycle.addObserver(Observer())
        Log.d("Observer", "ActivityOnPauseCalled")
    }


    override fun onStop() {
        super.onStop()
        lifecycle.addObserver(Observer())
        Log.d("Observer", "ActivityOnStopCalled")
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.addObserver(Observer())
        Log.d("Observer", "ActivityOnDestroyCalled")
    }


}
/*
 1 - (main activity will have minimal code)
So. The benefit is whatever extra code we were writing  now we can write it in Observer class
as it will keep observing the lifecycle of the owner class
 and keep on executing the code

 2 - Our observer is separate class we can attach it with any other Activities/fragments as well
 as it operate independently.
 */

/*
Note :-
In creation phase activity methods called first then observers
but in destruction phase the Observers method called first then activities because activity destroys
everything related to it before destroying itself.

This is how life cycle aware components works ...
  viewModels and liveData are life cycle aware components they observe the life cycle and based on that
  they perform Actions.
 */
