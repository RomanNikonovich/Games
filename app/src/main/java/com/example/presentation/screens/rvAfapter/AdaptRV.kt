package com.example.presentation.screens.rvAfapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.model.entity.Game
import com.example.presentation.R
import kotlinx.android.synthetic.main.item_games.view.*


class AdaptRV : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val list: MutableList<Game> = arrayListOf()

    fun setJokes(list: MutableList<Game>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            LayoutInflater.from(parent?.context).inflate(R.layout.item_games, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.game_name.text = list[position].gameName.gameName
        holder.itemView.chanel_quantity.text = list[position].channels.toString()
        holder.itemView.viewers.text = list[position].viewers.toString()

        Glide
            .with(holder.itemView.context)
            .load(list[position].gameName.logoUrl.logo_url)
            .centerCrop()
            .placeholder(R.drawable.web)
            .into(holder.itemView.logo)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var gameName: TextView
        var chanelQuantity: TextView
        var viewers: TextView
        var logo: ImageView

        init {
            gameName = view.findViewById(R.id.game_name)
            chanelQuantity = view.findViewById(R.id.chanel_quantity)
            viewers = view.findViewById(R.id.viewers)
            logo = view.findViewById(R.id.logo)
        }
    }
}