package br.com.diegocar.testecompose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.diegocar.testecompose.const.Constantes

@Entity(tableName = Constantes.TABLE_CONTATOS)
data class Contato(
    //@PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "nome") val nome: String,
    @ColumnInfo(name = "sobreNome") val sobreNome: String,
    @ColumnInfo(name = "idade") val idade: String,
    @ColumnInfo(name = "celular") val celular: String
){
    @PrimaryKey(autoGenerate = true) var uid: Int = 0
    //@PrimaryKey(autoGenerate = true) val uid: Int = 0
}