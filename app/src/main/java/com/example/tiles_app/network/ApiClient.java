package com.example.tiles_app.network;

import com.example.tiles_app.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiInterface api;

    public static ApiInterface getClient() {
        if (api == null) {
            final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new HttpLoggingInterceptor());
            httpClient.addInterceptor(chain -> {
                Request request = chain.request()
                        .newBuilder()
                        // add request header
                        .build();
                return chain.proceed(request);
            });
            if (BuildConfig.DEBUG) {
                httpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
            }
            httpClient.retryOnConnectionFailure(true);
            Retrofit retrofitRefresh = new Retrofit.Builder()
                    .baseUrl(APIURL.BASE_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();

            api = retrofitRefresh.create(ApiInterface.class);
        }
        return api;
    }
}

