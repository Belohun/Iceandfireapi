package com.example.iceandfireapi.Database

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromListOfStrings(value: List<String>): String? {
        return value.joinToString(
            separator = ", "
        )
    }

    @TypeConverter
    fun stringToListOfStrings(value: String): List<String>? {
        return value.split(",").map { it.trim() }
    }

    @TypeConverter
    fun fromListOfInts(value: List<Int>): String? {
        return value.joinToString(
            separator = ", "
        )
    }

    @TypeConverter
    fun stringToListOfInts(value: String): List<Int>? {
        if (value != "") return value.removeSurrounding("{", "}").split(", ").map { it.toInt() }
        else return listOf(0)
    }

}