package org.techtown.roomkotlin2

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class MainViewModel(application: Application): AndroidViewModel(application) {

    private val db = Room.databaseBuilder(application, AppDatabase::class.java,"database-name").build()

    var todos: LiveData<List<Todo>>

    var newTodo: String? = null

    init {
        todos = getAll()
    }

     fun getAll():LiveData<List<Todo>>{
        return db.todoDao().getAll()
    }

     fun insert(todo:String){
        viewModelScope.launch(Dispatchers.IO){
            db.todoDao().insert(Todo(todo))
        }
    }
}