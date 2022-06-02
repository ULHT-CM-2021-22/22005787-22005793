package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.content.Context

class FireRepository private constructor(
    private val context: Context,
    private val local: FireModel, private val remote: FireModel
) {
    val districts: Array<String> = local.districts
    val risk: String = local.risk

    fun  getHistory(onFinished: (List<FireData>) -> Unit) {
        if (ConnectivityUtil.isOnline(context)) {
            remote.getHistory { history ->
                local.deleteAll {
                    local.insertFires(history) {
                        onFinished(history)
                    }
                }
            }
        } else {
            local.getHistory(onFinished)
        }
    }
//
    fun addToHistory(onFinished: () -> Unit, fireData: FireRoom) {
        local.addToHistory(onFinished, fireData)
    }

    fun fogosNaRegiao(onFinished: (String) -> Unit): String {
        return local.fogosNaRegiao(onFinished)
    }

    fun fogosNaRegiao(onFinished: (String) -> Unit, regiao: String): String {
        return local.fogosNaRegiao(onFinished, regiao)
    }

    fun totalFogos(onFinished: (String) -> Unit): String {
        return local.totalFogos(onFinished)
    }

    fun mediaFogosNaRegiao(onFinished: (String) -> Unit): String {
        return local.mediaFogosNaRegiao(onFinished)
    }

    fun alterarRegiao(onFinished: () -> Unit, regiao: String) {
        local.alterarRegiao(onFinished, regiao)
    }

    fun alterarRisco(onFinished: () -> Unit) {
        local.alterarRisco(onFinished)
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