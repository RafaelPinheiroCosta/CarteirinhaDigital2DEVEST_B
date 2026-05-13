package com.rafaelcosta.carteirinhadigital2devest_b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafaelcosta.carteirinhadigital2devest_b.ui.theme.CarteirinhaDigital2DEVEST_BTheme
import com.rafaelcosta.myapplication.QrCode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarteirinhaDigital2DEVEST_BTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   CarteirinhaDigitalApp(
                       modifier = Modifier.padding(innerPadding)
                   )
                }
            }
        }
    }
}
@Composable
fun CarteirinhaDigitalApp(modifier: Modifier = Modifier) {
    Box{
        Image(
            painter = painterResource(id = R.drawable.fundo),
            contentDescription = "Fundo",
            modifier=Modifier
                .fillMaxSize()
                .alpha(0.8f)
            ,
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Senai",
                modifier = Modifier
                    .width(300.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = "Foto Perfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            Color.White,
                            CircleShape
                        )
                )
                Row() {
                    Text(
                        text = "Nome:",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Rafael Costa",
                        fontSize = 35.sp,
                        color = Color.White
                    )
                }
                Row() {
                    Text(
                        text = "Curso:",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Desenvolvimento de Sistemas",
                        fontSize = 25.sp,
                        color = Color.White
                    )
                }
            }
            QrCode(
                conteudo = "jkhgkgfhgf"
            )
        }

    }

}