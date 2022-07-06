package com.yseko.meetup

sealed class BottomNavBar(
    val route: String,
    val title: String,
    val icon: Int
){
    object Search: BottomNavBar(
        route = "search",
        title = "Search",
        icon = R.drawable.ic_baseline_search_24
    )
    object List: BottomNavBar(
        route = "list",
        title = "List",
        icon = R.drawable.ic_baseline_list_24
    )
    object Account: BottomNavBar(
        route = "account",
        title = "Account",
        icon = R.drawable.ic_baseline_account_circle_24
    )
}