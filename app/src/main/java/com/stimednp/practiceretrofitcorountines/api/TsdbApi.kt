package com.stimednp.practiceretrofitcorountines.api

import com.stimednp.practiceretrofitcorountines.data.User
import kotlinx.coroutines.Deferred
//import org.jetbrains.kotlin.kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by rivaldy on 11/10/2019.
 */

interface TsdbApi {
    @GET("posts")
    fun getAllId(): Deferred<Response<ArrayList<User>>>
}