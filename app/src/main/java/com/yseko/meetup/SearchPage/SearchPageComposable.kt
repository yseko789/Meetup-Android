package com.yseko.meetup.SearchPage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yseko.meetup.network.ResponseVendor


@Composable
fun SearchScreen(
    viewModel: SearchPageViewModel = viewModel(),
    modifier: Modifier = Modifier
){
    LaunchedEffect(Unit){
        viewModel.getAllVendors()
    }
    VendorList(
        viewModel.allVendors
    )
}

@Composable
fun VendorList(
    allVendors: List<ResponseVendor>,
    modifier: Modifier = Modifier
){
    LazyColumn{
        items(allVendors){vendor->
            VendorItem(vendor)
        }
    }
}

@Composable
fun VendorItem(
    vendor: ResponseVendor,
    modifier: Modifier = Modifier
){
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
    ){
        Row(
            modifier = Modifier
        ){
            Column(
                modifier = Modifier
            ){
                Text(
                    text = vendor.name,
                    modifier = Modifier
                )
                Text(
                    text = vendor.number,
                    modifier = Modifier
                )
            }
            Column(
                modifier = Modifier
            ){
                Text(
                    text = vendor.location,
                    modifier = Modifier
                )
                Text(
                    text = vendor.time,
                    modifier = Modifier
                )
            }
            Box(
                modifier = Modifier
            ){
                Text(
                    text = "${vendor.peopleCurrent}/${vendor.peopleNeeded}",
                    modifier = Modifier
                )
            }
        }

    }
}