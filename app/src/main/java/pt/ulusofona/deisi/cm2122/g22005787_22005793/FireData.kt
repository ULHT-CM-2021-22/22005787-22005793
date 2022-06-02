package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.util.*


@Parcelize
data class FireData(
    var nomePessoa: String?,
    var ccPessoa: String?,
    var distrito: String?,
    var data: String?,
    var fotos: String?
) : Parcelable {

    @IgnoredOnParcel
    var id: String = UUID.randomUUID().toString()

    @IgnoredOnParcel
    var concelho: String? = null

    @IgnoredOnParcel
    var latitude: Double = 0.0

    @IgnoredOnParcel
    var longitude: Double = 0.0

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
    var porConfirmar: Boolean? = true

    constructor(
        distrito: String?, concelho: String?, freguesia: String?,
        meiosOperacionais: String?, meiosVeiculos: String?, meiosAereos: String?,
        estado: String?, data: String?, fotos: String?,
        obs: String?, nomePessoa: String?, ccPessoa: String?, porConfirmar: Boolean?,
        latitude: Double, longitude: Double
    ) :
            this(nomePessoa, ccPessoa, distrito, data, fotos) {
        this.concelho = concelho
        this.freguesia = freguesia
        this.meiosOperacionais = meiosOperacionais
        this.meiosVeiculos = meiosVeiculos
        this.meiosAereos = meiosAereos
        this.estado = estado
        this.obs = obs
        this.porConfirmar = porConfirmar
        this.latitude = latitude
        this.longitude = longitude
    }
}

