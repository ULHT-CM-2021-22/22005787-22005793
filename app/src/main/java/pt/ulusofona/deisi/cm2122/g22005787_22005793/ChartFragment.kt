package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.content.pm.ActivityInfo
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.eazegraph.lib.models.PieModel
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentChartBinding
import java.util.*


class ChartFragment : Fragment(), OnLocationChangedListener {
    private lateinit var binding: FragmentChartBinding
    private lateinit var viewModel: FireViewModel
    private lateinit var geocoder: Geocoder
    private var adapter =
        FireAdapter(onClick = ::onOperationClick, onLongClick = ::onOperationLongClick)

    private fun onOperationLongClick(fireData: FireData): Boolean {
        return false
    }

    private fun onOperationClick(fireData: FireData) {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.chart_name)
        val view = inflater.inflate(R.layout.fragment_chart, container, false)
        viewModel = ViewModelProvider(this).get(FireViewModel::class.java)
        binding = FragmentChartBinding.bind(view)
        geocoder = Geocoder(context, Locale.getDefault())
        FusedLocation.registerListener(this)
        districtsInChart()
        binding.piechart.startAnimation()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        updateDashboard()
    }

    override fun onResume() {
        super.onResume()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onDestroy() {
        super.onDestroy()
        FusedLocation.unregisterListener(this)
    }

    override fun onPause() {
        super.onPause()

        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
    }

    private fun placeCityName(latitude: Double, longitude: Double) {
        val addresses = geocoder.getFromLocation(latitude, longitude, 5)
        val location = addresses.first { it.locality != null && it.locality.isNotEmpty() }
        viewModel.onAlterarRegiao({}, location.adminArea)
        viewModel.onGetRisk(location.adminArea) {
            binding.riscoRegiao.text = it
        }
        val bm =
            requireActivity().applicationContext.getSystemService(AppCompatActivity.BATTERY_SERVICE) as BatteryManager
        val batLevel: Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        if (batLevel <= 20) {
            binding.riskLayout.setBackgroundColor(resources.getColor(R.color.grey))
        } else {
            backgroundColor(binding.riscoRegiao.text.toString())
        }
    }

    private fun districtsInChart() {

        var region = 0f
        viewModel.onGetHistory { updateHistory(it) }


        viewModel.onGetHistory { region = addSlice(it, binding.aveiro.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.aveiro.text.toString(),
                region,
                resources.getColor(R.color.red)
            )
        )

        binding.aveiro.append(
            " (${region.toInt()})"
        )


        viewModel.onGetHistory { region = addSlice(it, binding.lisboa.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.lisboa.text.toString(),
                region,
                resources.getColor(R.color.black)
            )
        )

        binding.lisboa.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.porto.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.porto.text.toString(),
                region,
                resources.getColor(R.color.blue)
            )
        )

        binding.porto.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.beja.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.beja.text.toString(),
                region,
                resources.getColor(R.color.colorAccent)
            )
        )

        binding.beja.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.braga.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.braga.text.toString(),
                region,
                resources.getColor(R.color.green)
            )
        )

        binding.braga.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.braganca.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.braganca.text.toString(),
                region,
                resources.getColor(R.color.grey)
            )
        )

        binding.braganca.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory {
            region = addSlice(it, binding.casteloBranco.text.toString()).toFloat()
        }
        binding.piechart.addPieSlice(
            PieModel(
                binding.casteloBranco.text.toString(),
                region,
                resources.getColor(R.color.purple_200)
            )
        )

        binding.casteloBranco.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.coimbra.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.coimbra.text.toString(),
                region,
                resources.getColor(R.color.real_green)
            )
        )

        binding.coimbra.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.evora.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.evora.text.toString(),
                region,
                resources.getColor(R.color.pink)
            )
        )

        binding.evora.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.faro.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.faro.text.toString(),
                region,
                resources.getColor(R.color.purple_500)
            )
        )

        binding.faro.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.guarda.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.guarda.text.toString(),
                region,
                resources.getColor(R.color.purple_700)
            )
        )

        binding.guarda.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.leiria.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.leiria.text.toString(),
                region,
                resources.getColor(R.color.colorPrimary)
            )
        )

        binding.leiria.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory {
            region = addSlice(it, binding.portalegre.text.toString()).toFloat()
        }
        binding.piechart.addPieSlice(
            PieModel(
                binding.portalegre.text.toString(),
                region,
                resources.getColor(R.color.yellow)
            )
        )

        binding.portalegre.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.santarem.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.santarem.text.toString(),
                region,
                resources.getColor(R.color.brown)
            )
        )

        binding.santarem.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.setubal.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.setubal.text.toString(),
                region,
                resources.getColor(R.color.orange)
            )
        )

        binding.setubal.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory {
            region = addSlice(it, binding.vianaDoCastelo.text.toString()).toFloat()
        }
        binding.piechart.addPieSlice(
            PieModel(
                binding.vianaDoCastelo.text.toString(),
                region,
                resources.getColor(R.color.orangeDark)
            )
        )

        binding.vianaDoCastelo.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.vilaReal.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.vilaReal.text.toString(),
                region,
                resources.getColor(R.color.teal_200)
            )
        )

        binding.vilaReal.append(
            " (${region.toInt()})"
        )

        viewModel.onGetHistory { region = addSlice(it, binding.viseu.text.toString()).toFloat() }
        binding.piechart.addPieSlice(
            PieModel(
                binding.viseu.text.toString(),
                region,
                resources.getColor(R.color.teal_700)
            )
        )

        binding.viseu.append(
            " (${region.toInt()})"
        )
    }

    private fun updateDashboard() {


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

    private fun addSlice(fireData: List<FireData>, region: String): String {
        var count = 0
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
        for (i in history) {
            if (i.distrito == region) {
                count++
            }
        }
        return count.toString()
    }

    override fun onLocationChanged(latitude: Double, longitude: Double) {
        placeCityName(latitude, longitude)
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
}
