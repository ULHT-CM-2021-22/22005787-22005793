package pt.ulusofona.deisi.cm2122.g22005787_22005793

object FireModel {


    var list = arrayListOf(
        Fire(
            "Lisboa", "Sintra", "Mem Martins",
            1, 2, 3,
            "Ativo", "12/04/2022 - 11:05:21", ArrayList<String>(), "",
            Pessoa("Bernardo Vinagre", "2832382"), false
        ),
        Fire(
            "Porto", "Penafiel", "Cabeça Santa",
            1, 2, 3,
            "Ativo", "15/11/2020 - 17:56:00", ArrayList<String>(), "Terreno muito grande",
            Pessoa("Gonçalo Matias", "46544694"), false
        ),Fire(
            "Porto", "Vila Nova de Gaia", "Miragaia",
            1, 2, 3,
            "Ativo", "21/04/2022 - 17:04:21", ArrayList<String>(), "",
            Pessoa("Pinto da Costa", "0000000"), false
        ), Fire(
            "Faro", "Portimão", "Montenegro",
            1, 2, 3,
            "Ativo", "21/04/2022 - 22:37:21", ArrayList<String>(), "",
            Pessoa("Shoya Nakajima", "4656745"), false
        ),
        Fire(
            "Porto", "Porto", "Porto",
            7, 2, 3,
            "Controlado", "14/04/2022 - 04:04:21", ArrayList<String>(), "Clima estava tenso",
            Pessoa("Bernardo Vinagre", "2832382"), false
        )
    )


    fun getHistory(onFinished: (List<Fire>) -> Unit) {
        onFinished(list)
    }

    fun addToHistory(fire: Fire) {
        list.add(fire)
    }
}