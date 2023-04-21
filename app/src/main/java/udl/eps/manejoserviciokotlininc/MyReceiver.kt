package udl.eps.manejoserviciokotlininc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        /*val intent1 = Intent(context, ElServicio::class.java)
        val actionToDO = intent1.getStringExtra("action")
        if(actionToDO == "stopAll"){
            Toast.makeText(context, "received to stop all", Toast.LENGTH_LONG).show()
            context?.stopService(intent1)
        }else{
            context?.startService(intent1)
        }*/
        val intentService = Intent(context, ElServicio::class.java)

        if (intent != null) {
            if (intent.getIntExtra("state", 0) == 0) {
                Toast.makeText(context, "Plug on", Toast.LENGTH_LONG).show()
                context?.stopService(intentService)
            } else {
                intentService.putExtra("type", "song")
                Toast.makeText(context, "Plug", Toast.LENGTH_LONG).show()
                context?.startService(intentService)
            }
        }
    }

}