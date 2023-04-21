package udl.eps.manejoserviciokotlininc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val intentService = Intent(context, ElServicio::class.java)

        if (intent != null) {
            if (intent.getIntExtra("state", 0) == 0) {
                Toast.makeText(context, "Not Plugged", Toast.LENGTH_LONG).show()
                context?.stopService(intentService)
            } else {
                intentService.putExtra("type", "song")
                Toast.makeText(context, "Plugged", Toast.LENGTH_LONG).show()
                context?.startService(intentService)
            }
        }
    }

}