package pt.ulusofona.deisi.cm2122.g22005787_22005793

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class FireModel {

    var region = ""
    var risk = "Reduzido"
    val districts = arrayOf(
        "Aveiro", "Beja", "Braga", "Bragança", "Castelo Branco", "Coimbra",
        "Évora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre",
        "Porto", "Santarém", "Setúbal", "Viana do Castelo", "Vila Real", "Viseu"
    )



    fun alterarRegiao(onFinished: () -> Unit, regiao: String) {
        if (regiao in districts) {
            region = regiao
        }
        onFinished()
    }


    abstract fun getRisk(distrito:String, onFinished: (String) -> Unit)
    abstract fun getHistory(onFinished: (List<FireData>) -> Unit)
    abstract fun addToHistory(onFinished: () -> Unit, fireData: FireRoom)
    abstract fun fogosNaRegiao(onFinished: (String) -> Unit): String
    abstract fun fogosNaRegiao(onFinished: (String) -> Unit, regiao: String): String
    abstract fun getFogosNaRegiao(onFinished: (List<FireData>) -> Unit, regiao: String)
    abstract fun totalFogos(onFinished: (String) -> Unit): String
    abstract fun totalOperacionais(onFinished: () -> Unit): List<FireRoom>
    abstract fun totalMeiosTerrestres(onFinished: () -> Unit): List<FireRoom>
    abstract fun totalMeiosAereos(onFinished: () -> Unit): List<FireRoom>
    abstract fun mediaFogosNaRegiao(onFinished: (String) -> Unit): String
    abstract fun deleteAll(onFinished: () -> Unit)
    abstract fun insertFires(operations: List<FireData>, onFinished: () -> Unit)



}