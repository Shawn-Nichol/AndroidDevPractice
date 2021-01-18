package com.example.androiddevpractice.room.dbInsert

import android.content.Context
import com.example.androiddevpractice.R
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.room.DevDao

suspend fun workManagerInsert(devDao: DevDao, mContext: Context) {

    var dev = Dev("WorkManager", "ArchitectureComponent", mContext.getString(R.string.WorkManager_Summary))
    devDao.insert(dev)
    dev = Dev("WorkManager", "ArchitectureComponent", mContext.getString(R.string.WorkManager_WorkerClass))
    devDao.insert(dev)
    dev = Dev("WorkManager", "ArchitectureComponent", mContext.getString(R.string.WorkManager_DoWork))
    devDao.insert(dev)
    dev = Dev("WorkManager", "ArchitectureComponent", mContext.getString(R.string.WorkManager_WorkRequest))
    devDao.insert(dev)
    dev = Dev("WorkManager", "ArchitectureComponent", mContext.getString(R.string.WorkManager_Schedule))
    devDao.insert(dev)
    dev = Dev("WorkManager", "ArchitectureComponent", mContext.getString(R.string.WorkManager_Constraints))
    devDao.insert(dev)
    dev = Dev("WorkManager", "ArchitectureComponent", mContext.getString(R.string.WorkManager_BackOffPolicy))
    devDao.insert(dev)
    dev = Dev("WorkManager", "ArchitectureComponent", mContext.getString(R.string.WorkManager_Tag))
    devDao.insert(dev)
    dev = Dev("WorkManager", "ArchitectureComponent", mContext.getString(R.string.WorkManager_inputData))
    devDao.insert(dev)
    dev = Dev("WorkManager", "ArchitectureComponent", mContext.getString(R.string.WorkManager_enqueue))
    devDao.insert(dev)
    dev = Dev("WorkManager", "ArchitectureComponent", mContext.getString(R.string.WorkManager_CancelAndStop))
    devDao.insert(dev)

}