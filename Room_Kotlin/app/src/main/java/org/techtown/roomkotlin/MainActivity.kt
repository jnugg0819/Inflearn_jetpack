package org.techtown.roomkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val mainViewModel:MainViewModel by viewModels()//viewModel 쉽게 쓰는방법(tip Java 1.8로 맞춰줌)

    val mainAndroidViewModel: MainAndroidViewModel by viewModels() //AndroidViewModel.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Db안에있는 값을 관찰중 그리고 변경사항이 있는지 확인후 텍스트에다 뿌려줍니다. 밑에 주석처리한 코드랑 같은거겠죠.
        mainViewModel.getAll().observe(this, Observer { todos ->
            result_text.text = todos.toString()
        })

        add_button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                mainViewModel.insert(Todo(todo_edit.text.toString()))
            }
//            result_text.text = db.todoDao().getAll().toString() 여기서 번거롭게 디비에값을 불러와줌.
        }

    }
}