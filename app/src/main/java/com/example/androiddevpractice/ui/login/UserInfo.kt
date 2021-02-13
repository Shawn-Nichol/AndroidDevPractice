package com.example.androiddevpractice.ui.login

class UserInfo {

    var password = 4369
    var userName = "Hulk"


    fun checkPassword(submit: Int?): Boolean {
        if (submit == null) return false
        return submit == password
    }

    fun checkUser(submit: String): Boolean {


        return submit.trim() == userName
    }

}