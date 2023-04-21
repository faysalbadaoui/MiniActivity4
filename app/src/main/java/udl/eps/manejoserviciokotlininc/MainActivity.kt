package udl.eps.manejoserviciokotlininc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import udl.eps.manejoserviciokotlininc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIn.setOnClickListener(this)
        binding.btnFin.setOnClickListener(this)
        binding.btnInC.setOnClickListener(this)

    }

    override fun onClick(src: View) {
        val intent = Intent(this, MyReceiver::class.java)

        when(src.id) {
            R.id.btnIn -> {
                intent.putExtra("type", "train")
                Toast.makeText(this, "Sound start clicked!", Toast.LENGTH_LONG).show()
            }
            R.id.btnInC -> {
                intent.putExtra("type", "song")
            }
        }
        sendBroadcast(intent)
    }
}