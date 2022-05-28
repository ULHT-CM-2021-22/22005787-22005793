package pt.ulusofona.deisi.cm2122.g22005787_22005793

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FireModel (private val dao: FireDao) {

    var region = "Lisboa"
    var risk = Risk.values().random().risco
    val districts = arrayOf(
        "Aveiro", "Beja", "Braga", "Bragança", "Castelo Branco", "Coimbra",
        "Évora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre",
        "Porto", "Santarém", "Setúbal", "Viana do Castelo", "Vila Real", "Viseu"
    )


    fun getHistory(onFinished: (List<FireData>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val list = dao.getAll()
            onFinished(list.map { FireData(it.distrito,it.concelho,it.freguesia,it.meiosOperacionais
            ,it.meiosVeiculos,it.meiosAereos,it.estado,it.data,it.fotos
            ,it.obs,it.pessoa,it.porConfirmar) })
        }
    }

    fun addToHistory(onFinished: () -> Unit,fireData: FireRoom) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(fireData)
            onFinished()
        }

    }


    fun fogosNaRegiao(): String {
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            for (fire in dao.getAll()) {
                if (fire.distrito == region) {
                    count++
                }
            }

        }
        return count.toString()
    }
    fun fogosNaRegiao(regiao: String): String {
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            for (fire in dao.getAll()) {
                if (fire.distrito == regiao) {
                    count++
                }
            }
        }
        return count.toString()
    }

    fun totalFogos(): String {
        var total = ""
        CoroutineScope(Dispatchers.IO).launch {
           total = dao.getAll().size.toString()
        }
        return total
    }

    fun mediaFogosNaRegiao(): String {
        val count = fogosNaRegiao()
        val total = totalFogos()
        val media = (count.toDouble() / total.toDouble())
        return media.toString()
    }

    fun alterarRegiao(regiao: String) {
        if (regiao in districts) {
            region = regiao
        }
    }

    fun alterarRisco() {
        risk = Risk.values().random().risco
    }
}