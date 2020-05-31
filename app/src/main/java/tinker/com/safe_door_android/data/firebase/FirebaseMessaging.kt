package tinker.com.safe_door_android.data.firebase
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessaging : FirebaseMessagingService(){

    var broadcaster: LocalBroadcastManager? = null

    override fun onCreate() {
        super.onCreate()
        broadcaster = LocalBroadcastManager.getInstance(this)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        println("From: " + remoteMessage!!.from)
        println("Notification Message Body: " + remoteMessage.data)

        var intent = Intent("FCM")
        intent.putExtra("SettingsStatus", 1)

        broadcaster?.sendBroadcast(intent)
    }
}