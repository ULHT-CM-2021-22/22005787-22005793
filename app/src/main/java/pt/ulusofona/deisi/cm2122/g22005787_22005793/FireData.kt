package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class FireData(
    var pessoa: @RawValue Pessoa?,
    var distrito: String?,
    var data: String?,
    var fotos: Uri?
) : Parcelable {

    @IgnoredOnParcel
    var concelho: String? = null
    @IgnoredOnParcel
    var freguesia: String? = null
    @IgnoredOnParcel
    var meiosOperacionais: String? = null
    @IgnoredOnParcel
    var meiosVeiculos: String? = null
    @IgnoredOnParcel
    var meiosAereos: String? = null
    @IgnoredOnParcel
    var estado: String? = null
    @IgnoredOnParcel
    var obs: String? = null
    @IgnoredOnParcel
    var porConfirmar: Boolean? = false

    constructor(
        distrito: String?, concelho: String?, freguesia: String?,
        meiosOperacionais: String?, meiosVeiculos: String?, meiosAereos: String?,
        estado: String?, data: String?, fotos: Uri?,
        obs: String?, pessoa: @RawValue Pessoa?, porConfirmar: Boolean?
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