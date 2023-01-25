package ph.kodego.leones.patricia.ivee.libraryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firstName: String
    private lateinit var lastName: String
    private lateinit var emailAddress:String
    private lateinit var password: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegisterAccount.setOnClickListener {

            firstName = binding.firstNameInputEditText.text.toString()
            lastName = binding.lastNameInputEditText.text.toString()
            emailAddress = binding.emailInputEditText.text.toString()
            password = binding.passwordInputEditText.text.toString()

            val bundle = Bundle()
            bundle.putString("firstName",firstName)
            bundle.putString("lastName",lastName)
        }

    }
}