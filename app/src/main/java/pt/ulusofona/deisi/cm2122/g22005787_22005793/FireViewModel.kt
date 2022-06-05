package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FireViewModel(application: Application) : AndroidViewModel(application) {
    private val model = FireRepository.getInstance()

    fun onGetHistory(onFinished: (List<FireData>) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            model.getHistory(onFinished)
        }
    }

    fun onAddToHistory(onFinished: () -> Unit, fireData: FireRoom) {
        model.addToHistory(onFinished, fireData)
    }

    fun onFogosNaRegiao(onFinished: (String) -> Unit): String {
        return model.fogosNaRegiao(onFinished)
    }

    fun onFogosNaRegiao(onFinished: (String) -> Unit,regiao: String) {
        return model.fogosNaRegiao(onFinished, regiao)
    }

    fun getOnFogosNaRegiao(onFinished: (List<FireData>) -> Unit,regiao: String){
        CoroutineScope(Dispatchers.Main).launch {
            model.getFogosNaRegiao(onFinished, regiao)
        }
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

    fun onGetRisk(distrito:String ,onFinished: (String) -> Unit){
        model.getRisk(distrito, onFinished)
    }

    fun onGetRegiaoFilter(): String {
        return model.getRegion()
    }

    fun meiosOperacionais(onFinished: (List<FireData>) -> Unit){
        return model.getFogosMeiosOperacionais(onFinished)
    }

    fun getFilter():String{
        return model.getFilter()
    }

    fun meiosTerrestres(onFinished: (List<FireData>) -> Unit) {
        return model.getFogosMeiosVeiculos(onFinished)
    }

    fun meiosAereos(onFinished: (List<FireData>) -> Unit) {
        return model.getFogosMeiosAereos(onFinished)
    }

}