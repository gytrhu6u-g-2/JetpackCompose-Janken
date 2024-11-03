package com.example.janken

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ContentView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.janken.ui.theme.JankenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JankenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content()
                }
            }
        }
    }
}

// UI
@Composable
fun Content() {
    var myHand by remember { mutableStateOf(-1) }
    var comHand by remember { mutableStateOf(-1) }
    var result by remember { mutableStateOf(-1) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("じゃんけんアプリ")
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = {
                myHand = 0
                comHand = (0..2).random()
                result = (comHand - myHand + 3) % 3
            }) {
                Text("グー")
            }
            Button(onClick = {
                myHand = 1
                comHand = (0..2).random()
                result = (comHand - myHand + 3) % 3
            }) {
                Text("チョキ")
            }
            Button(onClick = {
                myHand = 2
                comHand = (0..2).random()
                result = (comHand - myHand + 3) % 3
            }) {
                Text("パー")
            }
        }
        PlayerView(hand = myHand)
        ResultView(result = result)
        ComputerView(comHand = comHand)
    }
}

// プレイヤー
@Composable
fun PlayerView(hand: Int) {
    if (hand == 0) {
        Image(
            painter = painterResource(id = R.drawable.gu),
            contentDescription = null
        )
    } else if (hand == 1) {
        Image(
            painter = painterResource(id = R.drawable.choki),
            contentDescription = null
        )
    } else if (hand == 2) {
        Image(
            painter = painterResource(id = R.drawable.pa),
            contentDescription = null
        )
    }
}

// コンピュータ
@Composable
fun ComputerView(comHand: Int) {
    when (comHand) {
        0 -> Image(
            painter = painterResource(R.drawable.com_gu),
            contentDescription = null
        )

        1 -> Image(
            painter = painterResource(R.drawable.com_choki),
            contentDescription = null
        )

        2 -> Image(
            painter = painterResource(R.drawable.com_pa),
            contentDescription = null
        )
    }
}

// 結果
@Composable
fun ResultView(result: Int) {
    when (result) {
        0 -> Text(text = "あいこです", fontSize = 32.sp)
        1 -> Text(text = "あなたの勝ちです", fontSize = 32.sp, color = Color(0xFFD81B60))
        2 -> Text(text = "あなたの負けです", fontSize = 32.sp, color = Color.Blue)
    }
}

// プレビュー画面
@Preview
@Composable
private fun ContentViewPreview() {
    Content()
}










