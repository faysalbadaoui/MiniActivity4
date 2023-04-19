package udl.eps.manejoserviciokotlininc

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class ElServicio: Service() {

    private var player: MediaPlayer? = null
    private var playerS: MediaPlayer? = null
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "Service created", Toast.LENGTH_LONG).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        val type = intent!!.getStringExtra("type")
        if (type == "train") {
            player = MediaPlayer.create(applicationContext, R.raw.train)
            player!!.isLooping = true
            Toast.makeText(this, R.string.creaserv, Toast.LENGTH_LONG).show()
            player!!.start()
        } else if (type == "song") {
            playerS = MediaPlayer.create(applicationContext, R.raw.song)
            playerS!!.isLooping = true
            Toast.makeText(this, R.string.creaserv, Toast.LENGTH_LONG).show()
            playerS!!.start()
        }
        return startId
    }

    override fun onDestroy() {
        super.onDestroy()
        if (player!!.isPlaying) {
            player!!.stop()
        }
        if (playerS!!.isPlaying) {
            playerS!!.stop()
        }
        Toast.makeText(this, R.string.finaserv, Toast.LENGTH_LONG).show()

    }
}