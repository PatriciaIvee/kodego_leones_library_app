package ph.kodego.leones.patricia.ivee.libraryapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
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

            startActivity(goToLogIn)
        }

        binding.btnRegister.setOnClickListener {
            val goToRegister = Intent(this,RegisterActivity2::class.java)
            launchActivity.launch(goToRegister)
        }

//        binding.btnRegister2.setOnClickListener {
//            val goToForgotPassword = Intent(this,ForgotPasswordActivity::class.java)
//            launchActivity.launch(goToForgotPassword)
//        }
    }
}