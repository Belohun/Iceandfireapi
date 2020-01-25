package com.example.iceandfireapi.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.iceandfireapi.data.network.response.IceAndFireResponse


private const val DATABASE = "favourite_characters"
class DbCreator {
    @Database(
        entities = [IceAndFireResponse::class],
        version = 1,
        exportSchema = false
    )
    @TypeConverters(Converters::class)
    abstract class CharactersDB: RoomDatabase(){
        abstract fun characterDao(): ICharacter



        companion object { // spełnia rolę singletonu - zawsze tylko jedna baza w pamięci


            @Volatile
            private var instance: CharactersDB? = null

            fun getInstance(context: Context): CharactersDB {
                return instance ?: synchronized(this) {
                    instance
                        ?: buildDatabase(context).also { instance = it }
                }
            }

            private fun buildDatabase(context: Context): CharactersDB {
                return Room.databaseBuilder(context, CharactersDB::class.java, DATABASE)
                    .fallbackToDestructiveMigration().build()
            }
        }
    }
}