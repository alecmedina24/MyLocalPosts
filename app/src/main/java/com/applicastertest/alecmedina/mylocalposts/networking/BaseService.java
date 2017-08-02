package com.applicastertest.alecmedina.mylocalposts.networking;

import com.applicastertest.alecmedina.mylocalposts.BuildConfig;
import com.applicastertest.alecmedina.mylocalposts.models.autoValue.AutoValueAdapterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.applicastertest.alecmedina.mylocalposts.networking.InstagramApi.BASE_URL;

/**
 * Created by alec.medina on 7/27/17.
 */

public class BaseService {

    private static BaseService baseService;
    private InstagramApi instagramApi;

    public static BaseService getInstance() {
        if (baseService == null) {
            baseService = new BaseService();
        }

        return baseService;
    }

    private BaseService() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            NetworkUtils.setUnsafeOkHttpClient(client);
        }

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new AutoValueAdapterFactory())
                .create();

        instagramApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(InstagramApi.class);
    }

    public final InstagramApi getInstagramApi() {
        return instagramApi;
    }
}
