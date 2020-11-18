package com.stimednp.practiceretrofitcorountines.data

import com.google.gson.annotations.SerializedName

/**
 * Created by rivaldy on 11/10/2019.
 */

class User {
    @SerializedName("userId")
    lateinit var userId: String
    @SerializedName("id")
    lateinit var id: String
    @SerializedName("title")
    lateinit var title: String
    @SerializedName("body")
    lateinit var body: String
}