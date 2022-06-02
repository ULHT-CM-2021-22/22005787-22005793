package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.content.DialogInterface
import android.content.pm.ActivityInfo
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


class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding
    private lateinit var viewModel: FireViewModel
    private var adapter =
        FireAdapter(onClick = ::onOperationClick, onLongClick = ::onOperationLongClick)
    private var districts = arrayOf(
        "Aveiro", "Beja", "Braga", "Bragança", "Castelo Branco", "Coimbra",
        "Évora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre",
        "Porto", "Santarém", "Setúbal", "Viana do Castelo", "Vila Real", "Viseu"
    )
    private var actualDistrict = "Lisboa"
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
        viewModel = ViewModelProvider(this).get(FireViewModel::class.java)
        binding = FragmentDashboardBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.buttonRegion.setOnClickListener {
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(context)
            builder.setTitle(getString(R.string.choose_region))
            builder.setItems(districts, DialogInterface.OnClickListener { dialog, which ->
                viewModel.onAlterarRegiao({}, districts[which])
                binding.textRegion.text = districts[which]
                binding.textRegion.textSize = 18F
                actualDistrict = districts[which]
                updateDashboard()
            })
            builder.show()
        }
        updateDashboard()
    }

    override fun onResume() {
        super.onResume()
        timer.start()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
    }

    private fun updateDashboard() {
        binding.textRegion.text = actualDistrict
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

        viewModel.onAlterarRisco {}
        binding.riscoRegiao.text = viewModel.onGetRisk()
        backgroundColor(viewModel.onGetRisk())
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


}