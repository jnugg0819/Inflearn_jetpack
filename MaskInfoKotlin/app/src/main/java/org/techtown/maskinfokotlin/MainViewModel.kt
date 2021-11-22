package org.techtown.maskinfokotlin

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.techtown.maskinfokotlin.model.Store
import org.techtown.maskinfokotlin.repository.MaskService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val service: MaskService,
    private val fusedLocationClient: FusedLocationProviderClient
): ViewModel() {

    val itemLiveData = MutableLiveData<List<Store>>()
    val loadingLiveData = MutableLiveData<Boolean>()

    init {
        fetchStoreInfo()
    }

    @SuppressLint("MissingPermission")
    fun fetchStoreInfo(){
        //로딩 시작.
        loadingLiveData.value = true

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->

            viewModelScope.launch {
                //suspend 메서드는 suspend안에서만 되는데 CoroutineScope는 비동기코드로 suspend안에서 동작가능. (자바의 Thread라 생각하면됨).
                val storeInfo = service.fetchStoreInfo(location.latitude,location.longitude)
                itemLiveData.value = storeInfo.stores.filter{ store->
                    store.remain_stat !=null
                }
                //로딩끝.
                loadingLiveData.value = false
            }
        }.addOnFailureListener{ exception ->
            loadingLiveData.value =false
        }

    }
}