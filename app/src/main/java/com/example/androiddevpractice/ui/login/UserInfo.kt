package com.example.androiddevpractice.ui.login

class UserInfo {

    var password = 4369
    var userName = ""


    fun checkPassword(submit: Int): Boolean {
        var success = false

        if(password == submit) {
            success = true

        }

        return success
    }

}