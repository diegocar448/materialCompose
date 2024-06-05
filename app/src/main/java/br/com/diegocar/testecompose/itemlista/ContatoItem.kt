package br.com.diegocar.testecompose.itemlista

import ShapeCardView
import Shapes
import WHITE
import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import br.com.diegocar.testecompose.AppDatabase
import br.com.diegocar.testecompose.R
import br.com.diegocar.testecompose.dao.ContatoDao
import br.com.diegocar.testecompose.model.Contato
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var contatoDao: ContatoDao

@Composable
fun ContatoItem(
    navController: NavController,
    position:Int,
    listaContatos: MutableList<Contato>,
    context: Context
){

    val scope = rememberCoroutineScope()

    val nome = listaContatos[position].nome
    val sobrenome = listaContatos[position].sobreNome
    val idade = listaContatos[position].idade
    val celular = listaContatos[position].celular
    val uid = listaContatos[position].uid

    val contato =  listaContatos[position]


    //fun do nosso modal
    fun alertDialogDeletarContato(){
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Deseja Excluir?")
        alertDialog.setMessage("Tem certeza?")
        alertDialog.setPositiveButton("OK"){_,_ ->
            scope.launch(Dispatchers.IO){
                contatoDao = AppDatabase.getInstance(context).contatoDao()
                contatoDao.deletar(uid)
                listaContatos.remove(contato)
            }

            scope.launch(Dispatchers.Main){
                navController.navigate("listaContatos")
                Toast.makeText(context, "Contato $nome removido com sucesso!", Toast.LENGTH_SHORT).show()
            }

        }
        alertDialog.setNegativeButton("Cancelar"){_,_ ->

        }
        alertDialog.show()
    }



    Card(
        backgroundColor = WHITE,
        contentColor = WHITE,
        elevation = 8.dp,
        shape = ShapeCardView.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 20.dp, 10.dp, 10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (txtNome, txtSobreNome, txtIdade, txtCelular, btAtualizar, btDeletar) = createRefs()

            Text(
                text = "Contato: $nome $sobrenome",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtNome){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                text = "Idade: $idade",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtIdade){
                    top.linkTo(txtNome.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                text = "Numero: $celular",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtCelular){
                    top.linkTo(txtIdade.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Button(
                onClick = {
                    navController.navigate("atualizarContato/${uid}")
                },
                modifier = Modifier.constrainAs(btAtualizar){
                    start.linkTo(txtCelular.end, margin = 30.dp)
                    top.linkTo(parent.top, margin = 50.dp)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = WHITE
                ),
                elevation = ButtonDefaults.elevation(
                    disabledElevation = 0.dp,
                    defaultElevation = 0.dp
                )
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_edit),
                    contentDescription = "Icone de editar contato"
                )
            }

            Button(
                onClick = {
                    alertDialogDeletarContato()
                },
                modifier = Modifier.constrainAs(btDeletar){
                    start.linkTo(btAtualizar.end, margin = 10.dp)
                    top.linkTo(parent.top, margin = 50.dp)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = WHITE
                ),
                elevation = ButtonDefaults.elevation(
                    disabledElevation = 0.dp,
                    defaultElevation = 0.dp
                )
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
                    contentDescription = "Icone de remover contato"
                )
            }
        }
    }

}

