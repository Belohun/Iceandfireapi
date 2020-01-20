package com.example.iceandfireapi.ui.fav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.shopapi.R

class FavFragment : Fragment() {

    private lateinit var favViewModel: FavViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favViewModel =
            ViewModelProviders.of(this).get(FavViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_fav, container, false)
        val textView: TextView = root.findViewById(R.id.name)
        val button:TextView = root.findViewById(R.id.btn_char)
        favViewModel.text.observe(this, Observer {
            textView.text = it
        })
        favViewModel.button.observe(this, Observer {
            button.setText(it)
        })
        return root
    }
}