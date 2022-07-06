package com.yseko.meetup

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yseko.meetup.SearchPage.SearchScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavBar.Search.route
    ){
        composable(route = BottomNavBar.Search.route){
            SearchScreen()
        }
        composable(route = BottomNavBar.List.route){

        }
        composable(route = BottomNavBar.Account.route){

        }
    }
}