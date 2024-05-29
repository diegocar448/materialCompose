package br.com.diegocar.testecompose.componentes

import Purple500
import WHITE
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Botao(
    onClick: () -> Unit,
    texto: String
){
    Button(
        onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Purple500
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)


    ) {
        Text(text=texto, fontSize = 18.sp, color = WHITE)
    }
}