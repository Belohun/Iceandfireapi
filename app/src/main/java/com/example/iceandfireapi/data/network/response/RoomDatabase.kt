package com.example.iceandfireapi.data.network.response

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATABASE = "characters"

@Database(
    entities = [IceAndFireResponse::class],
    version = 1,
    exportSchema = false
)
abstract class IAFDatabase: RoomDatabase() {
    abstract fun characterDao(): IDAOs

    companion object { // spełnia rolę singletonu - w pamięci tylko jedna baza

        @Volatile
        private var instance: IAFDatabase? = null

        fun getInstance(context: Context): IAFDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): IAFDatabase {
            return Room.databaseBuilder(context, IAFDatabase::class.java, DATABASE)
                .fallbackToDestructiveMigration().build()
        }

    }
}