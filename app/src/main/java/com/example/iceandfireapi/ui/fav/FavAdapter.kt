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
import com.example.iceandfireapi.Database.delete
import com.example.iceandfireapi.ui.fav.FavFragmentDirections
import com.example.iceandfireapi.ui.home.HomeFragmentDirections
import com.example.shopapi.R
import kotlinx.android.synthetic.main.character.view.*
import java.io.IOException

class FavAdapter(context: Context, var IceAndFireList: ArrayList<IceAndFireResponse>): RecyclerView.Adapter<FavAdapter.ViewHolder>(){
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
        return IceAndFireList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {


            var charactes = IceAndFireList[position]
            if (charactes.name == "") {
                holder.name.text = charactes.aliases[0]
                /*          holder.name.text=charactes.aliases[0]*/
            } else {
                holder.name.text = charactes.name
            }
            /*holder.button.setBackgroundResource(R.drawable.ic_add_circle_white_24dp)*/
            holder.button.text = "Del"
            holder.button.setOnClickListener {
                delete(db = DbCreator.CharactersDB.getInstance(context), c = charactes)
                //notifyDataSetChanged()
                IceAndFireList.removeAt(position)
                notifyItemRemoved(position)


            }
            holder.itemView.setOnClickListener {

                val action = FavFragmentDirections.actionNavigationFavToNavFragmentCharacter(0,position)
                navController!!.navigate(action)



            }
        }catch (e: IOException){
            holder.name.text="Error"
            d("Adapter","onBindViewHolder")
        }
    }

}