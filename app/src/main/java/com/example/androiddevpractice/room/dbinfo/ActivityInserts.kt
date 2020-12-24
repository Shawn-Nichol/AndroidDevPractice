package com.example.androiddevpractice.room.dbinfo

import android.content.Context
import com.example.androiddevpractice.R
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.room.DevDao

suspend fun activityInserts(devDao: DevDao, mContext: Context) {

    var  dev = Dev("Activity", "Activity", mContext.getString(R.string.activity_summary))
    devDao.insert(dev)
    dev = Dev("Configuration Change", "Activity", mContext.getString(R.string.activity_configuration_change_summary))
    devDao.insert(dev)
    dev = Dev("Process Lifecycle", "Activity", mContext.getString(R.string.activity_process_lifecycle_summary))
    devDao.insert(dev)
    dev = Dev("Saving Persistent State", "Activity", mContext.getString(R.string.activity_saving_persistent_data_summary))
    devDao.insert(dev)

    // Activity Lifecycle
    dev = Dev("Lifecycle", "Activity", mContext.getString(R.string.activity_lifecycle_summary) )
    devDao.insert(dev)
    dev = Dev("Lifecycle", "Activity", mContext.getString(R.string.activity_lifecycle_onCreate) )
    devDao.insert(dev)
    dev = Dev("Lifecycle", "Activity", mContext.getString(R.string.activity_lifecycle_onRestart))
    devDao.insert(dev)
    dev = Dev("Lifecycle", "Activity", mContext.getString(R.string.activity_lifecycle_onStart))
    devDao.insert(dev)
    dev = Dev("Lifecycle", "Activity", mContext.getString(R.string.activity_lifecycle_onPause))
    devDao.insert(dev)
    dev = Dev("Lifecycle", "Activity", mContext.getString(R.string.activity_lifecycle_onStop))
    devDao.insert(dev)
    dev = Dev("Lifecycle", "Activity", mContext.getString(R.string.activity_lifecycle_onDestroy))
    devDao.insert(dev)
}