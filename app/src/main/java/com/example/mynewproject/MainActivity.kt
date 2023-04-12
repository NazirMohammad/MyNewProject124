package com.example.mynewproject

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mynewproject.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navView: BottomNavigationView = binding.navView

     //  findNavController(R.id.nav_host_fragment_activity_main)


        //fragment Container

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController =  navHost.navController



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_alcoholic, R.id.navigation_category, R.id.navigation_ingridient,
                R.id.loginFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)








        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment -> {
                    navView.visibility = View.GONE
                    supportActionBar?.hide()
                }


//                R.id.fragmentalcohol -> {
//                    navView.visibility = View.VISIBLE
//                    supportActionBar?.show()
//
//                }


                R.id.fragmentgin -> {
                    navView.visibility = View.VISIBLE
                    supportActionBar?.show()
                }
                R.id.navigation_category -> {
                    navView.visibility = View.VISIBLE
                    supportActionBar?.show()
                }

                else -> {
                    navView.visibility = View.VISIBLE
                }


            }
        }
    }


    override fun onSupportNavigateUp(): kotlin.Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.btnSignOut -> {
                Firebase.auth.signOut()
                Toast.makeText(baseContext,
                    "You have been signed out!",
                    Toast.LENGTH_LONG)
                    .show()
                findNavController(R.id.nav_host_fragment_activity_main).navigate(R.id.loginFragment)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_action_bar, menu)
        return true
    }
}








