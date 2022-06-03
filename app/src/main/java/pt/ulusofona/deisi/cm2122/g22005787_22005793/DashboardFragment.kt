package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.content.DialogInterface
import android.content.pm.ActivityInfo
import android.location.Geocoder
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentDashboardBinding
import java.util.*


class DashboardFragment : Fragment(), OnLocationChangedListener {

    private lateinit var binding: FragmentDashboardBinding
    private lateinit var viewModel: FireViewModel
    private lateinit var geocoder: Geocoder
    private var adapter =
        FireAdapter(onClick = ::onOperationClick, onLongClick = ::onOperationLongClick)
    private val timer = object : CountDownTimer(20000, 1000) {
        override fun onTick(millisUntilFinished: Long) {}
        override fun onFinish() {
            updateDashboard()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.app_name)
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        geocoder = Geocoder(context, Locale.getDefault())
        viewModel = ViewModelProvider(this).get(FireViewModel::class.java)
        binding = FragmentDashboardBinding.bind(view)
        FusedLocation.registerListener(this)
        updateDashboard()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        updateDashboard()
    }

    override fun onResume() {
        super.onResume()
        timer.start()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onDestroy() {
        super.onDestroy()
        FusedLocation.unregisterListener(this)
        timer.cancel()
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
    }

    private fun updateDashboard() {
        viewModel.onGetHistory { updateHistory(it) }
        viewModel.onFogosNaRegiao() {
            CoroutineScope(Dispatchers.Main).launch {
                binding.fogosRegiao.text = it
            }
        }
        viewModel.onTotalFogos() {
            CoroutineScope(Dispatchers.Main).launch {
                binding.fogosTotal.text = it
            }
        }

        viewModel.onMediaFogosNaRegiao() {
            CoroutineScope(Dispatchers.Main).launch {
                binding.mediaFogosRegiao.text = it
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
        }
    }

    private fun onOperationClick(fireData: FireData) {
    }

    private fun onOperationLongClick(fireData: FireData): Boolean {
        return false
    }

    override fun onLocationChanged(latitude: Double, longitude: Double) {
        placeCityName(latitude,longitude)
        updateDashboard()
    }

    private fun placeCityName(latitude: Double, longitude: Double) {
        val addresses = geocoder.getFromLocation(latitude, longitude, 5)
        val location = addresses.first { it.locality != null && it.locality.isNotEmpty() }
        binding.textRegion.text = location.locality
        viewModel.onAlterarRegiao({},location.locality)
        viewModel.onGetRisk(location.locality) {
            binding.riscoRegiao.text = it
        }
        backgroundColor(binding.riscoRegiao.text.toString())
    }


}