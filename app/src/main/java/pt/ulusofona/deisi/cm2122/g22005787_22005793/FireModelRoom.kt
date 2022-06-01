package pt.ulusofona.deisi.cm2122.g22005787_22005793

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FireModelRoom (private val dao: FireDao): FireModel() {
    override fun getHistory(onFinished: (List<FireData>) -> Unit) {
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

    override fun addToHistory(onFinished: () -> Unit, fireData: FireRoom) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(fireData)
            onFinished()
        }
    }

    override fun fogosNaRegiao(onFinished: (String) -> Unit): String {
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

    override fun fogosNaRegiao(onFinished: (String) -> Unit, regiao: String): String {
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

    override fun totalFogos(onFinished: (String) -> Unit): String {
        var total = "0"
        CoroutineScope(Dispatchers.IO).launch {
            total = dao.getAll().size.toString()
            onFinished(total)
        }
        return total
    }

}