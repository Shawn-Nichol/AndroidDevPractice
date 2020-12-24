package com.example.androiddevpractice.room.dbinfo

import android.content.Context
import com.example.androiddevpractice.R
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.room.DevDao

suspend fun UIInsert(devDao: DevDao, mContext: Context) {

    // UI App bar
    var dev = Dev("AppBar", "UserInterface", mContext.getString(R.string.UI_appbar_summary))
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

    // UI Interface Dialog
    dev = Dev("Dialog", "UserInterface", mContext.getString(R.string.UI_Dialog_Summary))
    devDao.insert(dev)
    dev = Dev("Dialog", "UserInterface", mContext.getString(R.string.UI_Dialog_Alert))
    devDao.insert(dev)
    dev = Dev("Dialog", "UserInterface", mContext.getString(R.string.UI_Dialog_Picker))
    devDao.insert(dev)
    dev = Dev("Dialog", "UserInterface", mContext.getString(R.string.UI_Dialog_Fragment))
    devDao.insert(dev)
    dev = Dev("Dialog", "UserInterface", mContext.getString(R.string.UI_Dialog_Buttons))
    devDao.insert(dev)
    dev = Dev("Dialog", "UserInterface", mContext.getString(R.string.UI_Dialog_List))
    devDao.insert(dev)
    dev = Dev("Dialog", "UserInterface", mContext.getString(R.string.UI_Dialog_CustomDialog))
    devDao.insert(dev)
    dev = Dev("Dialog", "UserInterface", mContext.getString(R.string.UI_Dialog_PassingEvents))
    devDao.insert(dev)
    dev = Dev("Dialog", "UserInterface", mContext.getString(R.string.UI_Dialog_ShowDialog))
    devDao.insert(dev)
    dev = Dev("Dialog", "UserInterface", mContext.getString(R.string.UI_Dialog_FullScreen))
    devDao.insert(dev)
    dev = Dev("Dialog", "UserInterface", mContext.getString(R.string.UI_Dialog_Dismiss))
    devDao.insert(dev)

    // User Interface layout
    dev = Dev("Layout", "UserInterface", mContext.getString(R.string.UI_layout_summary))
    devDao.insert(dev)
    dev = Dev("Layout", "UserInterface", mContext.getString(R.string.UI_layout_linear))
    devDao.insert(dev)
    dev = Dev("Layout", "UserInterface", mContext.getString(R.string.UI_layout_relative))
    devDao.insert(dev)
    dev = Dev("Layout", "UserInterface", mContext.getString(R.string.UI_layout_WebView))
    devDao.insert(dev)
    dev = Dev("Layout", "UserInterface", mContext.getString(R.string.UI_layout_adapters))
    devDao.insert(dev)
    dev = Dev("Layout", "UserInterface", mContext.getString(R.string.UI_layout_list))
    devDao.insert(dev)
    dev = Dev("Layout", "UserInterface", mContext.getString(R.string.UI_layout_gridView))
    devDao.insert(dev)
    dev = Dev("Layout", "UserInterface", mContext.getString(R.string.UI_layout_constraint))
    devDao.insert(dev)
    dev = Dev("Layout", "UserInterface", mContext.getString(R.string.UI_layout_MotionLayout))
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

    // UI Menu
    dev = Dev("Menu", "UserInterface", mContext.getString(R.string.UI_Menu_Summary))
    devDao.insert(dev)
    dev = Dev("Menu", "UserInterface", mContext.getString(R.string.UI_Menu_Options))
    devDao.insert(dev)
    dev = Dev("Menu", "UserInterface", mContext.getString(R.string.UI_Menu_Context))
    devDao.insert(dev)
    dev = Dev("Menu", "UserInterface", mContext.getString(R.string.UI_Menu_PopUp))
    devDao.insert(dev)
    dev = Dev("Menu", "UserInterface", mContext.getString(R.string.UI_Menu_Define))
    devDao.insert(dev)
    dev = Dev("Menu", "UserInterface", mContext.getString(R.string.UI_Menu_onCreateOptionsMenu))
    devDao.insert(dev)
    dev = Dev("Menu", "UserInterface", mContext.getString(R.string.UI_Menu_onOptionsItemSelected))
    devDao.insert(dev)
    dev = Dev("Menu", "UserInterface", mContext.getString(R.string.UI_Menu_Group))
    devDao.insert(dev)

    // Notification
    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_summary))
    devDao.insert(dev)
    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_types))
    devDao.insert(dev)
    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_action))
    devDao.insert(dev)
    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_expandable))
    devDao.insert(dev)
    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_group))
    devDao.insert(dev)
    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_channel))
    devDao.insert(dev)
    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_importance))
    devDao.insert(dev)
    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_DoNotDisturb))
    devDao.insert(dev)
    dev = Dev("Notification", "UserInterface", mContext.getString(R.string.notification_ForegroundService))
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

    // UI Visibility
    dev = Dev("System Visibility", "UserInterface", mContext.getString(R.string.UI_SystemUIVisibility_summary))
    devDao.insert(dev)
    dev = Dev("System Visibility", "UserInterface", mContext.getString(R.string.UI_SystemUIVisibility_Dim))
    devDao.insert(dev)
    dev = Dev("System Visibility", "UserInterface", mContext.getString(R.string.UI_SystemUIVisibility_StatusBar))
    devDao.insert(dev)
    dev = Dev("System Visibility", "UserInterface", mContext.getString(R.string.UI_SystemUIVisibility_Navigation))
    devDao.insert(dev)

    // UI Toast
    dev = Dev("Toast", "UserInterface", mContext.getString(R.string.UI_Toast_Summary))
    devDao.insert(dev)
    dev = Dev("Toast", "UserInterface", mContext.getString(R.string.UI_Toast_Basics))
    devDao.insert(dev)
    dev = Dev("Toast", "UserInterface", mContext.getString(R.string.UI_Toast_Position))
    devDao.insert(dev)
    dev = Dev("Toast", "UserInterface", mContext.getString(R.string.UI_Toast_CustomToast))
    devDao.insert(dev)



}