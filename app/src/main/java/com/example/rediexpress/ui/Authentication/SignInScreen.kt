package com.example.rediexpress.ui.Authentication

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rediexpress.R
import com.example.rediexpress.ui.Authentication.utils.validateEmail
import com.example.rediexpress.ui.Authentication.viewmodel.SignInViewModel
import com.example.rediexpress.ui.theme.PrimaryColor
import com.example.rediexpress.ui.theme.TextColor1
import com.example.rediexpress.ui.theme.TextColor4
import com.example.rediexpress.ui.theme.WarningColor

@Composable
fun SignInScreen(modifier: Modifier = Modifier, onClick: () -> Unit) {

    var emailAddress by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val isPasswordVisible = remember {
        mutableStateOf(false)
    }

    var isChecked by remember {
        mutableStateOf(false)
    }

    val signInViewModel: SignInViewModel = viewModel()

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Column(
            modifier = Modifier.padding(top = 110.dp, start = 24.dp),
        ) {
            Text(
                text = "Welcome Back",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
                lineHeight = 30.sp,
                color = TextColor1
            )
            Text(
                text = "Fill in your email and password to continue",
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                lineHeight = 16.sp,
                color = TextColor4
            )
            Column(
                modifier = Modifier.padding(top = 33.dp)
            ) {
                Text(
                    text = "Email Address",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 16.sp,
                    color = TextColor4
                )
                OutlinedTextField(
                    value = emailAddress,
                    onValueChange = { emailAddress = it },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .width(342.dp),
                    placeholder = {
                        Text(
                            text = "***********@mail.com",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight(500),
                            fontSize = 14.sp,
                            lineHeight = 16.sp,
                            color = TextColor4
                        )
                    },
                    shape = RoundedCornerShape(4.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
            }
            Column(
                modifier = Modifier.padding(top = 33.dp)
            ) {
                Text(
                    text = "Password",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 16.sp,
                    color = TextColor4
                )
                OutlinedTextField(value = password,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .width(342.dp),
                    placeholder = {
                        Text(
                            text = "**********",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight(500),
                            fontSize = 14.sp,
                            lineHeight = 16.sp,
                            color = TextColor4
                        )
                    },
                    shape = RoundedCornerShape(4.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                isPasswordVisible.value = !isPasswordVisible.value
                            },
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.eye_slash),
                                contentDescription = "",
                                tint = Color.Black,
                                modifier = Modifier
                            )
                        }
                    })
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 17.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = it
                    },
                    modifier = Modifier
                        .width(14.dp)
                        .height(14.dp),
                    colors = CheckboxDefaults.colors(
                        checkedColor = PrimaryColor,
                        uncheckedColor = TextColor4,
                        checkmarkColor = Color.White
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Remember Password",
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500),
                        color = TextColor4
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Forgot Password?",
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500),
                        color = PrimaryColor
                    )
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, bottom = 189.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Button(
            onClick = {
                if (validateEmail(emailAddress)) {
                    signInViewModel.signIn(context, emailAddress, password)
                    onClick()
                } else {
                    Toast.makeText(context, "Email Is Invalid", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
            shape = RoundedCornerShape(4.69.dp),
            modifier = Modifier
                .width(342.dp)
                .height(46.dp)
        ) {
            Text(
                text = "Log In",
                color = Color.White,
                fontWeight = FontWeight(700),
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                    append(" Sign In")
                },
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable {
                        // TODO:
                    }
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "or sign in using",
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                color = TextColor4
            )
            Spacer(modifier = Modifier.height(8.dp))
            IconButton(onClick = {
                // TODO:
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = "",
                    tint = WarningColor,
                    modifier = Modifier
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun SignInPreview() {
    SignInScreen {}
}
