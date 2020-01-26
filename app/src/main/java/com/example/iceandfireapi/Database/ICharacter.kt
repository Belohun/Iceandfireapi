package com.example.iceandfireapi.Database

import android.util.Log
import android.util.Log.d
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.iceandfireapi.data.network.response.IceAndFireResponse
import com.example.iceandfireapi.data.network.response.ResponseAdapter
import kotlinx.coroutines.*

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

    @Query("Select * from favourite_characters where id==:id")
    suspend fun getCharacterById(id: Int): IceAndFireResponse

    @Query("Select * from favourite_characters where played_by like '%' || :actor || '%'")
    suspend fun getCharacterByActor(actor: String): IceAndFireResponse

}

fun addChar(db: DbCreator.CharactersDB, c: IceAndFireResponse) { // Insert
    CoroutineScope(Dispatchers.IO).launch {
        if("${getById(db, c.id)}"=="null") db.characterDao().ins(c)
    }
}

fun delete(db: DbCreator.CharactersDB, c:IceAndFireResponse) {
    CoroutineScope(Dispatchers.IO).launch {
        db.characterDao().del(c)
        Log.d("all chars", "Usunięto ${c.name}")
    }
}

fun getById(db: DbCreator.CharactersDB, id: Int):IceAndFireResponse = runBlocking(Dispatchers.IO) {
    val result = async {db.characterDao().getCharacterById(id)}.await()
    return@runBlocking result
}

fun getChars(db: DbCreator.CharactersDB): ArrayList<IceAndFireResponse> = runBlocking(Dispatchers.Default) {
    val result = async {db.characterDao().getAllCharacters()}.await()
    return@runBlocking result as ArrayList<IceAndFireResponse>
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