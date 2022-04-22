package pt.ulusofona.deisi.cm2122.g22005787_22005793

object FireModel {


    var list = arrayListOf(
        Fire(
            "Lisboa", "Lisboa", "Loures",
            1, 2, 3,
            "Ativo", "21/04/2022 - 15:37:21", ArrayList<String>(), "",
            Pessoa("Ambrosio Miguel", "2832382"), false
        ), Fire(
            "Porto", "Vila Nova de Gaia", "Miragaia",
            1, 2, 3,
            "Ativo", "21/04/2022 - 17:04:21", ArrayList<String>(), "",
            Pessoa("Pinto da Costa", "0000000"), false
        ), Fire(
            "Faro", "Albufeira", "Montenegro",
            1, 2, 3,
            "Ativo", "21/04/2022 - 22:37:21", ArrayList<String>(), "",
            Pessoa("Shoya Nakajima", "4656745"), false
        )
    )


    fun getHistory(onFinished: (List<Fire>) -> Unit) {
        onFinished(list)
    }

    fun addToHistory(fire: Fire) {
        list.add(fire)
    }
}