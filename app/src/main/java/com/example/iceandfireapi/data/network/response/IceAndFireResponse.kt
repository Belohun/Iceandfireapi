package com.example.iceandfireapi.data.network.response


import androidx.room.*
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken


@Entity(tableName = "favourite_characters")
data class IceAndFireResponse(
    @SerializedName("Aliases")

    val aliases: List<String>,
    @SerializedName("Allegiances")
    val allegiances: List<Int>,
    @SerializedName("Books")
    val books: List<Int>,
    @SerializedName("Born")
    val born: String?="",
    @SerializedName("Children")
    val children: List<String>,
    @SerializedName("Culture")
    val culture: String?="",
    @SerializedName("Died")
    val died: String?="",
    @SerializedName("Father")
    val father: String?="",
    @SerializedName("Id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("IsFemale")
    val isFemale: Boolean,
    @SerializedName("Mother")
    val mother: String?="",
    @SerializedName("Name")
    val name: String?="",
    @SerializedName("PlayedBy")
    @ColumnInfo(name = "played_by")
    val playedBy: List<String>,
    @SerializedName("PovBooks")
    @ColumnInfo(name = "pov_books")
    val povBooks: List<String>,
    @SerializedName("Spouse")
    val spouse: String?="",
    @SerializedName("Titles")
    val titles: List<String>,
    @SerializedName("TvSeries")
    @ColumnInfo(name = "tv_series")
    val tvSeries: List<String>
)


