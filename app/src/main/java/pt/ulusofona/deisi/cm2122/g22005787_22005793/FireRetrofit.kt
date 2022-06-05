package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Retrofit
import java.lang.Exception

class FireRetrofit(retrofit: Retrofit) : FireModel() {

    private val TAG = FireRetrofit::class.java.simpleName
    private val service = retrofit.create(FiresService::class.java)

    override fun getRisk(distrito:String ,onFinished: (String) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                if (distrito == "Lisbon"){
                    val riskRaw = service.getRisk("Lisboa")
                    var risk = riskRaw.data
                    risk = risk.split("-")[1]
                    risk = risk.split(",")[0]
                    onFinished(risk.substring(1))
            }else {
                    val riskRaw = service.getRisk(distrito)
                    var risk = riskRaw.data
                    risk = risk.split("-")[1]
                    risk = risk.split(",")[0]
                    onFinished(risk.substring(1))
                }
            } catch (ex: HttpException) {
                Log.e(TAG, ex.message())
            }
        }
    }


    override fun getHistory(onFinished: (List<FireData>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val fires = service.getAll().body()?.data
                if (fires != null) {
                    onFinished(fires.map {
                        FireData(
                            it.district,
                            it.concelho,
                            it.freguesia,
                            it.man.toString(),
                            it.terrain.toString(),
                            it.aerial.toString(),
                            it.status,
                            data = "${it.data} / ${it.hour}",
                            null,
                            it.extra,
                            null,
                            null,
                            false,
                            it.lat,
                            it.lng
                        )
                    })
                }
            } catch (ex: HttpException) {
                Log.e(TAG, ex.message())
            }
        }
    }

    override fun addToHistory(onFinished: () -> Unit, fireData: FireRoom) {
        throw Exception("Not implemented on web service")
    }

    override fun fogosNaRegiao(onFinished: (String) -> Unit): String {
        TODO("Not yet implemented")
    }

    override fun fogosNaRegiao(onFinished: (String) -> Unit, regiao: String){
        TODO("Not yet implemented")
    }

    override fun getFogosNaRegiao(onFinished: (List<FireData>) -> Unit, regiao: String) {
        TODO("Not yet implemented")
    }

    override fun totalFogos(onFinished: (String) -> Unit): String {
        TODO("Not yet implemented")
    }

    override fun totalOperacionais(onFinished: () -> Unit): List<FireRoom> {
        TODO("Not yet implemented")
    }

    override fun totalMeiosTerrestres(onFinished: ()-> Unit): List<FireRoom> {
        TODO("Not yet implemented")
    }

    override fun totalMeiosAereos(onFinished: () -> Unit): List<FireRoom> {
        TODO("Not yet implemented")
    }

    override fun mediaFogosNaRegiao(onFinished: (String) -> Unit): String {
        TODO("Not yet implemented")
    }

    override fun deleteAll(onFinished: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun insertFires(operations: List<FireData>, onFinished: () -> Unit) {
        throw Exception("Not implemented on web service")
    }


}