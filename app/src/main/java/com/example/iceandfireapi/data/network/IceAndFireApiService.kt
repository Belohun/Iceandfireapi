package com.example.iceandfireapi.data.network

import com.example.iceandfireapi.data.network.response.IceAndFireResponse
import com.example.iceandfireapi.data.network.response.IceAndFireResponseList
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.http.GET
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers
import retrofit2.http.Query

/*https://www.anapioficeandfire.com/api/characters?page=2&pageSize=10*/
interface IceAndFireApiService {
    @Headers("Accept: application/vnd.anapioficeandfire+json; version=1")
    @GET("characters/55")
    fun getCharacter(/*@Query("page")page:String="1", @Query("pageSize")pageSize: String="10"*/):Deferred<IceAndFireResponse>
companion object{
     operator fun invoke(/*connectivityInterceptor: ConnectivityInterceptor*/): IceAndFireApiService {

   /* if key needed*/
         /*
val requestInterceptor = Interceptor{chain ->

             val url = chain.request()
                 .url()
                 .newBuilder()
                *//* .addQueryParameter(name"key",API_KEY)*//*
                 .build()
             val request = chain.request()
                 .newBuilder()
                 .url(url)
                 .build()
             return@Interceptor chain.proceed(request)
         }*/
         val okHttpClient= OkHttpClient.Builder()
          /*   .addInterceptor(requestInterceptor)*/
            /* .addInterceptor(connectivityInterceptor)*/
             .build()
         return Retrofit.Builder()
             .client(okHttpClient)
             .baseUrl("https://www.anapioficeandfire.com/api/")
             .addCallAdapterFactory(CoroutineCallAdapterFactory())
             .addConverterFactory(GsonConverterFactory.create())
             .build()
             .create(IceAndFireApiService::class.java)
     }
}
}