package br.com.diegocar.testecompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import br.com.diegocar.testecompose.views.AtualizarContato
import br.com.diegocar.testecompose.views.ListaContatos
import br.com.diegocar.testecompose.views.SalvarContato
import calculadoraDeImcTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            calculadoraDeImcTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "listaContatos"
                ){
                    composable("listaContatos"){
                        ListaContatos(navController)
                    }
                    composable("salvarContato"){
                        SalvarContato(navController)
                    }
                    composable("atualizarContato"){
                        AtualizarContato(navController)
                    }
                }
            }
        }
    }

}

