package pt.ulusofona.deisi.cm2122.g22005787_22005793

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

data class Fires(
    @SerializedName("id") val id: String,
    @SerializedName("district")  val district: String,
    @SerializedName("concelho") val concelho: String,
    @SerializedName("freguesia") val freguesia: String,
    @SerializedName("man") val man: Int,
    @SerializedName("terrain") val terrain: Int,
    @SerializedName("aerial")  val aerial: Int,
    @SerializedName("status") val status: String,
    @SerializedName("date") val data: String,
    @SerializedName("hour") val hour: String,
    @SerializedName("extra")  val extra: String
)

class firesList: ArrayList<Fires>()

data class GetFiresResponse(
    @SerializedName("data") val data: firesList
)


interface FiresService {

    @Headers("Content-Type: application/json")
    @GET("new/fires")
    suspend fun getAll(): Response<GetFiresResponse>
}