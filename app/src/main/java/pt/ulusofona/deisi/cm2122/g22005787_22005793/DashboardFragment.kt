package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
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
}