package com.example.travelguide.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.travelguide.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.listFragment, R.id.favouriteFragment, R.id.myPlaceFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottom_navigation.setupWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean  = findNavController(R.id.nav_host_fragment).navigateUp()


}
