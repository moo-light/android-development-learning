package com.example.binhnt_lab10_screen_1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit retrofit;
    private static String baseUrl = "https://649d316f9bac4a8e669d5a7e.mockapi.io/Lab10/";

    public  static Retrofit getClient(){
        if(retrofit== null) {
            retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
