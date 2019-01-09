package cubex.mahesh.intentservicetest_jan19

import android.app.IntentService
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.InputStream
import java.net.URL

class MyService : IntentService("and7am") {

    override fun onHandleIntent(p0: Intent?) {

        var u = URL("https://i.ytimg.com/vi/8zE-8tp7N8g/maxresdefault.jpg")
        var isr:InputStream = u.openStream()
        bmp = BitmapFactory.decodeStream(isr)

        var i = Intent( )
        i.setAction("nit.and7am.task_done")
     //   i.putExtra("image",bmp)  // Parcable bmp=new Bitmap( )

        sendBroadcast(i)
    }
}