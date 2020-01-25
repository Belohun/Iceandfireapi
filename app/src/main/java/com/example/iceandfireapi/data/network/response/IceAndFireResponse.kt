package com.example.iceandfireapi.data.network.response


import com.google.gson.annotations.SerializedName

/*data class IceAndFireResponse(
    @SerializedName("aliases")
    val aliases: List<String>,
    @SerializedName("allegiances")
    val allegiances: List<String>,
    @SerializedName("books")
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
    val playedBy: List<String>,
    @SerializedName("povBooks")
    val povBooks: List<String>,
    @SerializedName("spouse")
    val spouse: String,
    @SerializedName("titles")
    val titles: List<String>,
    @SerializedName("tvSeries")
    val tvSeries: List<String>,
    @SerializedName("url")
    val url: String
)*/
/*

data class IceAndFireResponse(
    @SerializedName("aliases")
    val aliases: List<String>,
    @SerializedName("allegiances")
    val allegiances: List<String>,
    @SerializedName("books")
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
    val playedBy: List<String>,
    @SerializedName("povBooks")
    val povBooks: List<String>,
    @SerializedName("spouse")
    val spouse: String,
    @SerializedName("titles")
    val titles: List<String>,
    @SerializedName("tvSeries")
    val tvSeries: List<String>,
    @SerializedName("url")
    val url: String

)*/
data class IceAndFireResponse(
    @SerializedName("Aliases")
    val aliases: List<String>,
    @SerializedName("Allegiances")
    val allegiances: List<Int>,
    @SerializedName("Books")
    val books: List<Int>,
    @SerializedName("Born")
    val born: String,
    @SerializedName("Children")
    val children: List<String>,
    @SerializedName("Culture")
    val culture: String,
    @SerializedName("Died")
    val died: String,
    @SerializedName("Father")
    val father: String,
    @SerializedName("Id")
    val id: Int,
    @SerializedName("IsFemale")
    val isFemale: Boolean,
    @SerializedName("Mother")
    val mother: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("PlayedBy")
    val playedBy: List<String>,
    @SerializedName("PovBooks")
    val povBooks: List<String>,
    @SerializedName("Spouse")
    val spouse: String,
    @SerializedName("Titles")
    val titles: List<String>,
    @SerializedName("TvSeries")
    val tvSeries: List<String>
)
