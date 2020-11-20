package com.example.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsletter.R

class AboutUsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(R.layout.aboutus, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.btn_favorite_toolbar).isVisible = false
        menu.findItem(R.id.btn_a_propos).isVisible = false
        menu.findItem(R.id.btn_home_toolbar).isVisible = true
        menu.findItem(R.id.action_search).isVisible = false
        super.onPrepareOptionsMenu(menu)
    }
}