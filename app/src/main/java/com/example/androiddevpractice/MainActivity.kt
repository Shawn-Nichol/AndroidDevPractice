package com.example.androiddevpractice

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.androiddevpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var TAG = "PracticeMainActivity"

    private lateinit var binding: ActivityMainBinding
    lateinit var myAppBar: AppBarConfiguration


    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var sharedPref: SharedPreferences


    // KEYS
    private val KEY_THEME: String = "User selected theme"
    private val KEY_DARK_MODE: String = "DarkMode"

    // Theme variables
    private var darkMode = 0
    private var userTheme = 0



    override fun onCreate(savedInstanceState: Bundle?) {
       Log.i(TAG, "onCreate")
        // Needs to load before super, this allows for the correct theme to be loaded.

        super.onCreate(savedInstanceState)
        initSharedPreference()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        initNavDrawer()
        initNavDrawerClickListener()
    }

    /**
     * This method is called when ever the user choose to navigate up within the applications hierarchy.
     *
     * return: true if Up navigation completed successfully and this Activity was finished, false otherwise.
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(myAppBar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
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
        with(sharedPref.edit()) {
            putInt(KEY_THEME, userTheme)
            putInt(KEY_DARK_MODE, darkMode)
            commit()
        }
    }

    private fun initSharedPreference() {
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

        drawerLayout = binding.myDrawerLayout
        navController = navHostFragment.navController
        val toolbar = binding.myToolbar

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
        binding.navView.setNavigationItemSelectedListener { menuItem ->
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