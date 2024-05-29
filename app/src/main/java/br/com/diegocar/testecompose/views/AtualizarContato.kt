package br.com.diegocar.testecompose.views

import Purple500
import WHITE
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.diegocar.testecompose.componentes.Botao
import br.com.diegocar.testecompose.componentes.OutlinedTextFieldCustom

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AtualizarContato(navController: NavController){
    var nome by remember{ mutableStateOf("") }
    var sobreNome by remember{ mutableStateOf("") }
    var idade by remember{ mutableStateOf("") }
    var celular by remember{ mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Purple500,
                contentColor = WHITE, // Definindo a cor do conteúdo como branco
                title = {
                    Text(
                        text = "Atualizar Contato",
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
            OutlinedTextFieldCustom(
                value = nome,
                onValueChange = {
                    nome = it
                },
                label = {
                    Text(text = "Nome")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 80.dp, 20.dp, 10.dp),
            )

            OutlinedTextFieldCustom(
                value = sobreNome,
                onValueChange = {
                    sobreNome = it
                },
                label = {
                    Text(text = "Sobrenome")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp),
            )
            OutlinedTextFieldCustom(
                value = idade,
                onValueChange = {
                    idade = it
                },
                label = {
                    Text(text = "Idade")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp),
            )
            OutlinedTextFieldCustom(
                value = celular,
                onValueChange = {
                    celular = it
                },
                label = {
                    Text(text = "Celular")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp),
            )


            Botao(
                onClick = {
                    if (
                        nome.isEmpty() ||
                        sobreNome.isEmpty() ||
                        idade.isEmpty() ||
                        celular.isEmpty()
                    ){
                        println("Preencha todos os campo! $nome \n $sobreNome \n $idade \n $celular")
                    }else{
                        println("Usuario atualizado no banco de dados! $nome \n" +
                                " $sobreNome \n" +
                                " $idade \n" +
                                " $celular")
                    }
                },
                texto = "Atualizar"
            )
        }
    }

}


@Preview
@Composable
private fun atualizarContatoPreview(){
    AtualizarContato(navController = rememberNavController())
}