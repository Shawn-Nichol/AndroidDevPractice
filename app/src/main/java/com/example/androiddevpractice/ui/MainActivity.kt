package com.example.androiddevpractice.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.androiddevpractice.MainActivityViewModel
import com.example.androiddevpractice.R
import com.google.android.material.navigation.NavigationView


// KEYS
const val KEY_THEME: String = "User selected theme"
const val KEY_DARK_MODE: String = "DarkMode"

class MainActivity : AppCompatActivity(), PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {

    private var TAG = "PracticeMainActivity"

    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var sharedPref: SharedPreferences
    private lateinit var myAppBar: AppBarConfiguration

    // Theme variables
    private var darkModeState = 0
    private var userThemeState = 0

    val load = LoadTheme()




    override fun onCreate(savedInstanceState: Bundle?) {
       Log.i(TAG, "onCreate")

        initSharedPreference()
        // Needs to load before super, this allows for the correct theme to be loaded.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         ViewModelProvider(this).get(MainActivityViewModel::class.java)
         initNavDrawer()
         initNavDrawerClickListener()
    }

    /**
     * This method is called when ever the user chooses to navigate up within the applications hierarchy.
     *
     * return: true if Up navigation completed successfully and this Activity was finished, false otherwise.
     */
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(myAppBar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.i(TAG, "onCreateOptionsMenu")
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i(TAG, "onOptionsItemSelected")
        return when(item.itemId) {
            R.id.dest_loginFragment -> {
                return NavigationUI.onNavDestinationSelected(item, navController)
            }

            R.id.dest_menu1Fragment -> {
                Log.i(TAG, "onOptionItemSelected nav First Fragment")
                return NavigationUI.onNavDestinationSelected(item, navController)
            }

            R.id.dest_menu2Fragment -> {
                return NavigationUI.onNavDestinationSelected(item, navController)
            }

            R.id.dest_menu3Fragment -> {
                return NavigationUI.onNavDestinationSelected(item, navController)
            }

            R.id.force_dark -> {
                darkModeState = if(darkModeState == 0 ) 1 else 0
                load.setDarkMode(darkModeState)
                return true
            }

            R.id.theme_change -> {
                userThemeState = if(userThemeState == 0) 1 else 0
                // Reloads the app so theme changes can be applied.
                recreate()
                return true
            }

            R.id.preferences -> {
                navController.navigate(R.id.dest_myPreferencesFragment)
                return true
            }

            else -> {
                Log.i(TAG, "onOptionItemSelected(): no Item seleted")
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")

    }

    /**
     * Loads the users saved Theme settings.
     */
    private fun initSharedPreference() {
        Log.i(TAG, "initSharedPreference")
        sharedPref = this.getSharedPreferences("AndroidDevPractice", Context.MODE_PRIVATE)

        userThemeState = sharedPref.getInt(KEY_THEME, 0)
        darkModeState = sharedPref.getInt(KEY_DARK_MODE, 0)
        setTheme(load.setAppTheme(userThemeState))
        load.setDarkMode(darkModeState)
    }

    /**
     * initialize the NavDrawer
     */
    private fun initNavDrawer() {
        // NavHostFragment, swaps different fragment destinations in and out as you navigate through the navigation graph
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // NavController, triggers the fragment swap in the NavHostFragment.
        navController = navHostFragment.navController

        drawerLayout = findViewById(R.id.my_drawer_layout)

        // Set toolbar as the action bar
        val toolbar = findViewById<Toolbar>(R.id.myToolbar)
        setSupportActionBar(toolbar)

        // Pass top level destination, shows Nav drawer on the following fragments
        // Tells the action bar what fragments are top level, and whether the bar must handle a drawer layout.
        myAppBar = AppBarConfiguration(
            setOf(
                R.id.dest_loginFragment,
                R.id.dest_menu1Fragment,
                R.id.dest_menu2Fragment,
                R.id.dest_menu3Fragment,
                R.id.dest_contextual1Fragment,
                R.id.dest_contextual2Fragment,
                R.id.dest_contextual3Fragment
            ),
            drawerLayout
        )


        // Shows a title based off of the destinations label
        // Display the UP button whenever you'r not on a top-level destination.
        // Displays the DrawerIcon when you're on a top-level destination
        setupActionBarWithNavController(navController, myAppBar)
    }

    /**
     * Handles clicks inside the Navigation Drawer
     */
    private fun initNavDrawerClickListener() {
        val navView = findViewById<NavigationView>(R.id.nav_drawer_view)
        navView.setNavigationItemSelectedListener { menuItem ->

            when(menuItem.itemId) {
                R.id.nav_first_fragment -> {
                    Log.i(TAG, "drawerClickListener nav First Fragment")
                    navController.navigate(R.id.dest_menu1Fragment)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_second_fragment -> {
                    navController.navigate(R.id.dest_menu2Fragment)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_third_fragment -> {
                    navController.navigate(R.id.dest_menu3Fragment)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                else -> {
                    Log.i(TAG, "drawerClickListener else")
                    false
                }
            }
        }
    }





    /**
     * Called when the user clicked on a preference that has a fragment class associated with it. The
     * implementation should instantiate and switch to an instance of the given fragment.
     * @caller: PreferenceFragmentCompat, The fragment requesting navigation
     * @pref: Preference, The preference request the fragment.
     * return: True, if the fragment creation has been handled.
     *
     */
    override fun onPreferenceStartFragment(
        caller: PreferenceFragmentCompat?,
        pref: Preference?
    ): Boolean {
        Log.i(TAG, "onPreferenceStartFragment, pref: $pref, Caller: $caller")

        when(pref?.key) {
            "CheckBox" -> navController.navigate(R.id.dest_checkBoxPreferences)
            "EditText" -> navController.navigate(R.id.dest_edit_text_preference)
            "List" -> navController.navigate(R.id.dest_listPreferences)
            "MultiList" -> navController.navigate(R.id.dest_multiSelectListPreferences)
            "SeekBars" -> navController.navigate(R.id.dest_seekBarPreferences)
            "UI" ->  navController.navigate(R.id.dest_UIPreferences)
        }


        return true
    }



}

