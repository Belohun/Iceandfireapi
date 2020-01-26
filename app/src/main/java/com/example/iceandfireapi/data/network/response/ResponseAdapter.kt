package com.example.iceandfireapi.data.network.response

import android.content.Context
import android.content.Intent
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
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
        /*d("Ilość postaci",IceAndFireList.size.toString())*/
        return pageSize
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {


            var charactes: IceAndFireResponse = IceAndFireList[position+((pageSize)*(page-1))]
            if (charactes.name == "") {
                holder.name.text = charactes.aliases[0]
                /*          holder.name.text=charactes.aliases[0]*/
            } else {
                holder.name.text = charactes.name
            }
            /*holder.button.setBackgroundResource(R.drawable.ic_add_circle_white_24dp)*/
            holder.button.text = "Add"
            holder.button.setOnClickListener {
                d("TODO","Tutaj wstaw funkcję odpowiadającą za dodawanie do bazy")
            }
            holder.itemView.setOnClickListener {


                navController!!.navigate(R.id.action_navigation_home_to_nav_fragment_character)


            }
        }catch (e: IOException){
            holder.name.text="Error"
            d("Adapter","onBindViewHolder")
        }
    }

}