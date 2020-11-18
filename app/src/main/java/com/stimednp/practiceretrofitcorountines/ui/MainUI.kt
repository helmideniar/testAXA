package com.stimednp.practiceretrofitcorountines.ui

import androidx.recyclerview.widget.LinearLayoutManager
import com.stimednp.practiceretrofitcorountines.R
import com.stimednp.practiceretrofitcorountines.adapter.LeagueAdapter
import com.stimednp.practiceretrofitcorountines.data.User
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by rivaldy on 11/10/2019.
 */


class MainUI(val items: ArrayList<User>) : AnkoComponent<MainActivity>, Listener {

    val listener:Listener? = null

    companion object{
        val rvMain = R.id.rv_mainui
        var progressBar = R.id.progress_main
    }
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        relativeLayout {
            recyclerView {
                lparams(matchParent, matchParent)
                id = rvMain
                layoutManager = LinearLayoutManager(context)
                val leagueAdapter = LeagueAdapter(items)
                leagueAdapter.listener = this@MainUI
                adapter = leagueAdapter
            }
            progressBar {
                id = progressBar
            }.lparams(matchParent, wrapContent){centerInParent()}
        }
    }

    override fun onClick(user: User) {

    }
}
