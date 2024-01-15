package com.wlnxing.sms_forward.ui.dashboard

import androidx.lifecycle.ViewModel
import com.wlnxing.sms_forward.Repository.DashboardRepository

class DashboardViewModel(private val repository: DashboardRepository) : ViewModel() {

    // 保存设置的方法
    fun saveSettings(serverAddress: String, token: String) {
        // 保存服务器地址
        repository.saveServerAddress(serverAddress)
        // 保存 Token
        repository.saveToken(token)
    }

    // 可能还需要其他方法来从 Repository 获取数据
    fun getServerAddress(): String? {
        return repository.getServerAddress()
    }

    fun getToken(): String? {
        return repository.getToken()
    }

    // ViewModel 中其他的逻辑...
}
