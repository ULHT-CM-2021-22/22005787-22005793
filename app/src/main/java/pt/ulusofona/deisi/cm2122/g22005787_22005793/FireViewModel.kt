package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FireViewModel(application: Application) : AndroidViewModel(application) {
    private val model = FireModel(FireDatabase.getInstance(application).fireDao())

    fun onGetHistory(onFinished: (List<FireData>) -> Unit) {
        model.getHistory(onFinished)
    }

    fun onAddToHistory(onFinished: () -> Unit, fireData: FireRoom) {
        model.addToHistory(onFinished, fireData)
    }

    fun onFogosNaRegiao(): String {
        return model.fogosNaRegiao()
    }

    fun onFogosNaRegiao(regiao: String): String {
        return model.fogosNaRegiao(regiao)
    }

    fun onTotalFogos(): String {
        return model.totalFogos()
    }

    fun onMediaFogosNaRegiao(): String {
        return model.mediaFogosNaRegiao()
    }

    fun onAlterarRegiao(regiao: String) {
        model.alterarRegiao(regiao)
    }

    fun onAlterarRisco() {
        model.alterarRisco()
    }

    fun onGetRisk(): String {
        return model.risk
    }

    fun onGetDistricts(): Array<String> {
        return model.districts
    }
}