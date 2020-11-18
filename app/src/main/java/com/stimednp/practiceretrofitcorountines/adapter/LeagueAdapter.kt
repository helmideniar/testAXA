package com.stimednp.practiceretrofitcorountines.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stimednp.practiceretrofitcorountines.R
import com.stimednp.practiceretrofitcorountines.data.User
import com.stimednp.practiceretrofitcorountines.ui.ItemsLeagueUI
import com.stimednp.practiceretrofitcorountines.ui.Listener
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

/**
 * Created by rivaldy on 11/10/2019.
 */

class LeagueAdapter(val items: List<User>) :
    RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>(), Listener {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(
            ItemsLeagueUI().createView(
                AnkoContext.create(
                    parent.context,
                    parent
                )
            )
        )
    }

    var listener: Listener? = null

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val data = items[position]
        holder.listener = this
        holder.bindItem(data, position)
    }

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view), Listener {
        private val ligaName: TextView = view.find(R.id.tv_name)

        var listener: Listener? = null

        fun bindItem(user: User, position: Int) {
            val text = "[$position] (id : ${user.id}) --> ${user.title}"

            ligaName.text = text
            ligaName.setOnClickListener {
                listener?.onClick(user)
            }
        }

        override fun onClick(user: User) {

        }
    }

    override fun onClick(user: User) {
        listener?.onClick(user)
    }

}