package com.example.androiddevpractice.room.dbInsert

import android.content.Context
import com.example.androiddevpractice.R
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.room.DevDao

suspend fun serviceInsert(devDao: DevDao, mContext: Context) {

    var dev = Dev("Service", "Service", mContext.getString(R.string.Service_Summary))
    devDao.insert(dev)
    dev = Dev("Service", "Service", mContext.getString(R.string.Service_Background))
    devDao.insert(dev)
    dev = Dev("Service", "Service", mContext.getString(R.string.Service_Foreground))
    devDao.insert(dev)
    dev = Dev("Service", "Service", mContext.getString(R.string.Service_Bound))
    devDao.insert(dev)
    dev = Dev("Service", "Service", mContext.getString(R.string.Service_onStartCommand))
    devDao.insert(dev)
    dev = Dev("Service", "Service", mContext.getString(R.string.Service_StartService))
    devDao.insert(dev)
    dev = Dev("Service", "Service", mContext.getString(R.string.Service_StopService))
    devDao.insert(dev)
    dev = Dev("Service", "Service", mContext.getString(R.string.Service_onBind))
    devDao.insert(dev)
    dev = Dev("Service", "Service", mContext.getString(R.string.Service_IBinder))
    devDao.insert(dev)


}