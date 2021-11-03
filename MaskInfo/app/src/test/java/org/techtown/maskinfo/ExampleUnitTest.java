package org.techtown.maskinfo;

import com.squareup.moshi.Moshi;

import org.junit.Test;
import org.techtown.maskinfo.model.StoreInfo;
import org.techtown.maskinfo.repository.MaskService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void retrofitTest() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MaskService.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        MaskService service = retrofit.create(MaskService.class);

        Call<StoreInfo> storeInfoCall = service.fetchStoreInfo();

        StoreInfo storeInfo = storeInfoCall.execute().body();

        assertEquals(222,storeInfo.getCount());
        assertEquals(222,storeInfo.getStores().size());
    }
}