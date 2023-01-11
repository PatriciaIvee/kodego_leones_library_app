package ph.kodego.leones.patricia.ivee.libraryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val launchActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
//            result ->
//        val data = result.data
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logIn.setOnClickListener {
            var goToLogIn = Intent(this,LoginActivity::class.java)
            launchActivity.launch(goToLogIn)
        }

        binding.register.setOnClickListener {
            var goToRegister = Intent(this,RegisterActivity::class.java)
            launchActivity.launch(goToRegister)
        }
    }
}