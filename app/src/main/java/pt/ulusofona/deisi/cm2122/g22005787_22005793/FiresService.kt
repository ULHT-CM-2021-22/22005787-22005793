package pt.ulusofona.deisi.cm2122.g22005787_22005793

import retrofit2.http.GET
import retrofit2.http.Headers

data class GetFiresResponse(val success : Boolean, val id: String, val district: String, val concelho: String, val freguesia: String,
                                 val man: Int, val terrain: Int, val aerial: Int, val status: String,
                                 val data: String, val extra: String)

//
interface FiresService {

    @Headers("Content-Type: application/json")
    @GET("new/fires")
    suspend fun getAll(): List<GetFiresResponse>
}