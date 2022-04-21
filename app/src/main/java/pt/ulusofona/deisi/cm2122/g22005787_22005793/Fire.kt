package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Fire (val distrito: String,val conselho: String,val freguesia: String,
                 val meiosOperacionais: Int,val meiosVeiculos: Int,val meiosAereos: Int,
                 val estado: String,val data: String,val fotos: ArrayList<String>,
                 val obs: String,  val pessoa : @RawValue Pessoa, val porConfirmar: Boolean ): Parcelable {

                     constructor(pessoa : @RawValue Pessoa,distrito: String,data: String,fotos: ArrayList<String>) :
                             this(distrito,"","",0,0,
                                 0,"",data,fotos,"",pessoa,true)

    fun showInf(): String{
        return "Conselho -> $conselho  Freguesia -> $freguesia  Estado -> $estado  Data -> $data "
    }


}