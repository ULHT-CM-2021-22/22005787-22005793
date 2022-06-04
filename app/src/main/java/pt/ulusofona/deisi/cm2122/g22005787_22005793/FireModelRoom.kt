package pt.ulusofona.deisi.cm2122.g22005787_22005793

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class FireModelRoom(private val dao: FireDao) : FireModel() {

    override fun getRisk(distrito: String, onFinished: (String) -> Unit) {
        TODO("Not yet implemented")
    }

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
                    it.porConfirmar,
                    it.latitude,
                    it.longitude
                )
            })
        }
    }

    override fun insertFires(operations: List<FireData>, onFinished: () -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val history = operations.map {
                FireRoom(
                    it.id,
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
                    it.porConfirmar,
                    it.latitude,
                    it.longitude
                )
            }
            dao.insertAll(history)
            onFinished()
        }
    }

    override fun addToHistory(onFinished: () -> Unit, fireData: FireRoom) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(fireData)
            onFinished()
        }
    }

    override fun deleteAll(onFinished: () -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAll()
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
            count = dao.getFromRegion(regiao).size
            onFinished(count.toString())
        }
        return count.toString()
    }

    override fun getFogosNaRegiao(onFinished: (List<FireData>) -> Unit, regiao: String) {
        CoroutineScope(Dispatchers.IO).launch {
            region = regiao
            val list = dao.getFromRegion(regiao)
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
                    it.porConfirmar,
                    it.latitude,
                    it.longitude
                )
            })
        }
    }

    override fun totalFogos(onFinished: (String) -> Unit): String {
        var total = "0"
        CoroutineScope(Dispatchers.IO).launch {
            total = dao.getAll().size.toString()
            onFinished(total)
        }
        return total
    }

    override fun totalOperacionais(onFinished: () -> Unit): List<FireRoom> {
        val fogos: MutableList<FireRoom> = mutableListOf()
        CoroutineScope(Dispatchers.IO).launch {
            val fogosAtuais = dao.getAll()
            for ( i in fogosAtuais){
                if (i.meiosOperacionais != null || i.meiosOperacionais != "0"){
                   fogos.add(i)
                }
            }
        }
        onFinished()
        return fogos
    }

    override fun totalMeiosTerrestres(onFinished: () -> Unit): List<FireRoom> {
        val fogos: MutableList<FireRoom> = mutableListOf()
        CoroutineScope(Dispatchers.IO).launch {
            for ( i in 0..dao.getAll().size){
                if (dao.getAll()[i].meiosVeiculos != "0"){
                    fogos.add(dao.getAll()[i])
                }
            }
        }
        return fogos
    }

    override fun totalMeiosAereos(onFinished: () -> Unit): List<FireRoom> {
        val fogos: MutableList<FireRoom> = mutableListOf()
        CoroutineScope(Dispatchers.IO).launch {
            for ( i in 0..dao.getAll().size){
                if (dao.getAll()[i].meiosAereos != "0"){
                    fogos.add(dao.getAll()[i])
                }
            }
        }
        return fogos
    }

    override fun mediaFogosNaRegiao(onFinished: (String) -> Unit): String {
        val count: String = fogosNaRegiao(onFinished)
        val total: String = totalFogos(onFinished)
        val media = (count.toDouble() / total.toDouble())
        onFinished(media.toString())
        return media.toString()
    }
}