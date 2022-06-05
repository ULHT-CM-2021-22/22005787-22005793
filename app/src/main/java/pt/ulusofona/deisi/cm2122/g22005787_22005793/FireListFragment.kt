package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.location.Geocoder
import android.os.BatteryManager
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFireListBinding
import java.util.*

class FireListFragment : Fragment(), OnLocationChangedListener {
    private lateinit var viewModel: FireViewModel
    private var adapter = FireAdapter(onClick = ::onOperationClick, onLongClick = ::onOperationLongClick)
    private lateinit var binding: FragmentFireListBinding
    private lateinit var geocoder: Geocoder
    private var filter = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.fire_list)
        val view = inflater.inflate(R.layout.fragment_fire_list, container, false)
        viewModel = ViewModelProvider(this).get(FireViewModel::class.java)
        binding = FragmentFireListBinding.bind(view)
        geocoder = Geocoder(context, Locale.getDefault())
        FusedLocation.registerListener(this)
        return binding.root
    }



    override fun onStart() {
        super.onStart()
        binding.fireList.layoutManager = LinearLayoutManager(context)
        binding.fireList.adapter = adapter
        if (!filter){
            viewModel.onGetHistory { updateHistory(it) }
        }else{
            viewModel.getOnFogosNaRegiao({ updateHistory(it) },
                viewModel.onGetRegiaoFilter())
        }
        binding.filter.setOnClickListener {
            NavigationManager.goToFiltersFragment(parentFragmentManager)
            filter = true
        }
        viewModel.onTotalFogos() {
            CoroutineScope(Dispatchers.Main).launch {
                binding.fogosTotal.text = it
            }
        }
        val bm = requireActivity().applicationContext.getSystemService(AppCompatActivity.BATTERY_SERVICE) as BatteryManager
        val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        if (batLevel <= 20) {
            binding.riskLayout.setBackgroundColor(resources.getColor(R.color.grey))
        } else {
            backgroundColor(binding.riscoRegiao.text.toString())
        }
    }

    private fun onOperationClick(fireData: FireData) {
        NavigationManager.goToFireDetailsFragment(parentFragmentManager, fireData)
    }

    private fun onOperationLongClick(fireData: FireData): Boolean {
        return false
    }

    private fun updateHistory(fireData: List<FireData>) {
        val history = fireData.map { FireData(it.distrito,it.concelho,it.freguesia,it.meiosOperacionais,
        it.meiosVeiculos,it.meiosAereos,it.estado,it.data,it.fotos,it.obs,it.nomePessoa,it.ccPessoa,it.porConfirmar,
        it.latitude,it.longitude)}
        CoroutineScope(Dispatchers.Main).launch {
            showHistory(history.isNotEmpty())
            adapter.updateItems(history)
        }
    }

    private fun showHistory(show: Boolean) {
        if (show) {
            binding.fireList.visibility = View.VISIBLE
            binding.textNoHistoryAvailable.visibility = View.GONE
        } else {
            binding.fireList.visibility = View.GONE
            binding.textNoHistoryAvailable.visibility = View.VISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        val bm = requireActivity().applicationContext.getSystemService(AppCompatActivity.BATTERY_SERVICE) as BatteryManager
        val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        if (batLevel <= 20) {
            binding.riskLayout.setBackgroundColor(resources.getColor(R.color.grey))
        } else {
            backgroundColor(binding.riscoRegiao.text.toString())
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

    override fun onLocationChanged(latitude: Double, longitude: Double) {
        placeCityName(latitude, longitude)
    }

    override fun onDestroy() {
        super.onDestroy()
        FusedLocation.unregisterListener(this)
    }



}