package org.techtown.hilteexample.ui.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.techtown.hilteexample.R
import org.techtown.hilteexample.ui.data.MyRepository

class SecondActivity : AppCompatActivity() {

    val repository = MyRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d("SecondActivity", "${repository.hashCode()}")
    }
}