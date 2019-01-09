package cubex.mahesh.intentservicetest_jan19

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

var bmp:Bitmap? = null

class MainActivity : AppCompatActivity() {

    var mReceiver:MyReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mReceiver = MyReceiver(iview)

        getImage.setOnClickListener {

                    var filter = IntentFilter()
                    filter.addAction("nit.and7am.task_done")
                    registerReceiver(mReceiver,filter)

                    var i = Intent(this@MainActivity,
                                                    MyService::class.java)
                    startService(i)
        }
    }

    class MyReceiver(val iView:ImageView) : BroadcastReceiver( )
    {
        override fun onReceive(p0: Context?, p1: Intent?) {
  //   var bmp = p1?.getParcelableExtra<Bitmap>("image")
     iView.setImageBitmap(bmp)
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(mReceiver)
    }

} //MainActivity
