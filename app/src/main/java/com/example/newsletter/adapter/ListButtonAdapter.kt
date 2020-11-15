package com.example.newsletter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.R
import com.example.newsletter.models.Editeur
import com.example.newsletter.models.EditeurResponse

class ListButtonAdapter (items : EditeurResponse, val handler: SourceHandler) :
    RecyclerView.Adapter<ListButtonAdapter.ViewHolder>(){
    private val mEditeurs: EditeurResponse = items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.button_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val editeur: Editeur = mEditeurs.editeur[position]
        holder.mButton.text = editeur.name
        holder.mButton.setOnClickListener {
            handler.showSource(editeur.id)
        }
    }

    override fun getItemCount(): Int {
        return mEditeurs.editeur.size
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
