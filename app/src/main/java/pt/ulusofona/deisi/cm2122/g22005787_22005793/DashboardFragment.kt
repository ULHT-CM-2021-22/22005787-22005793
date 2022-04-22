package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.app_name)
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        binding = FragmentDashboardBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.buttonRegion.setOnClickListener {
            val colors = arrayOf("Aveiro", "Beja", "Braga", "Bragança","Castelo Branco","Coimbra",
                "Évora","Faro","Guarda","Leiria","Lisboa","Portalegre",
                "Porto","Santarém","Setúbal","Viana do Castelo", "Vila Real","Viseu")

            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(context)
            builder.setTitle("Escolha a região")
            builder.setItems(colors, DialogInterface.OnClickListener { dialog, which ->
                binding.textRegion.text = colors[which]
            })
            builder.show()

        }
    }


}