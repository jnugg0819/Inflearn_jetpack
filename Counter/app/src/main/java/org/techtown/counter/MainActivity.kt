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
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewmodel by viewModels<MainViewModel>()

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"onCreate: ")

        viewmodel.countLiveData.observe(this, Observer { count ->
            counter_text.text = "$count"
        })

        add_button.setOnClickListener {
            viewmodel.increaseCount()
        }

        sub_button.setOnClickListener {
            viewmodel.decreaseCount()
        }

    }

    companion object{
        val TAG = MainActivity::class.java.simpleName
    }
}