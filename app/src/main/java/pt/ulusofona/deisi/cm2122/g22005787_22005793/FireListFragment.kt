package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFireListBinding

class FireListFragment : Fragment() {
    private val model = FireModel
    private val fires = FireModel.list
    private var adapter = FireAdapter(onClick = ::onOperationClick, onLongClick = ::onOperationLongClick)
    private lateinit var binding: FragmentFireListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.fire_list)
        val view = inflater.inflate(R.layout.fragment_fire_list, container, false)
        binding = FragmentFireListBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.rvHistory.layoutManager = LinearLayoutManager(context)
        binding.rvHistory.adapter = adapter
        model.getHistory { updateHistory(it) }
    }

    private fun onOperationClick(fireData: FireData) {
        NavigationManager.goToFireDetailsFragment(parentFragmentManager, fireData)
    }

    private fun onOperationLongClick(fireData: FireData): Boolean {
        return false
    }

    private fun updateHistory(fireData: List<FireData>) {
        val history = fireData.map { FireData(it.distrito,it.concelho,it.freguesia,it.meiosOperacionais,
        it.meiosVeiculos,it.meiosAereos,it.estado,it.data,it.fotos,it.obs,it.pessoa,it.porConfirmar)}
        CoroutineScope(Dispatchers.Main).launch {
            showHistory(history.isNotEmpty())
            adapter.updateItems(history)
        }
    }

    private fun showHistory(show: Boolean) {
        if (show) {
            binding.rvHistory.visibility = View.VISIBLE
            binding.textNoHistoryAvailable.visibility = View.GONE
        } else {
            binding.rvHistory.visibility = View.GONE
            binding.textNoHistoryAvailable.visibility = View.VISIBLE
        }
    }



}