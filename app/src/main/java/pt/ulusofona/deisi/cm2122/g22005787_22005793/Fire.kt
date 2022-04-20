package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fire (val uuid: String, val expression: String, val result: Double, val timestamp: Long): Parcelable {
}