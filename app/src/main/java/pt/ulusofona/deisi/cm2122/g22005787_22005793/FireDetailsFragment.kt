package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFireDetailsBinding


private const val ARG_FIRE = "ARG_FIRE"

class FireDetailsFragment : Fragment() {

    private var viewM : ImageView? = null
    private var model = FireModel
    private var fireData: FireData? = null
    private lateinit var binding: FragmentFireDetailsBinding
    private val timer = object : CountDownTimer(20000, 1000) {
        override fun onTick(millisUntilFinished: Long) {}
        override fun onFinish() {
            updateDashboard()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { fireData = it.getParcelable(ARG_FIRE) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fireData?.let { (requireActivity() as AppCompatActivity).supportActionBar?.title = it.distrito }
        val view = inflater.inflate(R.layout.fragment_fire_details, container, false)
        binding = FragmentFireDetailsBinding.bind(view)
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
        fireData?.let {

            binding.textVehicles.text = it.meiosVeiculos ?: getString(R.string.inf_not_available)
            binding.textAirSupport.text= it.meiosAereos ?: getString(R.string.inf_not_available)
            binding.textCounty.text = it.concelho ?: getString(R.string.inf_not_available)
            binding.textDate.text = it.data ?: getString(R.string.inf_not_available)
            binding.textFireState.text = it.estado ?: getString(R.string.inf_not_available)
            binding.textFiremen.text = it.meiosOperacionais ?: getString(R.string.inf_not_available)
            binding.foto.setImageURI(it.fotos) ?: getString(R.string.inf_not_available)
            binding.textParish.text = it.freguesia ?: getString(R.string.inf_not_available)
            binding.textObs.text = it.obs ?: getString(R.string.inf_not_available)
            binding.textRegiao.text = it.distrito ?: getString(R.string.inf_not_available)
            binding.textPessoa.text = it.pessoa?.nome ?: getString(R.string.inf_not_available)
            binding.textCc.text = it.pessoa?.cc ?: getString(R.string.inf_not_available)
            updateDashboard()


        }
    }

    override fun onResume() {
        super.onResume()
        timer.start()
    }

    private fun updateDashboard() {
        model.alterarRisco()
        binding.riscoRegiao.text = model.risk
        backgroundColor(model.risk)


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
}