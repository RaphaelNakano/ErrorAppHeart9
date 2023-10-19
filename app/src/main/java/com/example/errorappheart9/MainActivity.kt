package com.example.errorappheart9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.errorappheart9.ui.theme.ErrorAppHeart9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ErrorAppHeart9Theme {
                ErrorAppHeart9()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ErrorAppHeart9() {
    var lord by remember { mutableStateOf(0) }
    val idImagem = when (lord) {
        0 -> R.drawable.thelogo
        1 -> R.drawable.lord1
        2 -> R.drawable.lord2
        3 -> R.drawable.lord3
        4 -> R.drawable.lord4
        5 -> R.drawable.lord5
        6 -> R.drawable.lord6
        7 -> R.drawable.lord7
        8 -> R.drawable.lord8
        else -> R.drawable.lord9
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp, bottom = 30.dp)
    ) {
        Image(
            painter = painterResource(id = idImagem),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
                .height(400.dp)
                .padding(end = 15.dp, start = 15.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 15.dp, start = 15.dp)
        ) {
            Button(
                onClick = {
                    if (lord > 0) {
                        lord--
                    }else{
                        lord=9
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Black),
            ) {
                Text(text = "Anterior")
            }
            Button(
                onClick = {
                    if (lord < 9) {
                        lord++
                    }else{
                        lord=0
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "Próximo")
            }
        }
    }
}
