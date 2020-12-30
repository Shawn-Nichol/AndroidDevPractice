package com.example.androiddevpractice.room.dbInsert

import android.content.Context
import com.example.androiddevpractice.R
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.room.DevDao

suspend fun architectureComponentInserts(devDao: DevDao, mContext: Context) {

    // Architecture components, Coroutines
    var dev = Dev("Coroutines", "Architecture Component", mContext.getString(R.string.ac_coroutines_summary))
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
}