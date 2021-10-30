package org.techtown.roomkotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).allowMainThreadQueries().build()

    fun getAll(): LiveData<List<Todo?>?> {
        return db.todoDao().getAll()
    }

    suspend fun insert(todo: Todo){ //suspend coroutine안으로 무조건 넣어달라는뜻.
        db.todoDao().insert(todo)
    }
}

class MainAndroidViewModel(application: Application): AndroidViewModel(application){

}