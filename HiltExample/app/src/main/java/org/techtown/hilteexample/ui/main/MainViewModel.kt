package org.techtown.hilteexample.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.techtown.hilteexample.data.MyRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MyRepository): ViewModel(){

    fun getRepositoryHash() = repository.toString()
}