package com.example.iceandfireapi.data.network.response


import androidx.room.Entity
import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters")
data class IceAndFireResponse(
    @SerializedName("aliases")
    @Ignore
    val aliases: List<String>,
    @SerializedName("allegiances")
    @Ignore
    val allegiances: List<String>,
    @SerializedName("books")
    @Ignore
    val books: List<String>,
    @SerializedName("born")
    val born: String,
    @SerializedName("culture")
    val culture: String,
    @SerializedName("died")
    val died: String,
    @SerializedName("father")
    val father: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("mother")
    val mother: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("playedBy")
    @Ignore
    val playedBy: List<String>,
    @SerializedName("povBooks")
    @Ignore
    val povBooks: List<String>,
    @SerializedName("spouse")
    val spouse: String,
    @SerializedName("titles")
    @Ignore
    val titles: List<String>,
    @SerializedName("tvSeries")
    @Ignore
    val tvSeries: List<String>,
    @SerializedName("url")
    val url: String
)