package ph.kodego.leones.patricia.ivee.libraryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var emailAddress: String
    private lateinit var password : String

    private val launchActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.forgotPasswordTextView.setOnClickListener{
            var goToForgotPassword = Intent(this, ForgotPasswordActivity::class.java)
            launchActivity.launch(goToForgotPassword)

        }

        binding.logIn.setOnClickListener {
            emailAddress = binding.emailInputEditText.text.toString()
            password = binding.passwordInputEditText.text.toString()

            var goToViewPagerActivity2 = Intent(this, ViewPagerActivity2::class.java)

            val bundle = Bundle()
            bundle.putString("emailAddress",emailAddress)
            bundle.putString("password", password)
            goToViewPagerActivity2.putExtras(bundle)

            launchActivity.launch(goToViewPagerActivity2)
            finish()
        }




    }

}