package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.content.DialogInterface
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentDashboardBinding
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFiltersBinding


class FiltersFragment : Fragment() {

    private lateinit var viewModel: FireViewModel
    private var adapter =
        FireAdapter(onClick = ::onOperationClick, onLongClick = ::onOperationLongClick)
    private var filtroR = false
    private var filtroD = false
    private var filtroM = false
    private var filtroE = false

    private fun onOperationLongClick(fireData: FireData): Boolean {
        return false
    }

    private fun onOperationClick(fireData: FireData) {

    }

    private var districts = arrayOf(
        "Aveiro", "Beja", "Braga", "Bragança", "Castelo Branco", "Coimbra",
        "Évora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre",
        "Porto", "Santarém", "Setúbal", "Viana do Castelo", "Vila Real", "Viseu"
    )

    private var radius = arrayOf(
        "50km", "150km", "300km"
    )

    private var meios = arrayOf(
        "Operacionais", "Meios Terrestres", "Meios Aereos"
    )

    private var estado = arrayOf(
        "A decorrer", "Concluído"
    )

    private lateinit var binding: FragmentFiltersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.app_name)
        val view = inflater.inflate(R.layout.fragment_filters, container, false)
        viewModel = ViewModelProvider(this).get(FireViewModel::class.java)
        binding = FragmentFiltersBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.buttonRegionFilter.setOnClickListener {
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(context)
            builder.setTitle(getString(R.string.choose_region))
            builder.setItems(districts, DialogInterface.OnClickListener { dialog, which ->
                binding.buttonRegionFilter.text = districts[which]
                filtroD = true
            })
            builder.show()
        }

        binding.buttonRadiusFilter.setOnClickListener {
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(context)
            builder.setTitle(getString(R.string.raio))
            builder.setItems(radius, DialogInterface.OnClickListener { dialog, which ->
                binding.buttonRadiusFilter.text = radius[which]
                filtroR = true
            })
            builder.show()
        }

        binding.buttonMeiosFilter.setOnClickListener {
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(context)
            builder.setTitle(getString(R.string.meios_operacionais))
            builder.setItems(meios, DialogInterface.OnClickListener { dialog, which ->
                binding.buttonMeiosFilter.text = meios[which]
                filtroM = true
            })
            builder.show()
        }

        binding.buttonEstadoFogoFilter.setOnClickListener {
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(context)
            builder.setTitle(getString(R.string.estado_fogo))
            builder.setItems(estado, DialogInterface.OnClickListener { dialog, which ->
                binding.buttonEstadoFogoFilter.text = estado[which]
                filtroE = true
            })
            builder.show()
        }

        binding.buttonSubmit.setOnClickListener {
            if (filtroM) {
                when (binding.buttonMeiosFilter.text.toString()) {
                    "Operacionais" -> {
                        viewModel.meiosOperacionais { updateHistory(it) }
                    }
                    "Meios Terrestres" -> {
                        viewModel.meiosTerrestres { updateHistory(it) }
                    }
                    "Meios Aereos" -> {
                        viewModel.meiosAereos { updateHistory(it) }
                    }
                }
                filtroM = false
            }
            if (filtroD) {
                viewModel.getOnFogosNaRegiao(
                    { updateHistory(it) },
                    binding.buttonRegionFilter.text.toString()
                )
                filtroD = false
            }
            binding.buttonRegionFilter.text = getString(R.string.click)
            binding.buttonRadiusFilter.text = getString(R.string.click)
            binding.buttonMeiosFilter.text = getString(R.string.click)
            binding.buttonEstadoFogoFilter.text = getString(R.string.click)
            Toast.makeText(context, "Filtros aplicados", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()
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


}