package com.yseko.meetup.SearchPage

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yseko.meetup.network.ExpressServiceApi
import com.yseko.meetup.network.ResponseVendor
import kotlinx.coroutines.launch

class SearchPageViewModel():ViewModel() {



    val allVendors = mutableStateListOf<ResponseVendor>()

//    init{
//        getAllVendors()
//    }


    fun getAllVendors(){
        viewModelScope.launch {
            allVendors.clear()
            allVendors.addAll(ExpressServiceApi.retrofitService.getAllVendors().vendors)
        }
    }
}