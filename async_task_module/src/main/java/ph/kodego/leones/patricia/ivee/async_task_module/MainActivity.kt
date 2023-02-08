package ph.kodego.leones.patricia.ivee.async_task_module

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import ph.kodego.leones.patricia.ivee.async_task_module.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var drawingBoard:TouchEventView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private val pictureChosen = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if(result.resultCode == Activity.RESULT_CANCELED){
            toast("Cancelled choosing Image")
        }else{
            val data = result.data
            if(data == null){
                toast("No Image was chosen")
            }else{
                val imageFileUri = result.data!!.data!!
                drawingBoard.loadImage(imageFileUri)
                Log.i("FILE", "URI : ${imageFileUri}")
            }
        }
    }
}