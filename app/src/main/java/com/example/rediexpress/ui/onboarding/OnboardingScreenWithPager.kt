package com.example.rediexpress.ui.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.rediexpress.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreenWithPager(modifier: Modifier = Modifier) {

    val page = remember {
        mutableStateOf(0)
    }

    val onboardList = listOf(
        OnboardPage(
            imageId = R.drawable.onboarding_image_first,
            header = "Quick Delivery At Your Doorstep",
            description = "Enjoy quick pick-up and delivery to your destination"
        ),
        OnboardPage(
            imageId = R.drawable.onboarding_image_second,
            header = "Flexible Payment",
            description = "Different modes of payment either before and after delivery without stress"
        ),
        OnboardPage(
            imageId = R.drawable.onboarding_image_third,
            header = "Real-time Tracking",
            description = "Track your packages/items from the comfort of your home till final destination"
        ),
    )

    val pagerState = rememberPagerState(pageCount = {
        onboardList.size})


        HorizontalPager(state = pagerState) {
        page -> OnboardingScreen(){}
    }

}