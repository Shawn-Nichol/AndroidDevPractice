package com.example.androiddevpractice.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Dev::class), version = 2, exportSchema = true)
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

                    // Activity
                    var  dev = Dev("Activity", "Activity", "")
                    devDao.insert(dev)
                    dev = Dev("Lifecycle", "Activity", "")
                    devDao.insert(dev)
                    dev = Dev("Configuration Change", "Activity", "")
                    devDao.insert(dev)
                    dev = Dev("Process Lifecycle", "Activity", "")
                    devDao.insert(dev)
                    dev = Dev("Saving Persistent State", "Activity", "")
                    devDao.insert(dev)

                    // Fragments
                    dev = Dev("What is a Fragment", "Fragment", "")
                    devDao.insert(dev)
                    dev = Dev("LifeCycle", "Fragment", "")
                    devDao.insert(dev)
                    dev = Dev("Load Fragment", "Fragment", "")
                    devDao.insert(dev)
                    dev = Dev("Listenable Interface", "Fragment", "")
                    devDao.insert(dev)
                    dev = Dev("Flexible UI", "Fragment", "" )
                    devDao.insert(dev)
                    dev = Dev("Animation", "Fragment", "Animate & Transition" )
                    devDao.insert(dev)
                    dev = Dev("SharedElement", "Fragment", "Animate & Transition" )
                    devDao.insert(dev)
                    dev = Dev("Transitions Animation", "Fragment", "Animate & Transition" )
                    devDao.insert(dev)


                    // Architecture components
                    dev = Dev("LifeCycle", "Architecture Component", "Coroutines")
                    devDao.insert(dev)
                    dev = Dev("LiveData", "Architecture Component", "Coroutines")
                    devDao.insert(dev)
                    dev = Dev("ViewModelScope", "Architecture Component", "Coroutines")
                    devDao.insert(dev)
                    dev = Dev("DataBinding", "Architecture Component", "DataBinding")
                    devDao.insert(dev)
                    dev = Dev("HandlingLifeCycles", "Architecture Component", "")
                    devDao.insert(dev)
                    dev = Dev("LiveData", "Architecture Component", "")
                    devDao.insert(dev)

                    dev = Dev("Paging", "Architecture Component", "")
                    devDao.insert(dev)
                    dev = Dev("Room", "Architecture Component", "")
                    devDao.insert(dev)
                    dev = Dev("Saving UI States", "Architecture Component", "")
                    devDao.insert(dev)
                    dev = Dev("ViewModel", "Architecture Component", "")
                    devDao.insert(dev)
                    dev = Dev("WorkManager", "Architecture Component", "")
                    devDao.insert(dev)


                    // Broadcast Receiver.
                    dev = Dev("BroadcastReceiver", "BroadcastReceiver", "")
                    devDao.insert(dev)

                    // Intent & intent Filters
                    dev = Dev("Intent", "Intent", "")
                    devDao.insert(dev)
                    dev = Dev("Chooser", "Intent", "")
                    devDao.insert(dev)
                    dev = Dev("Receiving an implicit intent", "Intent", "")
                    devDao.insert(dev)
                    dev = Dev("Intent Resolution", "Intent", "")
                    devDao.insert(dev)
                    dev = Dev("Pending Intent", "Intent", "")
                    devDao.insert(dev)

                    // Navigation
                    dev = Dev("Principles of Navigation", "Navigation", "")
                    devDao.insert(dev)
                    dev = Dev("NavigationGraphs", "Navigation", "")
                    devDao.insert(dev)
                    dev = Dev("NavHostFragment", "Navigation", "")
                    devDao.insert(dev)
                    dev = Dev("Destinations", "Navigation", "")
                    devDao.insert(dev)
                    dev = Dev("Actions", "Navigation", "")
                    devDao.insert(dev)
                    dev = Dev("SafeArgs", "Navigation", "")
                    devDao.insert(dev)
                    dev = Dev("Deep Link", "Navigation", "")
                    devDao.insert(dev)
                    dev = Dev("Nested Nav Graphs", "Navigation", "")
                    devDao.insert(dev)
                    dev = Dev("Animation", "Navigation", "")
                    devDao.insert(dev)
                    dev = Dev("Shared Element", "Navigation", "")
                    devDao.insert(dev)
                    dev = Dev("SharedElement RecyclerView", "Navigation", "")
                    devDao.insert(dev)
                    dev = Dev("Menu Ties", "Navigation", "")
                    devDao.insert(dev)

                    // Service
                    dev = Dev("What is a Service", "Service", "")
                    devDao.insert(dev)
                    dev = Dev("LifeCycle", "Service", "")
                    devDao.insert(dev)
                    dev = Dev("Manifest", "Service", "")
                    devDao.insert(dev)
                    dev = Dev("Process Lifecycle", "Service", "")
                    devDao.insert(dev)
                    dev = Dev("Bound Service", "Service", "")
                    devDao.insert(dev)
                    dev = Dev("Foreground Service", "Service", "")
                    devDao.insert(dev)
                    dev = Dev("Started Service", "Service", "")
                    devDao.insert(dev)
                    dev = Dev("Start and Stop", "Service", "")
                    devDao.insert(dev)


                    // User Interface
                    dev = Dev("AppBar", "User Interface", "AppBar")
                    devDao.insert(dev)
                    dev = Dev("Up Button", "User Interface", "AppBar")
                    devDao.insert(dev)
                    dev = Dev("What is CardView", "User Interface", "Material Design")
                    devDao.insert(dev)
                    dev = Dev("Delay Loading of Views", "User Interface", "Layout Performance")
                    devDao.insert(dev)
                    dev = Dev("Optimizing Layout Hierarchies", "User Interface", "Layout Performance")
                    devDao.insert(dev)
                    dev = Dev("Re-Using", "User Interface", "Layout Performance")
                    devDao.insert(dev)
                    dev = Dev("InputEvents", "User Interface", "Layout Performance")
                    devDao.insert(dev)
                    dev = Dev("Constraint", "User Interface", "Layouts")
                    devDao.insert(dev)
                    dev = Dev("CustomView", "User Interface", "Layouts")
                    devDao.insert(dev)
                    dev = Dev("Motion Layout", "User Interface", "Layouts")
                    devDao.insert(dev)
                    dev = Dev("Adapter", "User Interface", "Layouts")
                    devDao.insert(dev)
                    dev = Dev("LinearLayout", "User Interface", "Layouts")
                    devDao.insert(dev)
                    dev = Dev("FAB", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("Theme & Style", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("App Icon", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("Bitmap 9-Patch", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("Check Boxes", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("Localize UI", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("Pickers", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("Radio Buttons", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("Shadow clips", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("Spinners", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("Toggle Buttons", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("Button", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("ToolTip", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("WebP", "User Interface", "Look and Feel")
                    devDao.insert(dev)
                    dev = Dev("Menu", "User Interface", "Menu")
                    devDao.insert(dev)
                    dev = Dev("Notification", "User Interface", "Notification")
                    devDao.insert(dev)
                    dev = Dev("RecyclerView", "User Interface", "RecyclerView")
                    devDao.insert(dev)
                    dev = Dev("DiffUtil", "User Interface", "RecyclerView")
                    devDao.insert(dev)
                    dev = Dev("Item Decoration", "User Interface", "RecyclerView")
                    devDao.insert(dev)
                    dev = Dev("Item Touch Helper", "User Interface", "RecyclerView")
                    devDao.insert(dev)
                    dev = Dev("Click Listener", "User Interface", "RecyclerView")
                    devDao.insert(dev)
                    dev = Dev("Views", "User Interface", "Views")
                    devDao.insert(dev)
                    dev = Dev("Custom Views", "User Interface", "Views")
                    devDao.insert(dev)
                    dev = Dev("Effects", "User Interface", "Views")
                    devDao.insert(dev)
                    dev = Dev("Clipping", "User Interface", "Views")
                    devDao.insert(dev)
                    dev = Dev("Switch", "User Interface", "Widget")
                    devDao.insert(dev)
                    dev = Dev("Place Holder", "User Interface", "")
                    devDao.insert(dev)
                    dev = Dev("System UI", "UserInterface", "")
                    devDao.insert(dev)
                    dev = Dev("Toast", "User Interface", "")
                    devDao.insert(dev)
                    dev = Dev("Snackbar", "UserInterface", "")
                    devDao.insert(dev)
                    dev = Dev("Dialog", "UserInterface", "")
                    devDao.insert(dev)
                    dev = Dev("Preference", "UserInterface", "")
                    devDao.insert(dev)








                    // Animation
                    dev = Dev("Motion Layout", "User Interface", "Animation")
                    devDao.insert(dev)
                    dev = Dev("PropertyAnimation", "User Interface", "Animation")
                    devDao.insert(dev)
                    dev = Dev("View", "User Interface", "Views")
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