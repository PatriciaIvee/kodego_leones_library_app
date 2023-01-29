package ph.kodego.leones.patricia.ivee.libraryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.ActivityLoginBinding
import ph.kodego.leones.patricia.ivee.libraryapp.fragments.librarylist.LibraryListFragment

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var userNameBundle: String
    private lateinit var passwordBundle : String

    private val launchActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.forgotPasswordText.setOnClickListener{
            var goToForgotPassword = Intent(this, ForgotPasswordActivity::class.java)
            launchActivity.launch(goToForgotPassword)

        }

        binding.logIn.setOnClickListener {
            userNameBundle = binding.userNameInputEditText.text.toString()
            passwordBundle = binding.passwordInputEditText.text.toString()

            var goToViewPagerActivity2 = Intent(this, ViewPagerActivity2::class.java)
            var fragmentLibrary = LibraryListFragment()

            var bundle = Bundle()

            bundle.putString("userNameBundle", userNameBundle.toString())
            bundle.putString("passwordBundle", passwordBundle)

            goToViewPagerActivity2.putExtras(bundle)
            launchActivity.launch(goToViewPagerActivity2)
            finish()
        }



    }

    fun onClick(view: View) {

        var goToForgotPassword = Intent(this, ForgotPasswordActivity::class.java)
        launchActivity.launch(goToForgotPassword)

    }

}