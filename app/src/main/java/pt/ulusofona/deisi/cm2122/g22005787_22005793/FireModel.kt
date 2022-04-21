package pt.ulusofona.deisi.cm2122.g22005787_22005793

object FireModel {
    var list = ArrayList<Fire>()

    fun fillList(){
        val fire1 = Fire("Lisboa","Lisboa","Loures",
            1,2,3,
            "Ativo","21/04/2022 - 15:37:21",ArrayList<String>(),"",
            Pessoa("Ambrosio Miguel","2832382"),false
        )
        list.add(fire1)
    }

    fun getHistory(onFinished: (List<Fire>) -> Unit){
        onFinished(list)
    }
}