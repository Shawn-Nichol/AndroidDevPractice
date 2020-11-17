package com.example.androiddevpractice

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private var TAG = "PracticeMainActivity"

    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var sharedPref: SharedPreferences
    private lateinit var myAppBar: AppBarConfiguration

    // KEYS
    private val KEY_THEME: String = "User selected theme"
    private val KEY_DARK_MODE: String = "DarkMode"

    // Theme variables
    private var darkMode = 0
    private var userTheme = 0


    override fun onCreate(savedInstanceState: Bundle?) {
       Log.i(TAG, "onCreate")

        initSharedPreference()
        // Needs to load before super, this allows for the correct theme to be loaded.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         initNavDrawer()
         initNavDrawerClickListener()
    }

    /**
     * This method is called when ever the user chooses to navigate up within the applications hierarchy.
     *
     * return: true if Up navigation completed successfully and this Activity was finished, false otherwise.
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
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
                return NavigationUI.onNavDestinationSelected(item, navController)
            }

            R.id.dest_menu2Fragment -> {
                return NavigationUI.onNavDestinationSelected(item, navController)
            }

            R.id.dest_menu3Fragment -> {
                return NavigationUI.onNavDestinationSelected(item, navController)
            }

            R.id.force_dark -> {
                darkMode = if(darkMode == 0 ) 1 else 0
                setDarkMode()
                return true
            }

            R.id.theme_change -> {
                userTheme = if(userTheme == 0) 1 else 0
                // Reloads the app so theme changes can be applied.
                recreate()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
        with(sharedPref.edit()) {
            putInt(KEY_THEME, userTheme)
            putInt(KEY_DARK_MODE, darkMode)
            commit()
        }
    }

    private fun initSharedPreference() {
        Log.i(TAG, "initSharedPreference")
        sharedPref = this.getSharedPreferences("AndroidDevPractice", Context.MODE_PRIVATE)
        userTheme = sharedPref.getInt(KEY_THEME, 0)
        darkMode = sharedPref.getInt(KEY_DARK_MODE, 0)
        loadTheme()
        setDarkMode()
    }

    private fun initNavDrawer() {
        // Retrieve the navController from the NavHostFragment.
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        drawerLayout = findViewById(R.id.my_drawer_layout)
        navController = navHostFragment.navController
        val toolbar = findViewById<Toolbar>(R.id.myToolbar)


        // Post the call to the findNavController
        toolbar.setupWithNavController(navController, drawerLayout)

        // Set toolbar as the action bar
        setSupportActionBar(toolbar)

        // Pass top level destination, shows Nav drawer on the following fragments
        myAppBar = AppBarConfiguration(
            setOf(
                R.id.dest_loginFragment,
                R.id.dest_contextual1Fragment,
                R.id.dest_contextual2Fragment,
                R.id.dest_contextual3Fragment,
                R.id.dest_menu1Fragment,
                R.id.dest_menu2Fragment,
                R.id.dest_menu3Fragment
            ),
            drawerLayout
        )

        // Setup Action bar
        setupActionBarWithNavController(navController, myAppBar)
    }

    private fun initNavDrawerClickListener() {
        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.nav_first_fragment -> {
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

                else -> false
            }
        }
    }

    /**
     * Changes the current theme to dark mode.
     */
    private fun setDarkMode() {
        Log.i(TAG, "darkMode(): $darkMode")
        if(darkMode == 0) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    /**
     * Loads differentAPP themes.
     */
    private fun loadTheme() {
        Log.i(TAG, "loadTheme")
        when(userTheme) {
            0 -> {
                setTheme(R.style.AppTheme)
            }
            1 -> {
                 setTheme(R.style.AppTheme2)
            }
        }
    }
}

