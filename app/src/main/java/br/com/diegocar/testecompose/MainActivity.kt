package br.com.diegocar.testecompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import calculadoraDeImcTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            calculadoraDeImcTheme {
                PrimeiraTela()
            }
        }
    }


    @Composable
    fun PrimeiraTela(){
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Blue
                ){
                    Text(
                        text = "Primeiro Aplicativo",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                }
            }
        ) {
            Column(
                modifier = Modifier.background(Color.White)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Texto 1")
                Text(text = "Texto 2")
                Text(text = "Texto 3")
            }

        }
    }

    @Preview
    @Composable
    fun PrimeiraTelaPreview(){
        PrimeiraTela()
    }

}

