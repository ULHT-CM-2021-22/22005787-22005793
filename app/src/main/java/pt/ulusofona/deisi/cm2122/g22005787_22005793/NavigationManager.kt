package pt.ulusofona.deisi.cm2122.g22005787_22005793

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object NavigationManager {

    private fun placeFragment(fm: FragmentManager, fragment: Fragment) {
        val transition = fm.beginTransaction()
        transition.replace(R.id.frame, fragment)
        transition.addToBackStack(null)
        transition.commit()
    }

    fun goToFireListFragment(fm: FragmentManager) {
        placeFragment(fm, FireListFragment())
    }

    fun goToFireMapFragment(fm: FragmentManager) {
        placeFragment(fm, FireMapFragment())
    }

    fun goToFireRegistrationFragment(fm: FragmentManager) {
        placeFragment(fm, FireRegistrationFragment())
    }

    fun goToFireDetailsFragment(fm: FragmentManager, fire: Fire) {
        placeFragment(fm, FireDetailsFragment.newInstance(fire))
    }
}