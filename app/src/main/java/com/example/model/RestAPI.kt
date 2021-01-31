package com.example.model

import com.example.model.entity.GamesList
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface RestAPI {
    @Headers(
        "Client-ID: sd4grh0omdj9a31exnpikhrmsu3v46",
        "Accept: application/vnd.twitchtv.v5+json"
    )
    @GET("top")
    fun loadJokes(): Observable<GamesList>
}