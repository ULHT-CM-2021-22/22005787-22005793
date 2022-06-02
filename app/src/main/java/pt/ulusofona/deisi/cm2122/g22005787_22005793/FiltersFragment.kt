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

    val repository = FireRepository.getInstance()

    private var districts = arrayOf(
        "Aveiro", "Beja", "Braga", "Bragança", "Castelo Branco", "Coimbra",
        "Évora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre",
        "Porto", "Santarém", "Setúbal", "Viana do Castelo", "Vila Real", "Viseu"
    )

    private var radius = arrayOf(
        "50km", "150km", "300km"
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
            })
            builder.show()
        }

        binding.buttonRadiusFilter.setOnClickListener {
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(context)
            builder.setTitle(getString(R.string.raio))
            builder.setItems(radius, DialogInterface.OnClickListener { dialog, which ->
                binding.buttonRadiusFilter.text = radius[which]
            })
            builder.show()
        }

        binding.checkboxOperacionais.setOnClickListener {

        }

        binding.buttonSubmit.setOnClickListener {
            binding.buttonRegionFilter.text = getString(R.string.click)
            binding.buttonRadiusFilter.text = getString(R.string.click)
            Toast.makeText(context, "Filtros aplicados", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onPause() {
        super.onPause()
    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_operacionais -> {
                    if (checked) {

                    } else {
                        // Remove the meat
                    }
                }
                R.id.checkbox_opTerrestres -> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }
            }
        }

    }


    fun onOperationClick(fireData: FireData) {

    }

    private fun onOperationLongClick(fireData: FireData): Boolean {
        return false
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