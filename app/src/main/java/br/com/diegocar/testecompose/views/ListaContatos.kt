package br.com.diegocar.testecompose.views

import Purple500
import Purple700
import WHITE
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.diegocar.testecompose.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListaContatos(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Purple500,
                contentColor = Color.White, // Definindo a cor do conteúdo como branco
                title = {
                    Text(
                        text = "Agenda de Contatos",
                        fontSize = 18.sp
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("salvarContato")
                },
                backgroundColor = Purple500,
                contentColor = WHITE,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Icone de adicionar novo contato"
                )
            }
        }
    ) {
        Column() {

        }
    }
}
@Preview
@Composable
private fun ListaContatoPreview(){
    ListaContatos(navController = rememberNavController())
}
