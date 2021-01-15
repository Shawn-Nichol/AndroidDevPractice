




package com.example.androiddevpractice.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.androiddevpractice.room.dbInsert.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Dev::class), version = 3, exportSchema = true)
abstract class DevDatabase() : RoomDatabase() {
    // Database exposes the DAOs through an abstract getter, for each DAO
    abstract fun devDao(): DevDao

    // Populate
    private class DevDatabaseCallback(
        private val scope: CoroutineScope, val mContext: Context
    ) : RoomDatabase.Callback() {




        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var devDao = database.devDao()
                     // delete all
                    devDao.deleteAll()



                    activityInserts(devDao, mContext)
                    architectureComponentInserts(devDao, mContext)
                    fragmentInsert(devDao, mContext)
                    intnetFilterInsert(devDao, mContext)
                    intnetFilterInsert(devDao, mContext)
                    navigationInsert(devDao, mContext)
                    serviceInsert(devDao, mContext)
                    UIInsert(devDao, mContext)
                    workManagerInsert(devDao, mContext)



//                    // Broadcast Receiver.
//                    dev = Dev("BroadcastReceiver", "BroadcastReceiver", "")
//                    devDao.insert(dev)

//                    // Animation
//                    dev = Dev("Motion Layout", "User Interface", "Animation")
//                    devDao.insert(dev)
//                    dev = Dev("PropertyAnimation", "User Interface", "Animation")
//                    devDao.insert(dev)
//                    dev = Dev("View", "User Interface", "Views")
//                    devDao.insert(dev)
                }
            }
        }
    }

    /**
     * Companion objects are Singleton objects, functions and properties are tied to the class not
     * the object. This prevents multiple instances of the data base being open.
     */
    companion object {
        @Volatile
        private var INSTANCE: DevDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope,): DevDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DevDatabase::class.java,
                    "dev_database"
                ).addCallback(DevDatabaseCallback(scope, context.applicationContext))
                    .build()
                INSTANCE = instance
                return instance
            }

        }
    }
}