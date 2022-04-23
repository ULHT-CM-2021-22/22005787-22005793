package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFireMapBinding


class FireMapFragment : Fragment() {

    private lateinit var binding: FragmentFireMapBinding
    private var model = FireModel
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
    ): View {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.fire_map)
        val view = inflater.inflate(R.layout.fragment_fire_map, container, false)
        binding = FragmentFireMapBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        updateDashboard()
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
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


}