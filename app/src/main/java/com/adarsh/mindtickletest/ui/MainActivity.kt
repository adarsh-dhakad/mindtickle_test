package com.adarsh.mindtickletest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adarsh.mindtickletest.databinding.ActivityMainBinding
import com.adarsh.mindtickletest.ui.viewmodel.DashBoardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val dashBoardViewModel: DashBoardViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        callAPi()
        loadNextPage()
        setUpUI()

    }

    private fun callAPi() {
        dashBoardViewModel.getDashBoarData(20)
    }

    private fun loadNextPage() {
        binding.btnNextPage.setOnClickListener {
            dashBoardViewModel.getDashBoarData(10)
        }
    }

    private fun setUpUI() {
        //set recyclerview and adapter
        dashBoardViewModel.dashBoardData.observe(this) {
        }
    }
}