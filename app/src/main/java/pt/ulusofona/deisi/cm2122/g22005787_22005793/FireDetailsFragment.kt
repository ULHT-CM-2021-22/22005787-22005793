package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFireDetailsBinding


private const val ARG_FIRE = "ARG_FIRE"

class FireDetailsFragment : Fragment() {
    private var fire: Fire? = null
    private lateinit var binding: FragmentFireDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { fire = it.getParcelable(ARG_FIRE) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fire?.let { (requireActivity() as AppCompatActivity).supportActionBar?.title = it.distrito }
        val view = inflater.inflate(R.layout.fragment_fire_details, container, false)
        binding = FragmentFireDetailsBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        fire?.let {

            binding.textVehicles.text = infNotAvailable(it.meiosVeiculos.toString())
            binding.textAirSupport.text= infNotAvailable(it.meiosAereos.toString())
            binding.textCounty.text = infNotAvailable(it.concelho)
            binding.textDate.text = infNotAvailable(it.data)
            binding.textFireState.text = infNotAvailable(it.estado)
            binding.textFiremen.text = infNotAvailable(it.meiosOperacionais.toString())
            binding.textFoto.text = infNotAvailable(it.fotos.toString())
            binding.textParish.text = infNotAvailable(it.freguesia)
            binding.textObs.text = infNotAvailable(it.obs)
            binding.textRegiao.text = infNotAvailable(it.distrito)
            binding.textPessoa.text = infNotAvailable(it.pessoa.nome)
            binding.textCc.text = infNotAvailable(it.pessoa.cc)


        }
    }

    private fun infNotAvailable(view : String):String{
        if (view == "" || view == "0"){
            return getString(R.string.inf_not_available)
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(fire: Fire) =
            FireDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_FIRE, fire)
                }
            }
    }
}