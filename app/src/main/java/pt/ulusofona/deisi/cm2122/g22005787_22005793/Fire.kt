package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.util.*


@Parcelize
data class Fire(
    var pessoa: @RawValue Pessoa,
    var distrito: String,
    var data: String,
    var fotos: ArrayList<String>
) : Parcelable {

    var concelho: String = ""
    var freguesia: String = ""
    var meiosOperacionais: Int = 0
    var meiosVeiculos: Int = 0
    var meiosAereos: Int = 0
    var estado = ""
    var obs: String = ""
    var porConfirmar: Boolean = false

    constructor(
        distrito: String, concelho: String, freguesia: String,
        meiosOperacionais: Int, meiosVeiculos: Int, meiosAereos: Int,
        estado: String, data: String, fotos: ArrayList<String>,
        obs: String, pessoa: @RawValue Pessoa, porConfirmar: Boolean
    ) :
            this(pessoa, distrito, data, fotos) {
        this.concelho = concelho
        this.freguesia = freguesia
        this.meiosOperacionais = meiosOperacionais
        this.meiosVeiculos = meiosVeiculos
        this.meiosAereos = meiosAereos
        this.estado = estado
        this.obs = obs
        this.porConfirmar = porConfirmar
    }

    private fun infNotAvailable(view: String): String {
        if (view == "" || view == "0") {
            return "Informação não disponivel"
        }
        return view
    }


    fun showInf(): String {
        return "Concelho -> ${infNotAvailable(concelho)} \nFreguesia -> ${infNotAvailable(freguesia)} \n" +
                "Estado -> ${infNotAvailable(estado)} \nData -> ${infNotAvailable(data)}"
    }


}