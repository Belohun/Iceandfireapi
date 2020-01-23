package com.example.iceandfireapi.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_characters")
data class DataModel (
    val aliases: String?,
    val allegiances: String?,
    val books: String?,
    val born: String?,
    val culture: String?,
    val died: String?,
    val father: String?,
    val gender: String?,
    val mother: String?,
    @PrimaryKey(autoGenerate = false)
    val name: String,

    @ColumnInfo(name = "played_by")
    val playedBy: String?,
    @ColumnInfo(name = "pov_books")
    val povBooks: String?,
    val spouse: String?,
    val titles: String?,
    @ColumnInfo(name = "tv_series")
    val tvSeries: String?,
    val url: String
)