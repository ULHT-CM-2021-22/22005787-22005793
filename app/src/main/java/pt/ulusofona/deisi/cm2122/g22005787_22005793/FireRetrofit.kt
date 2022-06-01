package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Retrofit
import java.lang.Exception

class FireRetrofit(retrofit: Retrofit): FireModel() {

    private val TAG = FireRetrofit::class.java.simpleName
    private val service = retrofit.create(FiresService::class.java)


    override fun getHistory(onFinished: (List<FireData>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val fires = service.getAll().body()?.data
                if (fires != null) {
                    onFinished(fires.map{ FireData(it.district,it.concelho,it.freguesia,it.man.toString(),
                        it.toString(),it.toString(),it.status,it.data,null,it.extra,null,null,false) })
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

    override fun fogosNaRegiao(onFinished: (String) -> Unit, regiao: String): String {
        TODO("Not yet implemented")
    }

    override fun totalFogos(onFinished: (String) -> Unit): String {
        TODO("Not yet implemented")
    }


}