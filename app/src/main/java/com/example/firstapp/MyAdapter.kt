package com.example.firstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import  android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R

class MyAdapter(private var data: List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView = view.findViewById(R.id.item_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        val holder = MyViewHolder(layout)
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size

    }
}



