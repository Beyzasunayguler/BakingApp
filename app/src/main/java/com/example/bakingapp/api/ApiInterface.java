package com.example.bakingapp.api;

import com.example.bakingapp.models.Cakes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json")
    Call<List<Cakes>> getCakes();
}
