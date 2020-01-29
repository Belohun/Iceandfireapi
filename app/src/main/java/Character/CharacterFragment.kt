package Character

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iceandfireapi.Database.DbCreator
import com.example.iceandfireapi.Database.addChar
import com.example.iceandfireapi.Database.delete
import com.example.iceandfireapi.Database.getChars
import com.example.iceandfireapi.data.network.IceAndFireApiService
import com.example.iceandfireapi.data.network.response.IceAndFireResponse
import com.example.iceandfireapi.data.network.response.IceAndFireResponseList
import com.example.iceandfireapi.data.network.response.ResponseAdapter
import com.example.iceandfireapi.ui.home.HomeFragment
import com.example.shopapi.R

import kotlinx.android.synthetic.main.character.*
import kotlinx.android.synthetic.main.character.view.*
import kotlinx.android.synthetic.main.fragment_character.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.text.FieldPosition

class CharacterFragment:Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java) // to będzie singleton tej aktywności
        val root = inflater.inflate(R.layout.fragment_character, container, false)
        GlobalScope.launch(Dispatchers.Main) {

            arguments?.let {
                val args = CharacterFragmentArgs.fromBundle(it)
                val position = args.id
                val positiondb = args.iddb
                if (positiondb == 9999) {
                    val apiServive =
                        IceAndFireApiService()
                    val iceAndFireResponse =
                        apiServive.getCharacter().await()
                    val list = iceAndFireResponse[position]
                    if (list.name == "") {
                        root.TitleFragment_character.text = list.aliases[0]

                    } else {
                        root.TitleFragment_character.text = list.name
                    }
                    root.nameFragment_character.text = list.name
                    root.aliasFragment_character.text = list.aliases[0]
                    root.fatherFragment_character.text = list.father
                    root.btnFragment_character.text = "ADD"
                    root.btnFragment_character.setOnClickListener {
                        val db =
                            DbCreator.CharactersDB.getInstance(this@CharacterFragment.context!!)
                        addChar(db, list)
                        fragmentManager?.popBackStack()
                    }
                    if (list.isFemale) {
                        root.genderFragment_character.text = "female"
                    } else {
                        root.genderFragment_character.text = "male"
                    }
                    root.bornFragment_character.text = list.born
                    root.diedFragment_character.text = list.died
                    root.motherFragment_character.text = list.mother

                }else
                {
                    val db = DbCreator.CharactersDB.getInstance(this@CharacterFragment.context!!)
                   val iceAndFireResponse= getChars(db)
                    val list = iceAndFireResponse[positiondb]
                    if (list.name == "") {
                        root.TitleFragment_character.text = list.aliases[0]

                    } else {
                        root.TitleFragment_character.text = list.name
                    }
                    root.nameFragment_character.text = list.name
                    root.aliasFragment_character.text = list.aliases[0]
                    root.fatherFragment_character.text = list.father
                    root.btnFragment_character.text = "DEL"
                    root.btnFragment_character.setOnClickListener {

                        delete(db = DbCreator.CharactersDB.getInstance(this@CharacterFragment.context!!), c = list)
                        fragmentManager?.popBackStack()
                    }
                    if (list.isFemale) {
                        root.genderFragment_character.text = "female"
                    } else {
                        root.genderFragment_character.text = "male"
                    }
                    root.bornFragment_character.text = list.born
                    root.diedFragment_character.text = list.died
                    root.motherFragment_character.text = list.mother




                }
            }
               /* val apiServive =
                    IceAndFireApiService()
                val iceAndFireResponse =
                    apiServive.getCharacter().await()
            val list = iceAndFireResponse[position]
                if(list.name==""){
                    root.TitleFragment_character.text=list.aliases[0]

                }else{
                    root.TitleFragment_character.text=list.name
                }
                root.nameFragment_character.text=list.name
                root.aliasFragment_character.text=list.aliases[0]
                root.fatherFragment_character.text=list.father
                root.btnFragment_character.text="ADD"
            if(list.isFemale){
                root.genderFragment_character.text="female"}
            else{
                root.genderFragment_character.text="male"
            }
            root.bornFragment_character.text=list.born
            root.diedFragment_character.text=list.died
            root.motherFragment_character.text=list.mother*/

              //  Log.d("CHARACTERFRAGMEN", "coś" + iceAndFireResponse[1].toString())








        }

        return root
    }






    /*override fun onStart() {

        d("OnResume",name)
        view?.nameFragment_character?.text=""
        view?.aliasFragment_character?.text=alias
        view?.genderFragment_character?.text=gender
        view?.bornFragment_character?.text=born
        view?.diedFragment_character?.text=died
        view?.fatherFragment_character?.text=father
        view?.fatherFragment_character?.text=mother
        super.onStart()
    }

     fun FillCharacter(  name:String="",
                         alias: String="",
                         gender: String="",
                         born: String="",
                         died: String="",
                         father: String="",
                        mother: String ="") {
         view?.nameFragment_character?.text=name
         view?.aliasFragment_character?.text=alias
         view?.genderFragment_character?.text=gender
         view?.bornFragment_character?.text=born
         view?.diedFragment_character?.text=died
         view?.fatherFragment_character?.text=father
         view?.fatherFragment_character?.text=mother



    }*/
}