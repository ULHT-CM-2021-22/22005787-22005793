package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.content.Context

class FireRepository private constructor(
    private val context: Context,
    private val local: FireModel, private val remote: FireModel
) {
    val districts: Array<String> = local.districts
    val risk: String = local.risk
    val typeFilter = local.typeFilter

    fun getHistory(onFinished: (List<FireData>) -> Unit) {
        if (ConnectivityUtil.isOnline(context)) {
            remote.getHistory { history ->
                local.deleteAll {
                    local.insertFires(history) {
                        local.getHistory(onFinished)
                        onFinished(history)
                    }
                }
            }
        } else {
            local.getHistory(onFinished)
        }
    }

    fun addToHistory(onFinished: () -> Unit, fireData: FireRoom) {
        local.addToHistory(onFinished, fireData)
    }

    fun fogosNaRegiao(onFinished: (String) -> Unit): String {
        return local.fogosNaRegiao(onFinished)
    }

    fun fogosNaRegiao(onFinished: (String) -> Unit, regiao: String) {
        return local.fogosNaRegiao(onFinished, regiao)
    }

    fun totalFogos(onFinished: (String) -> Unit): String {
        return local.totalFogos(onFinished)
    }

    fun getFogosNaRegiao(onFinished: (List<FireData>) -> Unit, regiao: String) {
        local.getFogosNaRegiao(onFinished, regiao)
    }

    fun mediaFogosNaRegiao(onFinished: (String) -> Unit): String {
        return local.mediaFogosNaRegiao(onFinished)
    }

    fun getRisk(distrito: String, onFinished: (String) -> Unit) {
        if (ConnectivityUtil.isOnline(context)) {
            remote.getRisk(distrito, onFinished)
        }
    }

    fun alterarRegiao(onFinished: () -> Unit, regiao: String) {
        local.alterarRegiao(onFinished, regiao)
    }

    fun getRegion(): String {
        return local.region
    }

    fun getFilter(): String {
        return local.typeFilter
    }

    fun getFogosMeiosVeiculos(onFinished: (List<FireData>) -> Unit) {
        return local.getFogosMeiosVeiculos(onFinished)
    }

    fun getFogosMeiosAereos(onFinished: (List<FireData>) -> Unit) {
        return local.getFogosMeiosAereos(onFinished)
    }

    fun getFogosMeiosOperacionais(onFinished: (List<FireData>) -> Unit) {
        return local.getFogosMeiosOperacionais(onFinished)
    }

    companion object {

        private var instance: FireRepository? = null

        fun init(context: Context, local: FireModel, remote: FireModel) {
            synchronized(this) {
                if (instance == null) {
                    instance = FireRepository(context, local, remote)
                }
            }
        }

        fun getInstance(): FireRepository {
            return instance ?: throw IllegalStateException("Repository not initialized")
        }

    }
}