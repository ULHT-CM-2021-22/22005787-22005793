package pt.ulusofona.deisi.cm2122.g22005787_22005793

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

class FireListFragment : Fragment() {
    private lateinit var viewModel: FireViewModel
    private var adapter = FireAdapter(onClick = ::onOperationClick, onLongClick = ::onOperationLongClick)
    private lateinit var binding: FragmentFireListBinding
   private val timer = object : CountDownTimer(20000, 1000) {
        override fun onTick(millisUntilFinished: Long) {}
        override fun onFinish() {
            updateDashboard()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.fire_list)
        val view = inflater.inflate(R.layout.fragment_fire_list, container, false)
        viewModel = ViewModelProvider(this).get(FireViewModel::class.java)
        binding = FragmentFireListBinding.bind(view)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
    }

    override fun onStart() {
        super.onStart()
        updateDashboard()
        binding.fireList.layoutManager = LinearLayoutManager(context)
        binding.fireList.adapter = adapter
        viewModel.onGetHistory { updateHistory(it) }
        binding.filter.setOnClickListener {
            NavigationManager.goToFiltersFragment(parentFragmentManager)
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
        it.meiosVeiculos,it.meiosAereos,it.estado,it.data,it.fotos,it.obs,it.nomePessoa,it.ccPessoa,it.porConfirmar)}
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
        timer.start()
    }

    private fun updateDashboard() {
        viewModel.onAlterarRisco{}
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



}