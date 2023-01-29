package ph.kodego.leones.patricia.ivee.libraryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding : ActivityForgotPasswordBinding
    private lateinit var emailAddress : String

    private val launchActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.send.setOnClickListener {
            emailAddress = binding.emailInputEditText.text.toString()
            Snackbar.make(binding.root,"Reset instructions was sent to $emailAddress",Snackbar.LENGTH_SHORT).show()

        }

        binding.backToLogIn.setOnClickListener{
            var goBackToMain = Intent(this,LoginActivity::class.java)
            launchActivity.launch(goBackToMain)
        }
    }
}