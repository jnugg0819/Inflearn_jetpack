package org.techtown.roomkotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.techtown.roomkotlin2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this //LiveData를 활용하기 위함이다.

        val viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        binding.viewModel = viewModel

//        add_button.setOnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
//                viewModel.insert(todo_edit.text.toString())
//            }
//        }

    }
}