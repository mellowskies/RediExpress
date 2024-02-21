package com.example.rediexpress.ui.home

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rediexpress.ui.home.screens.Home
import com.example.rediexpress.ui.home.screens.Profile
import com.example.rediexpress.ui.home.screens.Track
import com.example.rediexpress.ui.home.screens.Wallet
import com.example.rediexpress.ui.theme.PrimaryColor

@Composable
fun HomeMainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    BottomBar(navController = navController)

    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            Home()
        }
        composable(BottomNavItem.Wallet.route) {
            Wallet()
        }
        composable(BottomNavItem.Track.route) {
            Track()
        }
        composable(BottomNavItem.Profile.route) {
            Profile()
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomNavItem.Home,
        BottomNavItem.Wallet,
        BottomNavItem.Track,
        BottomNavItem.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                screens.forEach { screen ->
                    NavigationBarItem(
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.unselectedIcon),
                                contentDescription = screen.title,
                                tint = PrimaryColor
                            )
                        },
                        label = {
                            Text(text = screen.title)
                        })
                }
            }
        }
    ) {

    }
}