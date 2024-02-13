package com.adarsh.mindtickletest.repository

import com.adarsh.mindtickletest.network.ApiService
import retrofit2.Response

class DashBoardRepo(val api: ApiService) {
    fun getDashBoardData(page:Int,size:Int):Response<Any>{
        return api.getDashBoardData(page,size)
    }
}