package com.example.androiddevpractice.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.androiddevpractice.R
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



                    // Activity
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


                    // Architecture components, Coroutines
                    dev = Dev("Coroutines", "Architecture Component", mContext.getString(R.string.ac_coroutines_summary))
                    devDao.insert(dev)
                    dev = Dev("Coroutines", "Architecture Component", mContext.getString(R.string.ac_coroutines_coroutine_scope))
                    devDao.insert(dev)
                    dev = Dev("Coroutines", "Architecture Component", mContext.getString(R.string.ac_coroutines_viewmodel_scope))
                    devDao.insert(dev)
                    dev = Dev("Coroutines", "Architecture Component", mContext.getString(R.string.ac_coroutines_lifecycle_scope))
                    devDao.insert(dev)
                    dev = Dev("Coroutines", "Architecture Component", mContext.getString(R.string.ac_coroutines_suspend))
                    devDao.insert(dev)
                    dev = Dev("Coroutines", "Architecture Component", mContext.getString(R.string.ac_coroutines_livedata))
                    devDao.insert(dev)

                    // Architecture components, DataBinding
                    dev = Dev("DataBinding", "Architecture Component", mContext.getString(R.string.ac_data_binding_expression_language))
                    devDao.insert(dev)
                    dev = Dev("DataBinding", "Architecture Component", mContext.getString(R.string.ac_data_binding_generated_classes))
                    devDao.insert(dev)
                    dev = Dev("DataBinding", "Architecture Component", mContext.getString(R.string.ac_data_binding_binding_object))
                    devDao.insert(dev)
                    dev = Dev("DataBinding", "Architecture Component", mContext.getString(R.string.ac_data_binding_view_id))
                    devDao.insert(dev)
                    dev = Dev("DataBinding", "Architecture Component", mContext.getString(R.string.ac_data_binding_observable_data))
                    devDao.insert(dev)
                    dev = Dev("DataBinding", "Architecture Component", mContext.getString(R.string.ac_data_binding_twoway_data_binding))
                    devDao.insert(dev)

                    // Architecture components, Lifecycle aware
                    dev = Dev("LifeCycle-Aware", "Architecture Component", mContext.getString(R.string.ac_lifecycle_aware_summary))
                    devDao.insert(dev)
                    dev = Dev("LifeCycle-Aware", "Architecture Component", mContext.getString(R.string.ac_lifecycle_aware_lifecycle))
                    devDao.insert(dev)
                    dev = Dev("LifeCycle-Aware", "Architecture Component", mContext.getString(R.string.ac_lifecycle_aware_owner))
                    devDao.insert(dev)
                    dev = Dev("LifeCycle-Aware", "Architecture Component", mContext.getString(R.string.ac_lifecycle_aware_best_practice))
                    devDao.insert(dev)
                    dev = Dev("LifeCycle-Aware", "Architecture Component", mContext.getString(R.string.ac_lifecycle_aware_cases))
                    devDao.insert(dev)
                    dev = Dev("LifeCycle-Aware", "Architecture Component", mContext.getString(R.string.ac_lifecycle_aware_stop_events))
                    devDao.insert(dev)

                    // Architecture components, LiveData
                    dev = Dev("LiveData", "Architecture Component", mContext.getString(R.string.ac_livedata_summary))
                    devDao.insert(dev)
                    dev = Dev("LiveData", "Architecture Component", mContext.getString(R.string.ac_livedata_observer))
                    devDao.insert(dev)
                    dev = Dev("LiveData", "Architecture Component", mContext.getString(R.string.ac_livedata_advantages))
                    devDao.insert(dev)
                    dev = Dev("LiveData", "Architecture Component", mContext.getString(R.string.ac_livedata_working_with))
                    devDao.insert(dev)
                    dev = Dev("LiveData", "Architecture Component", mContext.getString(R.string.ac_livedata_states))
                    devDao.insert(dev)
                    dev = Dev("LiveData", "Architecture Component", mContext.getString(R.string.ac_livedata_transform))
                    devDao.insert(dev)

                    // Architecture components, paging
                    dev = Dev("Paging", "Architecture Component", "")
                    devDao.insert(dev)

                    // Architecture components, Room
                    dev = Dev("Room", "Architecture Component", mContext.getString(R.string.ac_room_database))
                    devDao.insert(dev)
                    dev = Dev("Room", "Architecture Component", mContext.getString(R.string.ac_room_entity))
                    devDao.insert(dev)
                    dev = Dev("Room", "Architecture Component", mContext.getString(R.string.ac_room_dao))
                    devDao.insert(dev)
                    dev = Dev("Room", "Architecture Component", mContext.getString(R.string.ac_room_repository))
                    devDao.insert(dev)

                    // Architecture components, ViewModel
                    dev = Dev("ViewModel", "Architecture Component", mContext.getString(R.string.ac_viewmodel_summary))
                    devDao.insert(dev)
                    dev = Dev("ViewModel", "Architecture Component", mContext.getString(R.string.ac_viewmodel_provider))
                    devDao.insert(dev)
                    dev = Dev("ViewModel", "Architecture Component", mContext.getString(R.string.ac_viewmodel_lifecycle))
                    devDao.insert(dev)
                    dev = Dev("ViewModel", "Architecture Component", mContext.getString(R.string.ac_viewmodel_sharedViewModel))
                    devDao.insert(dev)

                    // Architecture components, WorkManager
                    dev = Dev("WorkManager", "Architecture Component", mContext.getString(R.string.ac_WorkManager_summary))
                    devDao.insert(dev)
                    dev = Dev("WorkManager", "Architecture Component", mContext.getString(R.string.ac_WorkManager_constraints))
                    devDao.insert(dev)
                    dev = Dev("WorkManager", "Architecture Component", mContext.getString(R.string.ac_WorkManager_scheduling))
                    devDao.insert(dev)
                    dev = Dev("WorkManager", "Architecture Component", mContext.getString(R.string.ac_WorkManager_retry))
                    devDao.insert(dev)
                    dev = Dev("WorkManager", "Architecture Component", mContext.getString(R.string.ac_WorkManager_chaining))
                    devDao.insert(dev)
                    dev = Dev("WorkManager", "Architecture Component", mContext.getString(R.string.ac_WorkManager_integrates))
                    devDao.insert(dev)


                    // Navigation
                    dev = Dev("Navigation", "Navigation", mContext.getString(R.string.navigation_summary))
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


                    // Intent & intent Filters
                    dev = Dev("Intent", "Intent", mContext.getString(R.string.intent_summary))
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





                    // User Interface layout
                    dev = Dev("UI", "UserInterface", mContext.getString(R.string.UI_layout_summary))
                    devDao.insert(dev)
                    dev = Dev("UI", "UserInterface", mContext.getString(R.string.UI_layout_linear))
                    devDao.insert(dev)
                    dev = Dev("UI", "UserInterface", mContext.getString(R.string.UI_layout_relative))
                    devDao.insert(dev)
                    dev = Dev("UI", "UserInterface", mContext.getString(R.string.UI_layout_WebView))
                    devDao.insert(dev)
                    dev = Dev("UI", "UserInterface", mContext.getString(R.string.UI_layout_adapters))
                    devDao.insert(dev)
                    dev = Dev("UI", "UserInterface", mContext.getString(R.string.UI_layout_list))
                    devDao.insert(dev)
                    dev = Dev("UI", "UserInterface", mContext.getString(R.string.UI_layout_gridView))
                    devDao.insert(dev)
                    dev = Dev("UI", "UserInterface", mContext.getString(R.string.UI_layout_constraint))
                    devDao.insert(dev)
                    dev = Dev("UI", "UserInterface", mContext.getString(R.string.UI_layout_motionLayout))
                    devDao.insert(dev)

                    // User Interface RecyclerView
                    dev = Dev("RecyclerView", "UserInterface", mContext.getString(R.string.UI_RecyclerView_summary))
                    devDao.insert(dev)
                    dev = Dev("RecyclerView", "UserInterface", mContext.getString(R.string.UI_RecyclerView_adapter))
                    devDao.insert(dev)
                    dev = Dev("RecyclerView", "UserInterface", mContext.getString(R.string.UI_RecyclerView_layoutManager))
                    devDao.insert(dev)
                    dev = Dev("RecyclerView", "UserInterface", mContext.getString(R.string.UI_RecyclerView_ViewHolder))
                    devDao.insert(dev)
                    dev = Dev("RecyclerView", "UserInterface", mContext.getString(R.string.UI_RecyclerView_onCreateViewHolder))
                    devDao.insert(dev)
                    dev = Dev("RecyclerView", "UserInterface", mContext.getString(R.string.UI_RecyclerView_onBindViewHolder))
                    devDao.insert(dev)
                    dev = Dev("RecyclerView", "UserInterface", mContext.getString(R.string.UI_recyclerView_getItemCount))
                    devDao.insert(dev)
                    dev = Dev("RecyclerView", "UserInterface", mContext.getString(R.string.UI_recyclerView_diffUtils))
                    devDao.insert(dev)
                    dev = Dev("RecyclerView", "UserInterface", mContext.getString(R.string.UI_RecyclerView_ItemDecoration))
                    devDao.insert(dev)
                    dev = Dev("RecyclerView", "UserInterface", mContext.getString(R.string.UI_RecyclerView_TouchHelper))
                    devDao.insert(dev)

                    // User Interface CustomView
                    dev = Dev("CustomView", "UserInterface", mContext.getString(R.string.UI_CustomView_summary))
                    devDao.insert(dev)
                    dev = Dev("CustomView", "UserInterface", mContext.getString(R.string.UI_CustomView_basic_approach))
                    devDao.insert(dev)
                    dev = Dev("CustomView", "UserInterface", mContext.getString(R.string.UI_CustomView_onDraw))
                    devDao.insert(dev)
                    dev = Dev("CustomView", "UserInterface", mContext.getString(R.string.UI_CustomView_onMeasure))
                    devDao.insert(dev)
                    dev = Dev("CustomView", "UserInterface", mContext.getString(R.string.UI_CustomView_CompoundControls))
                    devDao.insert(dev)
                    dev = Dev("CustomView", "UserInterface", mContext.getString(R.string.UI_CustomView_Canvas))
                    devDao.insert(dev)
                    dev = Dev("CustomView", "UserInterface", mContext.getString(R.string.UI_CustomView_paint))
                    devDao.insert(dev)

                    // User Interface Look and feel
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_summary))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_MaterialDesign))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_Styles_Themes))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_DarkTheme))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_AdaptiveIcon))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_FAB))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_Shadows))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_clip))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_button))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_CheckButton))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_RadioButtons))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_ToggleButton))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_Spinners))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_Pickers ))
                    devDao.insert(dev)
                    dev = Dev("Look and Feel", "UserInterface", mContext.getString(R.string.UI_Look_ToolTips))
                    devDao.insert(dev)

                    // Notification
                    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_summary))
                    devDao.insert(dev)
                    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_types))
                    devDao.insert(dev)
                    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_action))
                    devDao.insert(dev)
                    devDao.insert(dev)
                    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_expandable))
                    devDao.insert(dev)
                    devDao.insert(dev)
                    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_group))
                    devDao.insert(dev)
                    devDao.insert(dev)
                    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_channel))
                    devDao.insert(dev)
                    devDao.insert(dev)
                    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_importance))
                    devDao.insert(dev)
                    devDao.insert(dev)
                    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_DoNotDisturb))
                    devDao.insert(dev)
                    devDao.insert(dev)
                    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_ForegroundService))
                    devDao.insert(dev)

                    // UI App bar
                    dev = Dev("AppBar", "UserInterface", mContext.getString(R.string.UI_appbar_summary))
                    devDao.insert(dev)













//                    // User Interface

//                    dev = Dev("Up Button", "User Interface", "AppBar")
//                    devDao.insert(dev)
//                    dev = Dev("What is CardView", "User Interface", "Material Design")
//                    devDao.insert(dev)
//                    dev = Dev("Delay Loading of Views", "User Interface", "Layout Performance")
//                    devDao.insert(dev)
//                    dev = Dev("Optimizing Layout Hierarchies", "User Interface", "Layout Performance")
//                    devDao.insert(dev)
//                    dev = Dev("Re-Using", "User Interface", "Layout Performance")
//                    devDao.insert(dev)
//                    dev = Dev("InputEvents", "User Interface", "Layout Performance")
//                    devDao.insert(dev)
//                    dev = Dev("Constraint", "User Interface", "Layouts")
//                    devDao.insert(dev)
//                    dev = Dev("CustomView", "User Interface", "Layouts")
//                    devDao.insert(dev)
//                    dev = Dev("Motion Layout", "User Interface", "Layouts")
//                    devDao.insert(dev)
//                    dev = Dev("Adapter", "User Interface", "Layouts")
//                    devDao.insert(dev)
//                    dev = Dev("LinearLayout", "User Interface", "Layouts")
//                    devDao.insert(dev)
//                    dev = Dev("FAB", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("Theme & Style", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("App Icon", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("Bitmap 9-Patch", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("Check Boxes", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("Localize UI", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("Pickers", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("Radio Buttons", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("Shadow clips", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("Spinners", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("Toggle Buttons", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("Button", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("ToolTip", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("WebP", "User Interface", "Look and Feel")
//                    devDao.insert(dev)
//                    dev = Dev("Menu", "User Interface", "Menu")
//                    devDao.insert(dev)
//                    dev = Dev("Notification", "User Interface", "Notification")
//                    devDao.insert(dev)
//                    dev = Dev("RecyclerView", "User Interface", "RecyclerView")
//                    devDao.insert(dev)
//                    dev = Dev("DiffUtil", "User Interface", "RecyclerView")
//                    devDao.insert(dev)
//                    dev = Dev("Item Decoration", "User Interface", "RecyclerView")
//                    devDao.insert(dev)
//                    dev = Dev("Item Touch Helper", "User Interface", "RecyclerView")
//                    devDao.insert(dev)
//                    dev = Dev("Click Listener", "User Interface", "RecyclerView")
//                    devDao.insert(dev)
//                    dev = Dev("Views", "User Interface", "Views")
//                    devDao.insert(dev)
//                    dev = Dev("Custom Views", "User Interface", "Views")
//                    devDao.insert(dev)
//                    dev = Dev("Effects", "User Interface", "Views")
//                    devDao.insert(dev)
//                    dev = Dev("Clipping", "User Interface", "Views")
//                    devDao.insert(dev)
//                    dev = Dev("Switch", "User Interface", "Widget")
//                    devDao.insert(dev)
//                    dev = Dev("Place Holder", "User Interface", "")
//                    devDao.insert(dev)
//                    dev = Dev("System UI", "UserInterface", "")
//                    devDao.insert(dev)
//                    dev = Dev("Toast", "User Interface", "")
//                    devDao.insert(dev)
//                    dev = Dev("Snackbar", "UserInterface", "")
//                    devDao.insert(dev)
//                    dev = Dev("Dialog", "UserInterface", "")
//                    devDao.insert(dev)
//                    dev = Dev("Preference", "UserInterface", "")
//                    devDao.insert(dev)




















                    // Fragments
//                    dev = Dev("Fragment", "Fragment", "Item 1 \nLine2")
//                    devDao.insert(dev)
//                    dev = Dev("LifeCycle", "Fragment", "")
//                    devDao.insert(dev)
//                    dev = Dev("Load Fragment", "Fragment", "")
//                    devDao.insert(dev)
//                    dev = Dev("Listenable Interface", "Fragment", "")
//                    devDao.insert(dev)
//                    dev = Dev("Flexible UI", "Fragment", "" )
//                    devDao.insert(dev)
//                    dev = Dev("Animation", "Fragment", "Animate & Transition" )
//                    devDao.insert(dev)
//                    dev = Dev("SharedElement", "Fragment", "Animate & Transition" )
//                    devDao.insert(dev)
//                    dev = Dev("Transitions Animation", "Fragment", "Animate & Transition" )
//                    devDao.insert(dev)











//
//
//                    // Broadcast Receiver.
//                    dev = Dev("BroadcastReceiver", "BroadcastReceiver", "")
//                    devDao.insert(dev)
//


//
//                    // Service
//                    dev = Dev("What is a Service", "Service", "")
//                    devDao.insert(dev)
//                    dev = Dev("LifeCycle", "Service", "")
//                    devDao.insert(dev)
//                    dev = Dev("Manifest", "Service", "")
//                    devDao.insert(dev)
//                    dev = Dev("Process Lifecycle", "Service", "")
//                    devDao.insert(dev)
//                    dev = Dev("Bound Service", "Service", "")
//                    devDao.insert(dev)
//                    dev = Dev("Foreground Service", "Service", "")
//                    devDao.insert(dev)
//                    dev = Dev("Started Service", "Service", "")
//                    devDao.insert(dev)
//                    dev = Dev("Start and Stop", "Service", "")
//                    devDao.insert(dev)
//
//

//
//
//
//
//
//
//
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

    companion object {
        //Singleton prevents multiple instance of database from opening.
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