package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.Manifest
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.location.Geocoder
import android.net.Uri
import android.os.BatteryManager
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFireRegistrationBinding
import java.text.SimpleDateFormat
import java.util.*

class FireRegistrationFragment : Fragment(), OnLocationChangedListener {

    private lateinit var viewModel: FireViewModel
    private var districts = arrayOf(
        "Aveiro", "Beja", "Braga", "Bragança", "Castelo Branco", "Coimbra",
        "Évora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre",
        "Porto", "Santarém", "Setúbal", "Viana do Castelo", "Vila Real", "Viseu"
    )
    private lateinit var binding: FragmentFireRegistrationBinding
    var lat: Double = 0.0
    var lng: Double = 0.0
    private lateinit var geocoder: Geocoder
    private var adapter =
        FireAdapter(onClick = ::onOperationClick, onLongClick = ::onOperationLongClick)
    private var check = false
    private var imageURI: Uri? = null

    private fun onOperationClick(fire: FireData) {

    }

    private fun onOperationLongClick(fire: FireData): Boolean {
        return false
    }

    private fun openGalleryForImage() {
        val intent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.INTERNAL_CONTENT_URI
        )
        startImageResult.launch(intent)
    }

    private val startImageResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            binding.buttonFoto.text = getString(R.string.chosen)
            imageURI = result.data?.data
        }
    }

    private fun initPermissions() {
        if (!getPermission()) setPermission()
        else check = true
    }

    private fun getPermission(): Boolean =
        (ContextCompat.checkSelfPermission(
            this.requireContext(),
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED)

    private fun setPermission() {
        val permissionsList = listOf<String>(
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        ActivityCompat.requestPermissions(
            this.requireActivity(),
            permissionsList.toTypedArray(),
            PERMISSION_CODE
        )
    }


    private fun errorPermission() {
        Toast.makeText(this.context, R.string.no_permission, Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    errorPermission()
                } else {
                    check = true
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    companion object {
        private const val PERMISSION_CODE = 1
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.newRegister)
        val view = inflater.inflate(R.layout.fragment_fire_registration, container, false)
        viewModel = ViewModelProvider(this).get(FireViewModel::class.java)
        FusedLocation.registerListener(this)
        geocoder = Geocoder(context, Locale.getDefault())
        binding = FragmentFireRegistrationBinding.bind(view)
        initPermissions()
        return binding.root

    }

    override fun onLocationChanged(latitude: Double, longitude: Double) {
        lat = latitude
        lng = longitude
        placeCityName(latitude, longitude)
    }

    override fun onStart() {
        super.onStart()
        binding.buttonFoto.setOnClickListener {
            openGalleryForImage()
        }

        binding.buttonSendRegistration.setOnClickListener {
            val distrito = binding.textRegion.text.toString()
            val nomePessoa = binding.plainTextInputName.text.toString()
            val ccPessoa = binding.plainTextInputCc.text.toString()
            val sdf = SimpleDateFormat("dd/MM/yyyy - HH:mm:ss")
            val data = sdf.format(Date())
            val fotos = null
            var allRight = true
            val fire = FireData(nomePessoa, ccPessoa, distrito, data, fotos)
            val fireRoom = FireRoom(
                UUID.randomUUID().toString(),
                distrito,
                null,
                null,
                null,
                null,
                null,
                getString(R.string.confirm),
                data,
                fotos,
                null,
                nomePessoa,
                ccPessoa,
                true,
                lat,
                lng
            )
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
                binding.buttonFoto.text = getString(R.string.click)
                imageURI = null
                Toast.makeText(context, getString(R.string.fields), Toast.LENGTH_SHORT).show()
            } else {
                viewModel.onAddToHistory({
                    CoroutineScope(Dispatchers.Main).launch {
                        viewModel.onGetHistory { updateHistory(it) }
                    }
                }, fireRoom)

                binding.plainTextInputCc.text = null
                binding.plainTextInputName.text = null
                binding.buttonFoto.text = getString(R.string.click)
                imageURI = null
                Toast.makeText(context, getString(R.string.register), Toast.LENGTH_SHORT).show()
            }
        }
        updateDashboard()
        val bm = requireActivity().applicationContext.getSystemService(AppCompatActivity.BATTERY_SERVICE) as BatteryManager
        val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        if (batLevel <= 20) {
            binding.riskLayout.setBackgroundColor(resources.getColor(R.color.grey))
        } else {
            backgroundColor(binding.riscoRegiao.text.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        FusedLocation.unregisterListener(this)
    }

    override fun onPause() {
        super.onPause()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
    }

    override fun onResume() {
        super.onResume()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val bm = requireActivity().applicationContext.getSystemService(AppCompatActivity.BATTERY_SERVICE) as BatteryManager
        val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        if (batLevel <= 20) {
            binding.riskLayout.setBackgroundColor(resources.getColor(R.color.grey))
        } else {
            backgroundColor(binding.riscoRegiao.text.toString())
        }
    }


    private fun updateDashboard() {
    }

    private fun updateHistory(fires: List<FireData>) {
        val history = fires.map {
            FireData(
                it.distrito,
                it.concelho,
                it.freguesia,
                it.meiosOperacionais,
                it.meiosVeiculos,
                it.meiosAereos,
                it.estado,
                it.data,
                it.fotos,
                it.obs,
                it.nomePessoa,
                it.ccPessoa,
                it.porConfirmar,
                it.latitude,
                it.longitude
            )
        }
        CoroutineScope(Dispatchers.Main).launch {
            adapter.updateItems(history)
        }
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


    private fun placeCityName(latitude: Double, longitude: Double) {
        val addresses = geocoder.getFromLocation(latitude, longitude, 5)
        val location = addresses.first { it.locality != null && it.locality.isNotEmpty() }
        viewModel.onAlterarRegiao({},location.adminArea)
        binding.textRegion.text = location.adminArea
        viewModel.onGetRisk(location.adminArea) {
            binding.riscoRegiao.text = it
        }
        val bm = requireActivity().applicationContext.getSystemService(AppCompatActivity.BATTERY_SERVICE) as BatteryManager
        val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        if (batLevel <= 20) {
            binding.riskLayout.setBackgroundColor(resources.getColor(R.color.grey))
        } else {
            backgroundColor(binding.riscoRegiao.text.toString())
        }
    }


}