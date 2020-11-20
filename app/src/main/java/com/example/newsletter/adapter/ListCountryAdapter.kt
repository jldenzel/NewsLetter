package com.example.newsletter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.R
import com.example.newsletter.models.Pays

class ListCountryAdapter (val handler: SourceHandler) : RecyclerView.Adapter<ListCountryAdapter.ViewHolder>(){

    val listCountry: MutableList<Pays> = mutableListOf(
            Pays("France","fr"),
            Pays("Belgium","be"),
            Pays("Germany","de"),
            Pays("United States","us"),
            Pays("Switzerland","ch"),
            Pays("Russia","ru"),
            Pays("China","cn"),
            Pays("Japan","jp"),
            Pays("Nigeria","ng"),
            Pays("United Kingdom","gb"),
            Pays("Italy","it"),
            Pays("Portugal","pt")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.button_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = listCountry[position]
        holder.mButton.text = country.name
        holder.mButton.setOnClickListener {
            handler.showSource(country.search)
        }
    }

    override fun getItemCount(): Int {
        return listCountry.size
    }

    class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {
        val mButton: Button

        init {
            // Enable click on item
            mButton = view.findViewById(R.id.btn_item)

        }
    }

}
