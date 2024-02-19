package com.example.rediexpress

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rediexpress.ui.Authentication.SignInScreen
import com.example.rediexpress.ui.Authentication.SignUpScreen
import com.example.rediexpress.ui.onboarding.OnboardingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                Color.TRANSPARENT,
                Color.TRANSPARENT,
            )
        )
        setContent {
            RediExpressNavigation()
        }
    }
}
@Composable
fun RediExpressNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "onboarding") {
        composable("onboarding") {
            OnboardingScreen {
                navController.navigate("signup_screen") {
                    popUpTo("signup_screen")
                }
            }
        }

        composable("signup_screen") {
            SignUpScreen() {
                navController.navigate("signin_screen") {
                    popUpTo("signin_screen")
                }
            }
        }

        composable("signin_screen") {
            SignInScreen()
        }
    }
}

@Preview
@Composable
fun RediExpressPrev(modifier: Modifier = Modifier) {
    RediExpressNavigation()
}