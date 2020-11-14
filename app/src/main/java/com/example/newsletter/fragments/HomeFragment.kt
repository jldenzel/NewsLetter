package com.example.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.newsletter.R


class HomeFragment : Fragment(){

    lateinit var aboutUs : Button
    lateinit var allArticles : TextView

    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.homepage, container, false)
        allArticles = view.findViewById(R.id.text_last_categories)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }



}