package ph.kodego.leones.patricia.ivee.libraryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.ActivityRegister2Binding

class RegisterActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityRegister2Binding

    private lateinit var firstName: String
    private lateinit var lastName: String
    private lateinit var emailAddress:String
    private lateinit var password: String
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegister2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegisterAccount.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString("firstName",firstName)
//            bundle.putString("lastName",lastName)
//            bundle.putString("emailAddress",emailAddress)
//            bundle.putString("password",password)

            var goToViewPagerActivity2 = Intent(this, ViewPagerActivity2::class.java)
            startActivity(goToViewPagerActivity2)

//            name = binding.firstNameInputEditText.text.toString()
            finish()
        }

        binding.btnLogIn.setOnClickListener{
            var goToLogIn = Intent(this, LoginActivity::class.java)
            startActivity(goToLogIn)

            finish()
        }


    }
}