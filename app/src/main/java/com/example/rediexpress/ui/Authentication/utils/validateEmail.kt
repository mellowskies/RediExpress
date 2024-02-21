package com.example.rediexpress.ui.Authentication.utils

import android.util.Patterns

fun validateEmail(email: String): Boolean {
    return email.matches(Patterns.EMAIL_ADDRESS.toRegex())
}