package me.tatarka.android.lazycolumnsizingbug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = list()
        setContent {
            LazyColumn {
                items(list) { text ->
                    ListItem(text)
                }
            }
        }
    }
}

@Composable
fun ListItem(text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = 2.dp)
            .background(color = Color.LightGray)
    ) {
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            Text(text = AnnotatedString(text), fontSize = 20.sp)
        }
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            Text(text = AnnotatedString(text), fontSize = 20.sp)
        }
    }
}

fun list(): List<String> {
    return List(500) { line() }
}

fun line(): String {
    val len = Random.nextInt(10, 100)
    return String((0..len).map {
        Char(Random.nextInt(33, 127))
    }.toCharArray())
}