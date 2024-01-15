package com.wlnxing.sms_forward.Repository

import android.content.Context

class DashboardRepository(private val context: Context) {

    companion object {
        private const val SHARED_PREFS_NAME = "ServerSettings"
    }

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    fun saveServerAddress(address: String) {
        sharedPreferences.edit().putString("serverAddress", address).apply()
    }

    fun saveToken(token: String) {
        sharedPreferences.edit().putString("token", token).apply()
    }

    fun getServerAddress(): String? {
        return sharedPreferences.getString("serverAddress", null)
    }

    fun getToken(): String? {
        return sharedPreferences.getString("token", null)
    }
}
