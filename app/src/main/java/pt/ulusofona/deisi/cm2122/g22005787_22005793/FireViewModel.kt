package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FireViewModel(application: Application) : AndroidViewModel(application) {
    private val model = FireModelRoom(FireDatabase.getInstance(application).fireDao())
    private val model2 = FireRetrofit(RetrofitBuilder.getInstance("https://api-dev.fogos.pt/"))

    fun onGetHistory(onFinished: (List<FireData>) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            model2.getHistory(onFinished)
        }
    }

    fun onAddToHistory(onFinished: () -> Unit, fireData: FireRoom) {
        model.addToHistory(onFinished, fireData)
    }

    fun onFogosNaRegiao(onFinished: (String) -> Unit): String {
        return model.fogosNaRegiao(onFinished)
    }

    fun onFogosNaRegiao(onFinished: (String) -> Unit,regiao: String): String {
        return model.fogosNaRegiao(onFinished, regiao)
    }

    fun onTotalFogos(onFinished: (String) -> Unit): String {
        return model.totalFogos(onFinished)
    }

    fun onMediaFogosNaRegiao(onFinished: (String) -> Unit): String {
        return model.mediaFogosNaRegiao(onFinished)
    }

    fun onAlterarRegiao(onFinished: () -> Unit,regiao: String) {
        model.alterarRegiao(onFinished, regiao)
    }

    fun onAlterarRisco(onFinished: () -> Unit) {
        model.alterarRisco(onFinished)
    }

    fun onGetRisk(): String {
        return model.risk
    }

    fun onGetDistricts(): Array<String> {
        return model.districts
    }
}