package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.content.DialogInterface
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFireRegistrationBinding
import java.text.SimpleDateFormat
import java.util.*

class FireRegistrationFragment : Fragment() {

    private val model = FireModel
    private var fires = FireModel.list
    private var districts = FireModel.districts
    private lateinit var binding: FragmentFireRegistrationBinding
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
            getString(R.string.newRegister)
        val view = inflater.inflate(R.layout.fragment_fire_registration, container, false)
        binding = FragmentFireRegistrationBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.buttonRegion.setOnClickListener {
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(context)
            builder.setTitle(getString(R.string.choose_region))
            builder.setItems(districts, DialogInterface.OnClickListener { dialog, which ->
                binding.buttonRegion.text = districts[which]
            })
            builder.show()

        }

        binding.buttonSendRegistration.setOnClickListener {
            val distrito = binding.buttonRegion.text.toString()
            val pessoa = Pessoa(
                binding.plainTextInputName.text.toString(),
                binding.plainTextInputCc.text.toString()
            )
            val sdf = SimpleDateFormat("dd/MM/yyyy - HH:mm:ss")
            val data = sdf.format(Date())
            val fotos = ArrayList<String>()
            var allRight = true
            fotos.add(binding.plainTextInputImage.text.toString())
            val fire = FireData(pessoa, distrito, data, fotos)
            fire.estado = getString(R.string.confirm)
            if (binding.plainTextInputCc.text == null || binding.plainTextInputName.text == null
                || binding.plainTextInputCc.text.toString() == "" || binding.plainTextInputName.text.toString() == ""
                || distrito == getString(R.string.click)
            ) {
                allRight = false
            }
            if (!allRight) {
                binding.plainTextInputCc.text = null
                binding.plainTextInputName.text = null
                binding.plainTextInputImage.text = null
                Toast.makeText(context, getString(R.string.fields), Toast.LENGTH_SHORT).show()
            } else {
                model.addToHistory(fire)
                binding.plainTextInputCc.text = null
                binding.plainTextInputName.text = null
                binding.plainTextInputImage.text = null
                Toast.makeText(context, getString(R.string.register), Toast.LENGTH_SHORT).show()
            }
        }
        updateDashboard()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
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

}