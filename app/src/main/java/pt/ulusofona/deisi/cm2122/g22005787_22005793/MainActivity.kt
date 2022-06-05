package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.Manifest
import android.app.UiModeManager
import android.content.Context
import android.os.BatteryManager
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import com.fondesa.kpermissions.allGranted
import com.fondesa.kpermissions.extension.permissionsBuilder
import com.fondesa.kpermissions.extension.send
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        permissionsBuilder(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION).build().send { result ->
            if (result.allGranted()) {
                if (!screenRotated(savedInstanceState)) {
                    NavigationManager.goToDashboardFragment(supportFragmentManager)
                }
            } else {
                finish()
            }
        }


    }

    private fun screenRotated(savedInstanceState: Bundle?): Boolean {
        return savedInstanceState != null
    }

    override fun onStart() {
        super.onStart()
        setSupportActionBar(binding.toolbar)
        setupDrawerMenu()
        autonomia()

    }

    override fun onResume() {
        super.onResume()
        autonomia()
    }

    private fun autonomia(){
        val bm = applicationContext.getSystemService(BATTERY_SERVICE) as BatteryManager
        val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        if (batLevel <= 20) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }

    private fun setupDrawerMenu(){
        val toggle = ActionBarDrawerToggle(this,
            binding.drawer, binding.toolbar,
            R.string.drawer_open,R.string.drawer_closed
        )
        binding.navDrawer.setNavigationItemSelectedListener {
            onClickNavigationItem(it)
        }
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun onClickNavigationItem(item: MenuItem): Boolean{
        when(item.itemId) {
            R.id.nav_dashboard -> NavigationManager.goToDashboardFragment(supportFragmentManager)
            R.id.nav_fireList -> NavigationManager.goToFireListFragment(supportFragmentManager)
            R.id.nav_fireMap -> NavigationManager.goToFireMapFragment(supportFragmentManager)
            R.id.nav_newFire -> NavigationManager.goToFireRegistrationFragment(supportFragmentManager)
            R.id.nav_chart -> NavigationManager.goToChartFragment(supportFragmentManager)
            R.id.nav_exit-> finish()
        }
        binding.drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        when {
            binding.drawer.isDrawerOpen(GravityCompat.START) -> binding.drawer.closeDrawer(
                GravityCompat.START)
            supportFragmentManager.backStackEntryCount == 1 -> finish()
            else -> super.onBackPressed()
        }
    }
}