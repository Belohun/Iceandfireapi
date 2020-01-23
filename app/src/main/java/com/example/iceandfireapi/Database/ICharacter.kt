package com.example.iceandfireapi.Database

import android.util.Log
import androidx.annotation.UiThread
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.CharacterData

@Dao
interface ICharacter {
    @Insert
    suspend fun ins(c: DataModel)
    @Delete
    suspend fun del(c: DataModel)
    @Query("Select * from favourite_characters")
    suspend fun getAllCharacters(): List<DataModel>
    @Query("Select * from favourite_characters where name==:name")
    suspend fun getCharacterByName(name: String): DataModel
    @Query("Select * from favourite_characters where played_by like '%' || :actor || '%'")
    suspend fun getCharacterByActor(actor: String): DataModel

}

fun addChar(db: DbCreator.CharactersDB, c: DataModel) {
    CoroutineScope(Dispatchers.IO).launch {
        db.characterDao().ins(c)
    }
}

fun getAll(db: DbCreator.CharactersDB){
    CoroutineScope(Dispatchers.IO).launch {
        val lista = db.characterDao().getAllCharacters()
        lista.forEach { with(Dispatchers.Main){Log.d("all chars", "${it.name}")} }

    }
}