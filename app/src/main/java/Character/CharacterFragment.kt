package Character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.shopapi.R
import com.example.shopapi.databinding.FragmentCharacterBinding

class CharacterFragment:Fragment() {
   // private lateinit var characterViewModel:CharacterViewModel
/*    var name=""
    var alias=""
    var gender=""
    var born=""
    var died=""
    var father=""
    var mother=""*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java) // to będzie singleton tej aktywności
        val binding: FragmentCharacterBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_character, container, false)
        val root = binding.root

/*        val name:TextView=root.findViewById(R.id.nameFragment_character)
        val alias: TextView = root.findViewById(R.id.aliasFragment_character)

    characterViewModel.character.observe(this, Observer {
        name.text=it.name
        alias.text=it.aliases[0]

    })*/



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