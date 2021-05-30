package com.example.esiea3a.Presentation.Main

sealed class LoginStatus

data class LoginSuccess(val email:String) : LoginStatus()
object LoginError : LoginStatus()