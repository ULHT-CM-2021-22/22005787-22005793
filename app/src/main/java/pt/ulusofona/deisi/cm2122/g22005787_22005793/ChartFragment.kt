package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import org.eazegraph.lib.models.PieModel
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentChartBinding
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentDashboardBinding


class ChartFragment : Fragment() {
private lateinit var binding: FragmentChartBinding
private var districts = FireModel.districts
private var model = FireModel

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
        val timer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                updateDashboard()
            }
        }
        timer.start()
    }

    private fun districtsInChart(){
        binding.piechart.addPieSlice(PieModel(binding.aveiro.text.toString(),
            model.fogosNaRegiao(binding.aveiro.text.toString()).toFloat(),
            resources.getColor(R.color.red)))

        binding.piechart.addPieSlice(PieModel(binding.lisboa.text.toString(),
            model.fogosNaRegiao(binding.lisboa.text.toString()).toFloat(),
            resources.getColor(R.color.black)))

        binding.piechart.addPieSlice(PieModel(binding.porto.text.toString(),
            model.fogosNaRegiao(binding.porto.text.toString()).toFloat(),
            resources.getColor(R.color.blue)))

        binding.piechart.addPieSlice(PieModel(binding.beja.text.toString(),
            model.fogosNaRegiao(binding.beja.text.toString()).toFloat(),
            resources.getColor(R.color.colorAccent)))

        binding.piechart.addPieSlice(PieModel(binding.braga.text.toString(),
            model.fogosNaRegiao(binding.braga.text.toString()).toFloat(),
            resources.getColor(R.color.green)))

        binding.piechart.addPieSlice(PieModel(binding.braganca.text.toString(),
            model.fogosNaRegiao(binding.braganca.text.toString()).toFloat(),
            resources.getColor(R.color.grey)))

        binding.piechart.addPieSlice(PieModel(binding.casteloBranco.text.toString(),
            model.fogosNaRegiao(binding.casteloBranco.text.toString()).toFloat(),
            resources.getColor(R.color.purple_200)))

        binding.piechart.addPieSlice(PieModel(binding.coimbra.text.toString(),
            model.fogosNaRegiao(binding.coimbra.text.toString()).toFloat(),
            resources.getColor(R.color.real_green)))

        binding.piechart.addPieSlice(PieModel(binding.evora.text.toString(),
            model.fogosNaRegiao(binding.evora.text.toString()).toFloat(),
            resources.getColor(R.color.pink)))

        binding.piechart.addPieSlice(PieModel(binding.faro.text.toString(),
            model.fogosNaRegiao(binding.faro.text.toString()).toFloat(),
            resources.getColor(R.color.purple_500)))

        binding.piechart.addPieSlice(PieModel(binding.guarda.text.toString(),
            model.fogosNaRegiao(binding.guarda.text.toString()).toFloat(),
            resources.getColor(R.color.purple_700)))

        binding.piechart.addPieSlice(PieModel(binding.leiria.text.toString(),
            model.fogosNaRegiao(binding.leiria.text.toString()).toFloat(),
            resources.getColor(R.color.colorPrimary)))

        binding.piechart.addPieSlice(PieModel(binding.portalegre.text.toString(),
            model.fogosNaRegiao(binding.portalegre.text.toString()).toFloat(),
            resources.getColor(R.color.yellow)))

        binding.piechart.addPieSlice(PieModel(binding.santarem.text.toString(),
            model.fogosNaRegiao(binding.santarem.text.toString()).toFloat(),
            resources.getColor(R.color.brown)))

        binding.piechart.addPieSlice(PieModel(binding.setubal.text.toString(),
            model.fogosNaRegiao(binding.setubal.text.toString()).toFloat(),
            resources.getColor(R.color.orange)))

        binding.piechart.addPieSlice(PieModel(binding.vianaDoCastelo.text.toString(),
            model.fogosNaRegiao(binding.vianaDoCastelo.text.toString()).toFloat(),
            resources.getColor(R.color.orangeDark)))

        binding.piechart.addPieSlice(PieModel(binding.vilaReal.text.toString(),
            model.fogosNaRegiao(binding.vilaReal.text.toString()).toFloat(),
            resources.getColor(R.color.teal_200)))

        binding.piechart.addPieSlice(PieModel(binding.viseu.text.toString(),
            model.fogosNaRegiao(binding.viseu.text.toString()).toFloat(),
            resources.getColor(R.color.teal_700)))
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
