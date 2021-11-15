package org.techtown.maskinfokotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.techtown.maskinfokotlin.model.Store
import org.techtown.maskinfokotlin.repository.MaskService
import org.techtown.maskinfokotlin.repository.MaskService.MaskService.*
import org.techtown.maskinfokotlin.repository.MaskService.MaskService.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {

    val itemLiveData = MutableLiveData<List<Store>>()
    val loadingLiveData = MutableLiveData<Boolean>()

    private val service: MaskService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(MaskService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

        service = retrofit.create(MaskService::class.java)
    }
}