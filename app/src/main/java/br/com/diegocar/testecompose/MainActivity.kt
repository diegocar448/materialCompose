package br.com.diegocar.testecompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.diegocar.testecompose.componentes.Botao
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
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Botao(
                "Cadastrar",
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    println("Usuario Cadastrado")
                }
            )
            Botao(
                "Login",
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                onClick = {
                    println("Login feito com sucesso!")
                }
            )
        }

    }

    @Preview
    @Composable
    fun PrimeiraTelaPreview(){
        PrimeiraTela()
    }

}

