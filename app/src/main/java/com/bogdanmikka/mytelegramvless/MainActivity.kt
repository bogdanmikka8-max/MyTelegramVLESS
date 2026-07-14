package com.bogdanmikka.mytelegramvless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bogdanmikka.mytelegramvless.ui.theme.MyTelegramVLESSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTelegramVLESSTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var isConnected by remember { mutableStateOf(false) }
    var statusText by remember { mutableStateOf("Готов к подключению") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("MyVLESS — Для Telegram") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = statusText,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Button(
                onClick = {
                    isConnected = !isConnected
                    statusText = if (isConnected) {
                        "Подключено ✓ (Telegram)"
                    } else {
                        "Отключено"
                    }
                    // TODO: Здесь будет запуск/остановка сервиса
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(
                    text = if (isConnected) "Отключить" else "Подключить для Telegram",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Просто вставь VLESS-ссылку и подключи.\nTelegram будет работать через защищённый прокси.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
