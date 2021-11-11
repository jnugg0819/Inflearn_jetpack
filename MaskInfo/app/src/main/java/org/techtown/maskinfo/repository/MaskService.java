package org.techtown.maskinfo.repository;

import org.techtown.maskinfo.model.StoreInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MaskService {
    String BASE_URL = "https://gist.githubusercontent.com/";

    @GET("junsuk5/bb7485d5f70974deee920b8f0cd1e2f0/raw/063f64d9b343120c2cb01a6555cf9b38761b1d94/sample.json/?m=300")
    Call<StoreInfo> fetchStoreInfo(@Query("lat") double lat, @Query("lng") double lng);


}
