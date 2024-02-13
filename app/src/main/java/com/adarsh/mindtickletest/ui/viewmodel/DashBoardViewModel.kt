package com.adarsh.mindtickletest.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adarsh.mindtickletest.repository.DashBoardRepo

class DashBoardViewModel(val repo: DashBoardRepo) : ViewModel() {

    val dashBoardData = MutableLiveData<Any>()
    private var currentPage = 1
    fun getDashBoarData(size:Int){
        val result  = repo.getDashBoardData(currentPage,size)
        if (result.isSuccessful){
            currentPage++
        }
        dashBoardData.postValue(result.body())
    }
}