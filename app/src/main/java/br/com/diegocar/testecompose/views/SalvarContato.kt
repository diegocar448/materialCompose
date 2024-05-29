package br.com.diegocar.testecompose.views

import Purple500
import WHITE
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.diegocar.testecompose.R
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SalvarContato(navController: NavController){

    var nome by remember{ mutableStateOf("")}
    var sobreNome by remember{ mutableStateOf("")}
    var idade by remember{ mutableStateOf("")}
    var celular by remember{ mutableStateOf("")}


    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Purple500,
                contentColor = WHITE, // Definindo a cor do conteúdo como branco
                title = {
                    Text(
                        text = "Salvar novo Contato",
                        fontSize = 18.sp
                    )
                }
            )
        },

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nome,
                onValueChange =  {
                    nome = it
                },
                label = {
                    Text(text = "Nome")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Purple500,
                    focusedBorderColor = Purple500
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 80.dp, 20.dp, 10.dp),
                maxLines = 1
            )
            OutlinedTextField(
                value = sobreNome,
                onValueChange =  {
                    sobreNome = it
                },
                label = {
                    Text(text = "Sobrenome")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Purple500,
                    focusedBorderColor = Purple500
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp),
                maxLines = 1
            )
            OutlinedTextField(
                value = idade,
                onValueChange =  {
                    idade = it
                },
                label = {
                    Text(text = "Idade")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Purple500,
                    focusedBorderColor = Purple500
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp),
                maxLines = 1
            )

            OutlinedTextField(
                value = celular,
                onValueChange =  {
                    celular = it
                },
                label = {
                    Text(text = "Celular")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Purple500,
                    focusedBorderColor = Purple500
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp),
                maxLines = 1
            )
            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Purple500
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)


                ) {
                Text(text="Salvar", fontSize = 18.sp, color = WHITE)
            }



        }
    }
}

@Preview
@Composable
private fun SalvarContatoPreview(){
    ListaContatos(navController = rememberNavController())
}