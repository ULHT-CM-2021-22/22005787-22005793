package pt.ulusofona.deisi.cm2122.g22005787_22005793

object FireModel {

    var region = "Lisboa"
    var risk = Risk.values().random().risco
    var list = arrayListOf(
        FireData(
            "Lisboa", "Sintra", "Mem Martins",
            1, 2, 3,
            "Ativo", "12/04/2022 - 11:05:21", ArrayList<String>(), "",
            Pessoa("Bernardo Vinagre", "2832382"), false
        ),
        FireData(
            "Porto", "Penafiel", "Cabeça Santa",
            3, 4, 1,
            "Ativo", "15/11/2020 - 17:56:00", ArrayList<String>(), "Terreno muito grande",
            Pessoa("Gonçalo Matias", "46544694"), false
        ), FireData(
            "Porto", "Vila Nova de Gaia", "Miragaia",
            1, 2, 3,
            "Ativo", "21/04/2022 - 17:04:21", ArrayList<String>(), "",
            Pessoa("Pinto da Costa", "0000000"), false
        ), FireData(
            "Faro", "Portimão", "Montenegro",
            1, 2, 3,
            "Ativo", "21/04/2022 - 22:37:21", ArrayList<String>(), "",
            Pessoa("Shoya Nakajima", "4656745"), false
        ),
        FireData(
            "Porto", "Porto", "Porto",
            7, 2, 3,
            "Controlado", "14/04/2022 - 04:04:21", ArrayList<String>(), "Clima estava tenso",
            Pessoa("Bernardo Vinagre", "2832382"), false
        )
    )

    val districts = arrayOf(
        "Aveiro", "Beja", "Braga", "Bragança", "Castelo Branco", "Coimbra",
        "Évora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre",
        "Porto", "Santarém", "Setúbal", "Viana do Castelo", "Vila Real", "Viseu"
    )


    fun getHistory(onFinished: (List<FireData>) -> Unit) {
        onFinished(list)
    }

    fun addToHistory(fireData: FireData) {
        list.add(fireData)
    }

    fun infNotAvailable(view: String): String {
        if (view == "" || view == "0") {
            return "Informação não disponivel"
        }
        return view
    }

    fun showInf(fireData: FireData): String {
        return "Concelho -> ${infNotAvailable(fireData.concelho)} \nFreguesia -> ${
            infNotAvailable(
                fireData.freguesia
            )
        } \n" +
                "Estado -> ${infNotAvailable(fireData.estado)} \nData -> ${infNotAvailable(fireData.data)}"
    }

    fun fogosNaRegiao(): String {
        var count = 0
        for (fire in list) {
            if (fire.distrito == region) {
                count++
            }
        }
        return count.toString()
    }

    fun totalFogos(): String {
        return list.size.toString()
    }

    fun mediaFogosNaRegiao(): String {
        val count = fogosNaRegiao()
        val total = totalFogos()
        val media = (count.toInt() / total.toInt()).toString()
        if (media == "0") {
            return "1"
        }
        return media
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