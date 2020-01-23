package com.example.iceandfireapi

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log.d
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.iceandfireapi.Database.*
import com.example.shopapi.R
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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


        val db = DbCreator.CharactersDB.getInstance(this)
        val c2 = DataModel("kappa", "góra, dół"," pierwsza i ostatnia", "nigdy", "nie posiada", "nie", "ojciec", "apache", "jedna", "Przykładowe Imię Trzy", "kiepski aktor", "df", "nie", "imperium kontratakuje", "pierwsza i środkowa","www.google.com")
        //runBlocking{db.characterDao().ins(c2)}
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //addChar(db, c2)
        getAll(db)
        getByName(db, "Przykładowe Imię Dwa")
        getByActor(db, "kiepski")
        runBlocking { delay(1000)}
        //delete(db, c2)
        runBlocking { delay(1000)}
        //getAll(db)

    }


}
