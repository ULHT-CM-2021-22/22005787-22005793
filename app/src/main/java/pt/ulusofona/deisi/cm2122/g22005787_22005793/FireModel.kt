package pt.ulusofona.deisi.cm2122.g22005787_22005793

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FireModel(private val dao: FireDao) {

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
            onFinished(list.map {
                FireData(
                    it.distrito,
                    it.concelho,
                    it.freguesia,
                    it.meiosOperacionais,
                    it.meiosVeiculos,
                    it.meiosAereos,
                    it.estado,
                    it.data,
                    it.fotos,
                    it.obs,
                    it.nomePessoa,
                    it.ccPessoa,
                    it.porConfirmar
                )
            })
        }
    }

    fun addToHistory(onFinished: () -> Unit, fireData: FireRoom) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(fireData)
            onFinished()
        }

    }


    fun fogosNaRegiao(onFinished: (String) -> Unit): String {
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            for (fire in dao.getAll()) {
                if (fire.distrito == region) {
                    count++
                }
            }
            onFinished(count.toString())
        }
        return count.toString()
    }

    fun fogosNaRegiao(onFinished: (String) -> Unit, regiao: String): String {
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            for (fire in dao.getAll()) {
                if (fire.distrito == regiao) {
                    count++
                }
            }
            onFinished(count.toString())
        }
        return count.toString()
    }

    fun totalFogos(onFinished: (String) -> Unit): String {
        var total = "0"
        CoroutineScope(Dispatchers.IO).launch {
            total = dao.getAll().size.toString()
            onFinished(total)
        }
        return total
    }

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
}