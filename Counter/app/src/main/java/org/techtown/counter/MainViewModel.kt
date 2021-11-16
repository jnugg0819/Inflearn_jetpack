package org.techtown.counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(private val handle: SavedStateHandle) : ViewModel() {
    private var count = handle.get<Int>("count") ?: 0 //saveInstance값 가져옴.(강종되었을때)
        set(value) {//위에 count값이 바뀌게 되면은 value값으로 들어오게 될거야.
            field = value //해당값을 확정짓겟다하면 field에 넣어둠.
            countLiveData.value = value
            handle.set("count", value) //saveInstance값 세팅해줌.
        }

    val countLiveData = MutableLiveData<Int>()

    fun increaseCount(){
        count++
    }

    fun decreaseCount(){
        count--
    }
}