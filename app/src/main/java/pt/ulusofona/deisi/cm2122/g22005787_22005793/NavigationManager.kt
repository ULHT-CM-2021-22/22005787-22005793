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

    fun goToDashboardFragment(fm: FragmentManager) {
        placeFragment(fm, DashboardFragment())
    }

    fun goToChartFragment(fm: FragmentManager) {
        placeFragment(fm, ChartFragment())
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

    fun goToFireDetailsFragment(fm: FragmentManager, fireData: FireData) {
        placeFragment(fm, FireDetailsFragment.newInstance(fireData))
    }

    fun goToFiltersFragment(fm: FragmentManager) {
        placeFragment(fm, FiltersFragment())
    }

}