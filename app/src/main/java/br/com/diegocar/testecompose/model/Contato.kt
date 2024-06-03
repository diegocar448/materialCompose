package br.com.diegocar.testecompose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.diegocar.testecompose.const.Constantes

@Entity(tableName = Constantes.TABLE_CONTATOS)
data class Contato(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "nome") val nome: String,
    @ColumnInfo(name = "sobrenome") val sobrenome: String,
    @ColumnInfo(name = "idade") val idade: String,
    @ColumnInfo(name = "telefone") val telefone: String
)