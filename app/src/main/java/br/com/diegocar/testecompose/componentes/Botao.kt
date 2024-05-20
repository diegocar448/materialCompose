package br.com.diegocar.testecompose.componentes

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier

@Composable
fun Botao(texto: String, modifier: Modifier, onClick: () -> Unit){
    Button(
        onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF2196F3),
            contentColor = Color.White
        ),
        modifier = modifier
    ) {
        Text(text = "$texto")
    }

}


@Preview
@Composable
private fun BotaoPreview(){
    Botao("Login", modifier = Modifier, onClick = {})
}