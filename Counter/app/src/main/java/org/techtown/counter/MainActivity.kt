package org.techtown.counter

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewmodel by viewModels<MainViewModel>()

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.viewModel = viewmodel
        binding.lifecycleOwner = this //이액티비티에 라이프사이클에 맞춰서 동작하겠다. 해당코드가 있어야 liveData가 xml에 binding됨.

    }

    companion object{
        val TAG = MainActivity::class.java.simpleName
    }
}