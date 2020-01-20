package com.example.iceandfireapi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.shopapi.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.character, container, false)
        val textView: TextView = root.findViewById(R.id.name)
        val button:TextView = root.findViewById(R.id.btn_char)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        homeViewModel.button.observe(this, Observer {
           button.setText(it)
        })

        return root

    }
}