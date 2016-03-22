package com.creawor.addcamera.common.http;


import com.creawor.addcamera.app.MyApplication;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public final class BaseHttpClient {

    private static Retrofit mRetrofit;

    private static OkHttpClient mClient;

    static {
        mClient = new OkHttpClient.Builder()
                .connectTimeout(5 * 1000, TimeUnit.MILLISECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(mClient)
                .build();
    }

    public static Retrofit newInstance(){
        return mRetrofit;
    }

}
