package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.app.Application

class FireApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FusedLocation.start(this)
        FireRepository.init(this,
            FireModelRoom(FireDatabase.getInstance(this).fireDao()),
            FireRetrofit(RetrofitBuilder.getInstance("https://cm-calculadora.herokuapp.com/api/"))
        )
    }
}