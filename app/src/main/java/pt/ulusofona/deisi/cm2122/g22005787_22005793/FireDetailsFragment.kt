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

            binding.textVehicles.text = model.infNotAvailable(it.meiosVeiculos.toString())
            binding.textAirSupport.text= model.infNotAvailable(it.meiosAereos.toString())
            binding.textCounty.text = model.infNotAvailable(it.concelho)
            binding.textDate.text = model.infNotAvailable(it.data)
            binding.textFireState.text = model.infNotAvailable(it.estado)
            binding.textFiremen.text = model.infNotAvailable(it.meiosOperacionais.toString())
            binding.foto.setImageURI(it.fotos)
            binding.textParish.text = model.infNotAvailable(it.freguesia)
            binding.textObs.text = model.infNotAvailable(it.obs)
            binding.textRegiao.text = model.infNotAvailable(it.distrito)
            binding.textPessoa.text = model.infNotAvailable(it.pessoa.nome)
            binding.textCc.text = model.infNotAvailable(it.pessoa.cc)
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