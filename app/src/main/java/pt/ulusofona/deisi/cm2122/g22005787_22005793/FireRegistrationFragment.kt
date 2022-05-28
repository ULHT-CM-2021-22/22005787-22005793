package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.Manifest
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.net.Uri
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
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFireRegistrationBinding
import java.text.SimpleDateFormat
import java.util.*

class FireRegistrationFragment : Fragment() {

    private lateinit var viewModel: FireViewModel
    private var districts = viewModel.onGetDistricts()
    private lateinit var binding: FragmentFireRegistrationBinding
    private val timer = object : CountDownTimer(20000, 1000) {
        override fun onTick(millisUntilFinished: Long) {}
        override fun onFinish() {
            updateDashboard()
        }
    }
    private var check = false
    private var imageURI : Uri? = null


    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK,
            MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startImageResult.launch(intent)
    }

    private val startImageResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK){
            binding.buttonFoto.text = getString(R.string.chosen)
            imageURI = result.data?.data
        }
    }

    private fun initPermissions(){
        if(!getPermission()) setPermission()
        else check = true
    }

    private fun getPermission(): Boolean =
        (ContextCompat.checkSelfPermission(
            this.requireContext(),
            Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)

    private fun setPermission(){
        val permissionsList = listOf<String>(
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        ActivityCompat.requestPermissions(this.requireActivity(), permissionsList.toTypedArray(), PERMISSION_CODE)
    }


    private fun errorPermission(){
        Toast.makeText(this.context, R.string.no_permission, Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
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
        binding = FragmentFireRegistrationBinding.bind(view)
        initPermissions()
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
        binding.buttonFoto.setOnClickListener {
            openGalleryForImage()
        }

        binding.buttonSendRegistration.setOnClickListener {
            val distrito = binding.buttonRegion.text.toString()
            val pessoa = Pessoa(
                binding.plainTextInputName.text.toString(),
                binding.plainTextInputCc.text.toString()
            )
            val sdf = SimpleDateFormat("dd/MM/yyyy - HH:mm:ss")
            val data = sdf.format(Date())
            val fotos = imageURI
            var allRight = true
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
                binding.buttonFoto.text = getString(R.string.click)
                imageURI = null
                Toast.makeText(context, getString(R.string.fields), Toast.LENGTH_SHORT).show()
            } else {
                //viewModel.onAddToHistory(fire) e
                binding.plainTextInputCc.text = null
                binding.plainTextInputName.text = null
                binding.buttonFoto.text = getString(R.string.click)
                imageURI = null
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
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
    }

    override fun onResume() {
        super.onResume()
        timer.start()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
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