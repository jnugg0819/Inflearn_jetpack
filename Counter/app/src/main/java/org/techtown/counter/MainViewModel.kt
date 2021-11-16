package org.techtown.counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var count = 0
        set(value) {//위에 count값이 바뀌게 되면은 value값으로 들어오게 될거야.
            countLiveData.value = value
            field = value //해당값을 확정짓겟다하면 field에 넣어둠.
        }

    val countLiveData = MutableLiveData<Int>()

    fun increaseCount(){
        count++
    }

    fun decreaseCount(){
        count--
    }
}