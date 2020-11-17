package com.example.androiddevpractice.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Dev::class), version = 1, exportSchema = false)
abstract class DevDatabase : RoomDatabase() {
    // Database exposes the DAOs through an abstract getter, for each DAO
    abstract fun devDao(): DevDao

    // Populate
    private class DevDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var devDao = database.devDao()
                     // delete all
                    devDao.deleteAll()

                    // add dev topics
                    var dev = Dev("Button", "View")
                    devDao.insert(dev)
                    dev = Dev("TextInput","View")
                    devDao.insert(dev)
                    dev = Dev("FAB", "User Interface")
                    devDao.insert(dev)
                    dev = Dev("Activity", "Component")
                    devDao.insert(dev)
                    dev = Dev("BoundService", "Service")
                    devDao.insert(dev)
                    dev = Dev("Foreground", "Service")
                    devDao.insert(dev)
                    dev = Dev("Service", "Service")
                    devDao.insert(dev)
                }
            }
        }
    }

    companion object {
        //Singleton prevents multiple instance of database from opening.
        @Volatile
        private var INSTANCE: DevDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): DevDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DevDatabase::class.java,
                    "dev_database"
                ).addCallback(DevDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }

        }
    }
}