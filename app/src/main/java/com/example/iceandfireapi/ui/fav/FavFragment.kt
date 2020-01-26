package com.example.iceandfireapi.ui.fav

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iceandfireapi.Database.DbCreator
import com.example.iceandfireapi.Database.getChars
import com.example.iceandfireapi.data.network.IceAndFireApiService
import com.example.iceandfireapi.data.network.response.FavAdapter
import com.example.iceandfireapi.data.network.response.IceAndFireResponse
import com.example.iceandfireapi.data.network.response.ResponseAdapter
import com.example.iceandfireapi.ui.home.HomeViewModel
import com.example.shopapi.R
import kotlinx.android.synthetic.main.fragment_fav.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class FavFragment : Fragment() {

    private lateinit var favViewModel: FavViewModel
    private var navController: NavController?=null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val context: Context?

        navController= Navigation.findNavController(container!!)

        context = getContext()


        favViewModel =
            ViewModelProviders.of(this).get(FavViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_fav, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recyclerView)


               recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val db = DbCreator.CharactersDB.getInstance(context!!)
                val adapter = FavAdapter(context, getChars(db))

                d("chars: ", "${getChars(db)}")
        recyclerView.adapter = adapter
        return root



    }

}

