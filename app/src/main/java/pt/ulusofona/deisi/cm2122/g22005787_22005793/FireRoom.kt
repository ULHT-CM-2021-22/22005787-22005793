package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.RawValue
import java.util.*

@Entity(tableName = "fires")
data class FireRoom(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val distrito: String?, val concelho: String?, val freguesia: String?,
    val meiosOperacionais: String?, val meiosVeiculos: String?, val meiosAereos: String?,
    val estado: String?, val data: String?, val fotos: String?,
    val obs: String?, val nomePessoa: String?, val ccPessoa: String?, val porConfirmar: Boolean?
) {
}