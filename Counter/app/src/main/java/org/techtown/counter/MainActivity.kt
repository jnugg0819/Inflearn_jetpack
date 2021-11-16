package org.techtown.counter

import android.app.Activity
import android.app.Application
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewmodel by viewModels<MainViewModel>()

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"onCreate: ")

        counter_text.text = "${viewmodel.count}"

        add_button.setOnClickListener {
            viewmodel.count++
            counter_text.text = "${viewmodel.count}"
        }

        sub_button.setOnClickListener {
            viewmodel.count--
            counter_text.text = "${viewmodel.count}"
        }

        registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks{
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                Log.d(TAG,"onActivityCreated: ")
            }

            override fun onActivityStarted(p0: Activity) {
                Log.d(TAG,"onActivityStarted: ")
            }

            override fun onActivityResumed(p0: Activity) {
                Log.d(TAG,"onActivityResumed: ")
            }

            override fun onActivityPaused(p0: Activity) {
                Log.d(TAG,"onActivityPaused: ")
            }

            override fun onActivityStopped(p0: Activity) {
                Log.d(TAG,"onActivityStopped: ")
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                Log.d(TAG,"onActivitySaveInstanceState: ")
            }

            override fun onActivityDestroyed(p0: Activity) {
                Log.d(TAG,"onActivityDestroyed: ")
            }

        })

    }

    //앱이 백그라운드에 오래둘경우 강제종료 됐을시 데이터값이 사라지는데 다시 데이터 불러오는 코드.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", viewmodel.count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewmodel.count = savedInstanceState.getInt("count")
    }

    companion object{
        val TAG = MainActivity::class.java.simpleName
    }
}