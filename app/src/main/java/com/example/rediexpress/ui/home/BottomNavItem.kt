package com.example.rediexpress.ui.home

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.rediexpress.R

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val selectedIcon: Int,
    val unselectedIcon: Int
){
    object Home: BottomNavItem(
        route = "home",
        title = "Home",
        selectedIcon = R.drawable.home_icon_selected,
        unselectedIcon = R.drawable.home_icon_unselected
    )
    object Wallet: BottomNavItem(
        route = "wallet",
        title = "Wallet",
        selectedIcon = R.drawable.icon_wallet_selected,
        unselectedIcon = R.drawable.icon_wallet_unselected
    )
    object Track: BottomNavItem(
        route = "track",
        title = "Track",
        selectedIcon = R.drawable.icon_track_selected,
        unselectedIcon = R.drawable.icon_track_unselected
    )
    object Profile: BottomNavItem(
        route = "profile",
        title = "Profile",
        selectedIcon = R.drawable.icon_profile_selected,
        unselectedIcon = R.drawable.icon_profile_unselected
    )
}
