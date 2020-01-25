package com.example.iceandfireapi.Database

import android.util.Log
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.iceandfireapi.data.network.response.IceAndFireResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Dao
interface ICharacter {
    @Insert
    suspend fun ins(c: IceAndFireResponse)
    @Delete
    suspend fun del(c: IceAndFireResponse)
    @Query("Select * from favourite_characters")
    suspend fun getAllCharacters(): List<IceAndFireResponse>
    @Query("Select * from favourite_characters where name==:name")
    suspend fun getCharacterByName(name: String): IceAndFireResponse
    @Query("Select * from favourite_characters where played_by like '%' || :actor || '%'")
    suspend fun getCharacterByActor(actor: String): IceAndFireResponse

}

fun addChar(db: DbCreator.CharactersDB, c: IceAndFireResponse) { // Insert
    CoroutineScope(Dispatchers.IO).launch {
        db.characterDao().ins(c)
    }
}

fun delete(db: DbCreator.CharactersDB, c:IceAndFireResponse) {
    CoroutineScope(Dispatchers.IO).launch {
        db.characterDao().del(c)
        Log.d("all chars", "Usunięto ${c.name}")
    }
}

fun getAll(db: DbCreator.CharactersDB) { // Select All
    CoroutineScope(Dispatchers.IO).launch {
        val lista: List<IceAndFireResponse> = db.characterDao().getAllCharacters()
        lista.forEach {
            with(Dispatchers.Main) {Log.d("all chars", "${it.name}")}
        }
    }
}

fun getByName(db: DbCreator.CharactersDB, n: String) {
    CoroutineScope(Dispatchers.IO).launch {
        val c: IceAndFireResponse = db.characterDao().getCharacterByName(n)
        with(Dispatchers.Main) {Log.d("got by name: ", "$c")}
    }
}

fun getByActor(db:DbCreator.CharactersDB, a:String){
    CoroutineScope(Dispatchers.IO).launch {
        val c = db.characterDao().getCharacterByActor(a)
        with(Dispatchers.Main) {Log.d("got by actor:", "$c")}
    }
}

//TODO:
//  podłączyć funkcje do recycler view