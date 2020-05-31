package com.example.travelguide.ui

//import com.example.travelguide.profile.ProfileFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.travelguide.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)


//        navigateToFragment(ListFragment.newInstance())

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.listFragment, R.id.favouriteFragment, R.id.myPlaceFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottom_navigation.setupWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean  = findNavController(R.id.nav_host_fragment).navigateUp()

//        bottom_navigation.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.nav_list -> {
//                    navigateToFragment(ListFragment.newInstance())
////                    startActivity(Intent(this, ListActivity::class.java))
//                }
//                R.id.nav_map -> {
//                    navigateToFragment(MapFragment.newInstance())
//                }
//                R.id.nav_profile -> {
//                    navigateToFragment(ProfileFragment.newInstance())
//                }
//            }
//            false
//        }
//    }

//    private fun navigateToFragment(fragment: Fragment): Boolean {
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment_container, fragment)
//            addToBackStack(null)
//            commit()
//        }
//        return true
//    }
}
