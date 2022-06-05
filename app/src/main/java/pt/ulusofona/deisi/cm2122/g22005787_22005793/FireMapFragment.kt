package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.location.Geocoder
import android.location.Location
import android.os.BatteryManager
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFireMapBinding
import java.util.*
import kotlin.collections.ArrayList


class FireMapFragment : Fragment(), OnLocationChangedListener, OnMapReadyCallback{

    private lateinit var binding: FragmentFireMapBinding
    private lateinit var geocoder: Geocoder
    private var map: GoogleMap? = null
    private var listFires: List<FireData> = ArrayList()
    private var adapter =
        FireAdapter(onClick = ::onOperationClick, onLongClick = ::onOperationLongClick)

    private fun onOperationLongClick(fireData: FireData): Boolean {
        NavigationManager.goToFireDetailsFragment(parentFragmentManager, fireData)
        return true
    }

    private fun onOperationClick(fireData: FireData) {
        NavigationManager.goToFireDetailsFragment(parentFragmentManager, fireData)
    }

    private lateinit var viewModel: FireViewModel


    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.fire_map)
        val view = inflater.inflate(R.layout.fragment_fire_map, container, false)
        binding = FragmentFireMapBinding.bind(view)
        geocoder = Geocoder(context, Locale.getDefault())
        binding.map.onCreate(savedInstanceState)
        binding.map.getMapAsync {
            map = it
            it.isMyLocationEnabled = true
            FusedLocation.registerListener(this)
        }
        viewModel = ViewModelProvider(this).get(FireViewModel::class.java)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.onGetHistory { updateHistory(it) }
        val bm = requireActivity().applicationContext.getSystemService(AppCompatActivity.BATTERY_SERVICE) as BatteryManager
        val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        if (batLevel <= 20) {
            binding.riskLayout.setBackgroundColor(resources.getColor(R.color.grey))
        } else {
            backgroundColor(binding.riscoRegiao.text.toString())
        }
    }


    override fun onLocationChanged(latitude: Double, longitude: Double) {
        placeCamera(latitude, longitude)
        placeCityName(latitude, longitude)
    }

    private fun placeCamera(latitude: Double, longitude: Double) {
        val cameraPosition = CameraPosition.Builder()
            .target(LatLng(latitude, longitude))
            .zoom(6f)
            .build()
        map?.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }

    override fun onPause() {
        super.onPause()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
    }

    override fun onResume() {
        super.onResume()
        binding.map.onResume()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val bm = requireActivity().applicationContext.getSystemService(AppCompatActivity.BATTERY_SERVICE) as BatteryManager
        val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        if (batLevel <= 20) {
            binding.riskLayout.setBackgroundColor(resources.getColor(R.color.grey))
        } else {
            backgroundColor(binding.riscoRegiao.text.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        FusedLocation.unregisterListener(this)
    }

    private fun updateHistory(fireData: List<FireData>) {
        val history = fireData.map {
            FireData(
                it.distrito,
                it.concelho,
                it.freguesia,
                it.meiosOperacionais,
                it.meiosVeiculos,
                it.meiosAereos,
                it.estado,
                it.data,
                it.fotos,
                it.obs,
                it.nomePessoa,
                it.ccPessoa,
                it.porConfirmar,
                it.latitude,
                it.longitude
            )
        }
        CoroutineScope(Dispatchers.Main).launch {
            adapter.updateItems(history)
            for (i in history) {
                when (i.estado) {
                    "Conclusão" -> {
                        map?.addMarker(
                            MarkerOptions().position(LatLng(i.latitude, i.longitude)).icon(
                                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                            )
                        )
                    }
                    "Vigilância" -> {
                        map?.addMarker(
                            MarkerOptions().position(LatLng(i.latitude, i.longitude)).icon(
                                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)
                            )
                        )
                    }
                    "Em Resolução" -> {
                        map?.addMarker(
                            MarkerOptions().position(LatLng(i.latitude, i.longitude)).icon(
                                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                            )
                        )
                    }
                    "Em Curso" -> {
                        map?.addMarker(
                            MarkerOptions().position(LatLng(i.latitude, i.longitude))
                        )
                    }
                    "Despacho de 1º Alerta", "Despacho" -> {
                        map?.addMarker(
                            MarkerOptions().position(LatLng(i.latitude, i.longitude)).icon(
                                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
                            )
                        )
                    }
                    else -> {
                        map?.addMarker(
                            MarkerOptions().position(LatLng(i.latitude, i.longitude)).icon(
                                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
                            )
                        )
                    }
                }
                map?.setOnMarkerClickListener { marker ->
                    onMarkerClick(marker)
                }
            }
        }
    }

    private fun backgroundColor(risk: String) {
        when (risk) {
            Risk.MAXIMUM.risco -> binding.riskLayout.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            Risk.VERYHIGH.risco -> binding.riskLayout.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            Risk.HIGH.risco -> binding.riskLayout.setBackgroundColor(resources.getColor(R.color.yellow))
            Risk.MODERATE.risco -> binding.riskLayout.setBackgroundColor(resources.getColor(R.color.green))
            Risk.REDUCED.risco -> binding.riskLayout.setBackgroundColor(resources.getColor(R.color.green))
        }
    }

    private fun onMarkerClick(p0: Marker): Boolean {
        viewModel.onGetHistory {
            updateHistory(it)
            listFires = it
        }
        for (i in listFires) {
            if (p0.position.latitude == i.latitude && p0.position.longitude == i.longitude) {
                NavigationManager.goToFireDetailsFragment(parentFragmentManager, i)
            }
        }
        return true
    }

    override fun onMapReady(p0: GoogleMap) {
        viewModel.onGetHistory { updateHistory(it) }
    }

    private fun placeCityName(latitude: Double, longitude: Double) {
        val addresses = geocoder.getFromLocation(latitude, longitude, 5)
        val location = addresses.first { it.locality != null && it.locality.isNotEmpty() }
        viewModel.onAlterarRegiao({},location.adminArea)
        viewModel.onGetRisk(location.adminArea) {
            binding.riscoRegiao.text = it
        }
        val bm = requireActivity().applicationContext.getSystemService(AppCompatActivity.BATTERY_SERVICE) as BatteryManager
        val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        if (batLevel <= 20) {
            binding.riskLayout.setBackgroundColor(resources.getColor(R.color.grey))
        } else {
            backgroundColor(binding.riscoRegiao.text.toString())
        }
    }


}