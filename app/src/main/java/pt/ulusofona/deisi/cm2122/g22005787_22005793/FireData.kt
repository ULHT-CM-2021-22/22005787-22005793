package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.util.*


@Parcelize
data class FireData(
    var pessoa: @RawValue Pessoa,
    var distrito: String,
    var data: String,
    var fotos: ArrayList<String>
) : Parcelable {

    @IgnoredOnParcel
    var concelho: String = ""
    @IgnoredOnParcel
    var freguesia: String = ""
    @IgnoredOnParcel
    var meiosOperacionais: Int = 0
    @IgnoredOnParcel
    var meiosVeiculos: Int = 0
    @IgnoredOnParcel
    var meiosAereos: Int = 0
    @IgnoredOnParcel
    var estado = ""
    @IgnoredOnParcel
    var obs: String = ""
    @IgnoredOnParcel
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

}