package org.techtown.maskinfokotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.techtown.maskinfokotlin.model.Store
import org.techtown.maskinfokotlin.repository.MaskService
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

        fetchStoreInfo()
    }

    fun fetchStoreInfo(){
        //로딩 시작.
        loadingLiveData.value = true

        viewModelScope.launch {
            //suspend 메서드는 suspend안에서만 되는데 CoroutineScope는 비동기코드로 suspend안에서 동작가능. (자바의 Thread라 생각하면됨).
            val storeInfo = service.fetchStoreInfo(37.187079,127.043002)
            itemLiveData.value = storeInfo.stores
            //로딩끝.
            loadingLiveData.value = false
        }

    }
}