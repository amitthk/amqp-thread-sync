package com.boot.model;

import com.boot.service.IAPIConfiguration;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Component
public class NasdaqDataApiModel implements IAPIConfiguration {

    @Value("${app.nasdaq-api-token}")
    String appNasdaqApiToken;

    private INasdaqDataApiModel nasdaqDataApiWrapper;

    public NasdaqDataApiModel() {
         this.nasdaqDataApiWrapper = new Retrofit.Builder().baseUrl(NASDAQ_API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(new com.google.gson.Gson()))
                .client(okHttpClient())
                .build()
                .create(INasdaqDataApiModel.class);
    }

    @Bean
    public OkHttpClient okHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("x-api-key", appNasdaqApiToken)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        return client;
    }


}
