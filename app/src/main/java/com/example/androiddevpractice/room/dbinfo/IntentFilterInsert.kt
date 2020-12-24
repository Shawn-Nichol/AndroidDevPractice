package com.example.androiddevpractice.room.dbinfo

import android.content.Context
import com.example.androiddevpractice.R
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.room.DevDao

suspend fun intnetFilterInsert(devDao: DevDao, mContext: Context) {
    // Intent & intent Filters
    var dev = Dev("Intent", "Intent", mContext.getString(R.string.intent_summary))
    devDao.insert(dev)
    dev = Dev("Intent", "Intent", mContext.getString(R.string.intent_types))
    devDao.insert(dev)
    dev = Dev("Intent", "Intent", mContext.getString(R.string.intent_category))
    devDao.insert(dev)
    dev = Dev("Intent", "Intent", mContext.getString(R.string.intent_chooser))
    devDao.insert(dev)
    dev = Dev("Intent", "Intent", mContext.getString(R.string.intent_receiving_implicit_intent))
    devDao.insert(dev)
    dev = Dev("Intent", "Intent", mContext.getString(R.string.intent_pending_Intent))
    devDao.insert(dev)
    dev = Dev("Intent", "Intent", mContext.getString(R.string.intent_resolution))
    devDao.insert(dev)
}