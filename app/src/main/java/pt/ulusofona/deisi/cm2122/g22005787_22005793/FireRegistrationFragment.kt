package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.content.DialogInterface
import android.os.Bundle
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
    private lateinit var binding: FragmentFireRegistrationBinding

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
            val districts = arrayOf(
                "Aveiro", "Beja", "Braga", "Bragança", "Castelo Branco", "Coimbra",
                "Évora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre",
                "Porto", "Santarém", "Setúbal", "Viana do Castelo", "Vila Real", "Viseu"
            )

            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(context)
            builder.setTitle("Escolha a região")
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
            val fire = Fire(pessoa, distrito, data, fotos)
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
                Toast.makeText(context, "Preecha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                model.addToHistory(fire)
                binding.plainTextInputCc.text = null
                binding.plainTextInputName.text = null
                binding.plainTextInputImage.text = null
                Toast.makeText(context, "Adicionado", Toast.LENGTH_SHORT).show()
            }

        }
    }

}