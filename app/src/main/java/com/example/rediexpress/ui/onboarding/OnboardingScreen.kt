package com.example.rediexpress.ui.onboarding

import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rediexpress.R
import com.example.rediexpress.ui.theme.PrimaryColor
import com.example.rediexpress.ui.theme.TextColor1
import com.example.rediexpress.ui.theme.TextColor4

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier, onContinueClicked: () -> Unit) {
    val currentPage = remember {
        mutableIntStateOf(0)
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

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(top = 66.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = onboardList[currentPage.intValue].imageId),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(346.dp)
                    .height(346.dp)
            )

            Text(
                modifier = Modifier
                    .width(287.dp),
                text = onboardList[currentPage.intValue].header,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                color = PrimaryColor,
                fontWeight = FontWeight(700)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                modifier = Modifier
                    .width(311.dp),
                text = onboardList[currentPage.intValue].description,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = TextColor1,
                fontWeight = FontWeight(400)
            )
            if (currentPage.intValue == onboardList.size - 1) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp, vertical = 99.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Button(
                        onClick = {
                            onContinueClicked()
                        }, colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                        shape = RoundedCornerShape(4.69.dp),
                        modifier = Modifier
                            .width(342.dp)
                            .height(46.dp)
                    ) {
                        Text(
                            text = "Sign Up",
                            color = Color.White,
                            fontWeight = FontWeight(700),
                            fontSize = 16.sp
                        )
                    }
                    Text(
                        text = buildAnnotatedString {
                            pushStyle(
                                style = SpanStyle(
                                    color = TextColor4,
                                )
                            )
                            append("Already Signed Up?")
                            pushStyle(
                                style = SpanStyle(
                                    color = PrimaryColor,
                                    fontWeight = FontWeight(500)
                                )
                            )
                            append("Sign In")
                        },
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 20.dp).clickable {

                        }
                    )
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp, vertical = 99.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedButton(
                        modifier = Modifier
                            .width(100.dp)
                            .height(50.dp),
                        border = BorderStroke(1.dp, PrimaryColor),
                        shape = RoundedCornerShape(4.69.dp),
                        onClick = {
                            currentPage.intValue = onboardList.size - 1
                        }
                    ) {
                        Text(
                            text = "Skip",
                            fontSize = 14.sp,
                            color = PrimaryColor,
                            fontWeight = FontWeight(700)
                        )
                    }
                    Button(
                        modifier = Modifier
                            .width(100.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(4.69.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                        onClick = {
                            if (currentPage.intValue < onboardList.size - 1) {
                                currentPage.intValue++
                            }
                        }
                    ) {
                        Text(text = "Next")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnboarding(modifier: Modifier = Modifier) {
    OnboardingScreen {

    }
}