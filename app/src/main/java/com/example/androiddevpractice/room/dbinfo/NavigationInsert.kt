package com.example.androiddevpractice.room.dbinfo

import android.content.Context
import com.example.androiddevpractice.R
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.room.DevDao

suspend fun navigationInsert(devDao: DevDao, mContext: Context) {
    // Navigation
    var dev = Dev("Navigation", "Navigation", mContext.getString(R.string.navigation_summary))
    devDao.insert(dev)
    dev = Dev("Navigation", "Navigation", mContext.getString(R.string.navigation_graph))
    devDao.insert(dev)
    dev = Dev("Navigation", "Navigation", mContext.getString(R.string.navigation_nav_host))
    devDao.insert(dev)
    dev = Dev("Navigation", "Navigation", mContext.getString(R.string.navigation_nav_controller))
    devDao.insert(dev)
    dev = Dev("Navigation", "Navigation", mContext.getString(R.string.navigation_navigation_benefits))
    devDao.insert(dev)
    dev = Dev("Navigation", "Navigation", mContext.getString(R.string.navigation_destination))
    devDao.insert(dev)
    dev = Dev("Navigation", "Navigation", mContext.getString(R.string.navigation_conditional_navigation))
    devDao.insert(dev)
    // Navigation Principles of navigation
    dev = Dev("Principles Of Navigation", "Navigation", mContext.getString(R.string.navigation_principles_of_navigation_fixed))
    devDao.insert(dev)
    dev = Dev("Principles Of Navigation", "Navigation", mContext.getString(R.string.navigation_principles_of_navigation_stack))
    devDao.insert(dev)
    dev = Dev("Principles Of Navigation", "Navigation", mContext.getString(R.string.navigation_principles_of_navigation_up_and_back))
    devDao.insert(dev)
    dev = Dev("Principles Of Navigation", "Navigation", mContext.getString(R.string.navigation_principles_of_navigation_deep_link))
    devDao.insert(dev)

    // Navigation NavGraph
    dev = Dev("NavGraph", "Navigation", mContext.getString(R.string.navigation_NavGraph_summary))
    devDao.insert(dev)
    dev = Dev("NavGraph", "Navigation", mContext.getString(R.string.navigation_NavGraph_TopLevel))
    devDao.insert(dev)
    dev = Dev("NavGraph", "Navigation", mContext.getString(R.string.navigation_NavGraph_GlobalActions))
    devDao.insert(dev)
    dev = Dev("NavGraph", "Navigation", mContext.getString(R.string.navigation_NavGraph_NestedGraphs_summary))
    devDao.insert(dev)
    dev = Dev("NavGraph", "Navigation", mContext.getString(R.string.navigation_NavGraph_NestedGraphs_create))
    devDao.insert(dev)

    // Navigation Navigate
    dev = Dev("Navigate", "Navigation", mContext.getString(R.string.navigation_Navigate_summary))
    devDao.insert(dev)
    dev = Dev("Navigate", "Navigation", mContext.getString(R.string.navigation_Navigate_safe_args))
    devDao.insert(dev)
    dev = Dev("Navigate", "Navigation", mContext.getString(R.string.navigation_Navigate_with_id))
    devDao.insert(dev)
    dev = Dev("Navigate", "Navigation", mContext.getString(R.string.navigation_Navigate_action))
    devDao.insert(dev)
    dev = Dev("Navigate", "Navigation", mContext.getString(R.string.navigation_Navigate_DeepLink))
    devDao.insert(dev)

    // Navigation Pass data
    dev = Dev("PassData", "Navigation", mContext.getString(R.string.navigation_PassData_summary))
    devDao.insert(dev)
    dev = Dev("PassData", "Navigation", mContext.getString(R.string.navigation_PassData_Arguments))
    devDao.insert(dev)
    dev = Dev("PassData", "Navigation", mContext.getString(R.string.navigation_PassData_support))
    devDao.insert(dev)
    dev = Dev("PassData", "Navigation", mContext.getString(R.string.navigation_PassData_safe_args))
    devDao.insert(dev)

}