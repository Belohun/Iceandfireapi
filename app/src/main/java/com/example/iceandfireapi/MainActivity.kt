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
import com.example.iceandfireapi.Database.DataModel
import com.example.iceandfireapi.Database.DbCreator
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
        val c1 = DataModel("lewo, prawo", "góra, dół"," pierwsza i ostatnia", "nigdy", "nie posiada", "nie", "ojciec", "apache", "jedna", "Przykładowe Imię Dwa", "kiepski aktor", "df", "nie", "imperium kontratakuje", "pierwsza i środkowa","www.google.com")
       // db.characterDao().ins(c1)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        addChar(db, c1)

    }

    fun addChar(db: DbCreator.CharactersDB, c: DataModel) {
        CoroutineScope(Dispatchers.IO).launch {
            db.characterDao().ins(c)
            d("all chars", "${db.characterDao().getAllCharacters()}")
        }
    }
}
