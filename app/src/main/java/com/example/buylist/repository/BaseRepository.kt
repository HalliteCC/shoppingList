package com.example.buylist.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.buylist.constants.BuyConstants
import com.example.buylist.listener.Listener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseRepository(val context: Context) {

    fun isConectionAvaliable(): Boolean {
        var result = false

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNet = cm.activeNetwork ?: return false
        val netWorkCapabilities = cm.getNetworkCapabilities(activeNet) ?: return false

        result = when {
            netWorkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            netWorkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
        return result
    }


}