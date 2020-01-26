package com.example.iceandfireapi.data.network.response

import android.content.Context
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.iceandfireapi.Database.DbCreator
import com.example.iceandfireapi.Database.addChar
import com.example.shopapi.R
import kotlinx.android.synthetic.main.character.view.*
import java.io.IOException

class ResponseAdapter(context: Context, var IceAndFireList: ArrayList<IceAndFireResponse>, var page:Int,var pageSize: Int): RecyclerView.Adapter<ResponseAdapter.ViewHolder>(){
 val context = context
    var navController: NavController?=null
  class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var name = itemView.name
    val button = itemView.btn_char

  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.character,parent,false)
        navController= Navigation.findNavController(parent)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return pageSize
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            var charactes: IceAndFireResponse = IceAndFireList[position+((pageSize)*(page-1))]

            if (charactes.name == "") {
                holder.name.text = charactes.aliases[0]
            } else {
                holder.name.text = charactes.name
            }
            holder.button.text = "Add"
            holder.button.setOnClickListener {
                d("TODO","Tutaj wstaw funkcję odpowiadającą za dodawanie do bazy")
                val db = DbCreator.CharactersDB.getInstance(context)
                addChar(db, charactes)
            }
            holder.itemView.setOnClickListener {
                CharacterViewModel()._character.value=IceAndFireList[position]

                navController!!.navigate(R.id.action_navigation_home_to_nav_fragment_character)

            }

    }

}