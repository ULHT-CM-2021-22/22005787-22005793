package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.location.Geocoder
import android.os.BatteryManager
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFireDetailsBinding
import java.util.*


private const val ARG_FIRE = "ARG_FIRE"

class FireDetailsFragment : Fragment(), OnLocationChangedListener {

    private lateinit var viewModel: FireViewModel
    private var fireData: FireData? = null
    private lateinit var binding: FragmentFireDetailsBinding
    private lateinit var geocoder: Geocoder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { fireData = it.getParcelable(ARG_FIRE) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fireData?.let { (requireActivity() as AppCompatActivity).supportActionBar?.title = it.distrito }
        val view = inflater.inflate(R.layout.fragment_fire_details, container, false)
        viewModel = ViewModelProvider(this).get(FireViewModel::class.java)
        binding = FragmentFireDetailsBinding.bind(view)
        geocoder = Geocoder(context, Locale.getDefault())
        FusedLocation.registerListener(this)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        FusedLocation.unregisterListener(this)

    }

    override fun onPause() {
        super.onPause()

    }

    override fun onStart() {
        super.onStart()
        fireData?.let {

            binding.textVehicles.text = it.meiosVeiculos ?: getString(R.string.inf_not_available)
            binding.textAirSupport.text= it.meiosAereos ?: getString(R.string.inf_not_available)
            binding.textCounty.text = it.concelho ?: getString(R.string.inf_not_available)
            binding.textDate.text = it.data ?: getString(R.string.inf_not_available)
            binding.textFireState.text = it.estado ?: getString(R.string.inf_not_available)
            binding.textFiremen.text = it.meiosOperacionais ?: getString(R.string.inf_not_available)
           // binding.foto.setImageURI(it.fotos) ?: getString(R.string.inf_not_available)
            binding.textParish.text = it.freguesia ?: getString(R.string.inf_not_available)
            binding.textObs.text = it.obs ?: getString(R.string.inf_not_available)
            binding.textRegiao.text = it.distrito ?: getString(R.string.inf_not_available)
            binding.textPessoa.text = it.nomePessoa ?: getString(R.string.inf_not_available)
            binding.textCc.text = it.ccPessoa?: getString(R.string.inf_not_available)
            val loc = "${it.latitude} / ${it.longitude}"
            binding.textLoc.text = loc
            updateDashboard()
        }
    }

    override fun onResume() {
        super.onResume()

    }

    private fun updateDashboard() {


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

    private fun backgroundColor(risk: String) {
        when (risk) {
            Risk.MAXIMUM.risco -> binding.riskLayout.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            Risk.VERYHIGH.risco -> binding.riskLayout.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            Risk.HIGH.risco -> binding.riskLayout.setBackgroundColor(resources.getColor(R.color.yellow))
            Risk.MODERATE.risco -> binding.riskLayout.setBackgroundColor(resources.getColor(R.color.green))
            Risk.REDUCED.risco -> binding.riskLayout.setBackgroundColor(resources.getColor(R.color.green))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(fireData: FireData) =
            FireDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_FIRE, fireData)
                }
            }
    }

    override fun onLocationChanged(latitude: Double, longitude: Double) {
        placeCityName(latitude, longitude)
    }
}