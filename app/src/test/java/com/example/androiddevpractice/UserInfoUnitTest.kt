package com.example.androiddevpractice

import com.example.androiddevpractice.ui.login.UserInfo
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UserInfoUnitTest {

    lateinit var userInfo: UserInfo
    @Before
    fun setup() {
        userInfo = UserInfo()
    }


    @Test
    fun userInfo_submitUserName_Success() {
        val checkPassword = userInfo.checkPassword(4369)

        Assert.assertTrue(checkPassword)
    }

    @Test
    fun userInfo_submitUserName_Fail() {
        val checkPassword = userInfo.checkPassword(333)
        Assert.assertFalse(checkPassword)
    }

}