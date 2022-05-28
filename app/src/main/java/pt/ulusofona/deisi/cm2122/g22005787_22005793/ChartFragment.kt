package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import org.eazegraph.lib.models.PieModel
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentChartBinding


class ChartFragment : Fragment() {
    private lateinit var binding: FragmentChartBinding
    private lateinit var viewModel: FireViewModel
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
            getString(R.string.chart_name)
        val view = inflater.inflate(R.layout.fragment_chart, container, false)

        binding = FragmentChartBinding.bind(view)
        districtsInChart()
        binding.piechart.startAnimation()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
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

    private fun districtsInChart() {
        binding.piechart.addPieSlice(
            PieModel(
                binding.aveiro.text.toString(),
                viewModel.onFogosNaRegiao(binding.aveiro.text.toString()).toFloat(),
                resources.getColor(R.color.red)
            )
        )

        binding.aveiro.append(" (" + viewModel.onFogosNaRegiao(binding.aveiro.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.lisboa.text.toString(),
                viewModel.onFogosNaRegiao(binding.lisboa.text.toString()).toFloat(),
                resources.getColor(R.color.black)
            )
        )

        binding.lisboa.append(" (" + viewModel.onFogosNaRegiao(binding.lisboa.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.porto.text.toString(),
                viewModel.onFogosNaRegiao(binding.porto.text.toString()).toFloat(),
                resources.getColor(R.color.blue)
            )
        )

        binding.porto.append(" (" + viewModel.onFogosNaRegiao(binding.porto.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.beja.text.toString(),
                viewModel.onFogosNaRegiao(binding.beja.text.toString()).toFloat(),
                resources.getColor(R.color.colorAccent)
            )
        )

        binding.beja.append(" (" + viewModel.onFogosNaRegiao(binding.beja.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.braga.text.toString(),
                viewModel.onFogosNaRegiao(binding.braga.text.toString()).toFloat(),
                resources.getColor(R.color.green)
            )
        )

        binding.braga.append(" (" + viewModel.onFogosNaRegiao(binding.braga.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.braganca.text.toString(),
                viewModel.onFogosNaRegiao(binding.braganca.text.toString()).toFloat(),
                resources.getColor(R.color.grey)
            )
        )

        binding.braganca.append(" (" + viewModel.onFogosNaRegiao(binding.braganca.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.casteloBranco.text.toString(),
                viewModel.onFogosNaRegiao(binding.casteloBranco.text.toString()).toFloat(),
                resources.getColor(R.color.purple_200)
            )
        )

        binding.casteloBranco.append(" (" + viewModel.onFogosNaRegiao(binding.casteloBranco.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.coimbra.text.toString(),
                viewModel.onFogosNaRegiao(binding.coimbra.text.toString()).toFloat(),
                resources.getColor(R.color.real_green)
            )
        )

        binding.coimbra.append(" (" + viewModel.onFogosNaRegiao(binding.coimbra.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.evora.text.toString(),
                viewModel.onFogosNaRegiao(binding.evora.text.toString()).toFloat(),
                resources.getColor(R.color.pink)
            )
        )

        binding.evora.append(" (" + viewModel.onFogosNaRegiao(binding.evora.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.faro.text.toString(),
                viewModel.onFogosNaRegiao(binding.faro.text.toString()).toFloat(),
                resources.getColor(R.color.purple_500)
            )
        )

        binding.faro.append(" (" + viewModel.onFogosNaRegiao(binding.faro.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.guarda.text.toString(),
                viewModel.onFogosNaRegiao(binding.guarda.text.toString()).toFloat(),
                resources.getColor(R.color.purple_700)
            )
        )

        binding.guarda.append(" (" + viewModel.onFogosNaRegiao(binding.guarda.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.leiria.text.toString(),
                viewModel.onFogosNaRegiao(binding.leiria.text.toString()).toFloat(),
                resources.getColor(R.color.colorPrimary)
            )
        )

        binding.leiria.append(" (" + viewModel.onFogosNaRegiao(binding.leiria.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.portalegre.text.toString(),
                viewModel.onFogosNaRegiao(binding.portalegre.text.toString()).toFloat(),
                resources.getColor(R.color.yellow)
            )
        )

        binding.portalegre.append(" (" + viewModel.onFogosNaRegiao(binding.portalegre.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.santarem.text.toString(),
                viewModel.onFogosNaRegiao(binding.santarem.text.toString()).toFloat(),
                resources.getColor(R.color.brown)
            )
        )

        binding.santarem.append(" (" + viewModel.onFogosNaRegiao(binding.santarem.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.setubal.text.toString(),
                viewModel.onFogosNaRegiao(binding.setubal.text.toString()).toFloat(),
                resources.getColor(R.color.orange)
            )
        )

        binding.setubal.append(" (" + viewModel.onFogosNaRegiao(binding.setubal.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.vianaDoCastelo.text.toString(),
                viewModel.onFogosNaRegiao(binding.vianaDoCastelo.text.toString()).toFloat(),
                resources.getColor(R.color.orangeDark)
            )
        )

        binding.vianaDoCastelo.append(" (" + viewModel.onFogosNaRegiao(binding.vianaDoCastelo.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.vilaReal.text.toString(),
                viewModel.onFogosNaRegiao(binding.vilaReal.text.toString()).toFloat(),
                resources.getColor(R.color.teal_200)
            )
        )

        binding.vilaReal.append(" (" + viewModel.onFogosNaRegiao(binding.vilaReal.text.toString()) + ")")

        binding.piechart.addPieSlice(
            PieModel(
                binding.viseu.text.toString(),
                viewModel.onFogosNaRegiao(binding.viseu.text.toString()).toFloat(),
                resources.getColor(R.color.teal_700)
            )
        )

        binding.viseu.append(" (" + viewModel.onFogosNaRegiao(binding.viseu.text.toString()) + ")")
    }

    private fun updateDashboard() {
        viewModel.onAlterarRisco()
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
