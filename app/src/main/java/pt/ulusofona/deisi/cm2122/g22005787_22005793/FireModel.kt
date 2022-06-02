package pt.ulusofona.deisi.cm2122.g22005787_22005793

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class FireModel {

    var region = "Lisboa"
    var risk = Risk.values().random().risco
    val districts = arrayOf(
        "Aveiro", "Beja", "Braga", "Bragança", "Castelo Branco", "Coimbra",
        "Évora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre",
        "Porto", "Santarém", "Setúbal", "Viana do Castelo", "Vila Real", "Viseu"
    )

    fun mediaFogosNaRegiao(onFinished: (String) -> Unit): String {
        val count: String = fogosNaRegiao(onFinished)
        val total: String = totalFogos(onFinished)
        val media = (count.toDouble() / total.toDouble())
        return media.toString()
    }

    fun alterarRegiao(onFinished: () -> Unit, regiao: String) {
        if (regiao in districts) {
            region = regiao
        }
        onFinished()
    }

    fun alterarRisco(onFinished: () -> Unit) {
        risk = Risk.values().random().risco
        onFinished()
    }

    abstract fun getHistory(onFinished: (List<FireData>) -> Unit)
    abstract fun addToHistory(onFinished: () -> Unit, fireData: FireRoom)
    abstract fun fogosNaRegiao(onFinished: (String) -> Unit): String
    abstract fun fogosNaRegiao(onFinished: (String) -> Unit, regiao: String): String
    abstract fun totalFogos(onFinished: (String) -> Unit): String
    abstract fun deleteAll(onFinished: () -> Unit)
    abstract fun insertFires(operations: List<FireData>, onFinished: () -> Unit)


}