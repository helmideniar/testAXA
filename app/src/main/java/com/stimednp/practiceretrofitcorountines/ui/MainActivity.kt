package com.stimednp.practiceretrofitcorountines.ui

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.stimednp.practiceretrofitcorountines.R
import com.stimednp.practiceretrofitcorountines.api.*
import com.stimednp.practiceretrofitcorountines.data.User
import com.stimednp.practiceretrofitcorountines.invisible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), Listener {
    var dataList = ArrayList<User>()
    lateinit var rv_main: RecyclerView
    lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainUI(dataList).setContentView(this)

        rv_main = find(R.id.rv_mainui)
        progress = find(R.id.progress_main)
        getAllDataId()
    }
    private fun getAllDataId() {
        val tsdbService = ApiFactory.tsdbApi
        GlobalScope.launch(Dispatchers.Main) {
            val allIdRequests = tsdbService.getAllId()
            try {
                val response = allIdRequests.await()
                response.body()?.let {
                    getHasil(it)
                }
            } catch (e: Exception) {
                toast("ERRORR --> $e")
                progress.invisible()
            }
        }
    }

    fun getHasil(response: ArrayList<User>) {
        dataList.addAll(response)
        rv_main.adapter?.notifyDataSetChanged()
        progress.invisible()
    }

    override fun onClick(user: User) {
        Toast.makeText(this, "${user.title} ${user.body}", Toast.LENGTH_LONG).show()
    }
}
