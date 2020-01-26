package com.example.iceandfireapi

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.RoomDatabase
import com.example.iceandfireapi.Database.DbCreator

import com.example.shopapi.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val db: RoomDatabase = DbCreator.CharactersDB.getInstance(applicationContext)

      /*  refreashdata(this)*/
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_fav
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
/*    fun refreashdata(context: Context){
        val IceAndFireList = IceAndFireData().List

            recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            val adapter = ResponseAdapter(context, IceAndFireList)
            recyclerView.adapter = adapter
    }*/
}

