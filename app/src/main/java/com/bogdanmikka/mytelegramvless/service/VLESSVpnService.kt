package com.bogdanmikka.mytelegramvless.service

import android.net.VpnService
import android.util.Log

class VLESSVpnService : VpnService() {

    override fun onStartCommand(intent: android.content.Intent?, flags: Int, startId: Int): Int {
        Log.d("VLESSService", "Сервис запущен")
        // TODO: Здесь будет запуск Xray / VLESS подключения
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("VLESSService", "Сервис остановлен")
    }
}
