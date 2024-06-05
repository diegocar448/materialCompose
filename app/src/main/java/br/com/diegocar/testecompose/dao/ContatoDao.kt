package br.com.diegocar.testecompose.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.diegocar.testecompose.model.Contato

@Dao
interface ContatoDao {

    @Insert
    fun gravar(listaContatos: List<Contato>)

    @Query("SELECT * FROM tabela_contatos ORDER BY nome ASC")
    fun getContatos(): MutableList<Contato>

    @Query("UPDATE tabela_contatos SET nome = :novoNome, sobrenome = :novoSobrenome, idade = :novaIdade, celular = :novoCelular WHERE uid = :id")
    fun atualizar(id: Int, novoNome: String, novoSobrenome: String, novaIdade: String, novoCelular: String)

    @Query("DELETE FROM tabela_contatos WHERE uid = :id")
    fun deletar(id: Int)
}