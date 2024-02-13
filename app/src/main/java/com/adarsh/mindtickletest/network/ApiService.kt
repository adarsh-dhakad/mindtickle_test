package com.adarsh.mindtickletest.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/beers")//?page=2&per_page=80")
    fun getDashBoardData(
        @Query("page") page : Int,
        @Query("per_page") size :Int
    ):Response<Any>
}