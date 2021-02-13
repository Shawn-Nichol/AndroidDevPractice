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
    fun checkPassword_submitUserName_Success() {
        val checkPassword = userInfo.checkPassword(4369)

        Assert.assertTrue(checkPassword)
    }

    @Test
    fun checkPassword_submitUserName_Fail() {
        val checkPassword = userInfo.checkPassword(333)
        Assert.assertFalse(checkPassword)
    }

    @Test
    fun checkPassword_noPassword() {
        val checkPassword = userInfo.checkPassword(null)
        Assert.assertFalse(checkPassword)
    }

    @Test
    fun checkUser_Success() {
        val userName = userInfo.checkUser("Hulk")

        Assert.assertTrue(userName)
    }

    @Test
    fun checkUser_Fail() {
        val userName =userInfo.checkUser("Not Hulk")
        Assert.assertFalse(userName)
    }

    @Test
    fun checkUser_LeadingWhiteSpace_Success() {
        val userName = userInfo.checkUser("   Hulk")

        Assert.assertTrue(userName)
    }

    @Test
    fun checkUser_TrailingWhiteSpace_Success() {
        val userName = userInfo.checkUser("Hulk    ")
        Assert.assertTrue(userName)
    }

    @Test
    fun checkUser_NotCapitalized_fail() {
        val userName = userInfo.checkUser("hulk")
        Assert.assertFalse(userName)
    }

}