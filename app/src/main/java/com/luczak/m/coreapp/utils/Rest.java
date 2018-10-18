package com.luczak.m.coreapp.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rest {
    private static RestInterface serviceRest;
    private static OkHttpClient okHttpClient;
    private static Gson gson;

    private Rest() {
    }

    public static OkHttpClient getOkClient() {
        return okHttpClient;
    }

    public static Gson getGson() {
        return gson;
    }

    public static RestInterface getRest() {
        return serviceRest;
    }

    public static void init() {
        gson = new GsonBuilder().create();

        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Cfg.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        serviceRest = retrofit.create(RestInterface.class);
    }

    public static void cancel(Call<?> call) {
        try {
            if (!call.isCanceled() && call.isExecuted()) {
                call.cancel();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
