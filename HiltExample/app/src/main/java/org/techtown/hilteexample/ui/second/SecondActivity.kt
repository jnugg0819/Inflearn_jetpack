package org.techtown.hilteexample.ui.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import org.techtown.hilteexample.R
import org.techtown.hilteexample.ui.data.MyRepository
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: MyRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d("SecondActivity", "${repository.hashCode()}")
    }
}