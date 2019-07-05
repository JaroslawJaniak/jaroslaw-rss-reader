package pl.mobileappacademy.rssreader


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.mobileappacademy.rssreader.fragments.topBar.TopBar

class MainActivity : AppCompatActivity(), TopBar.AppTopBarListener {
    override fun onBackClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Injector.reInit(application)

        lateinit var topBar: TopBar

        fun getTopBar(): TopBar {
            return topBar
        }

        fun onBackClick() {
            onBackPressed()
        }

        fun findViews() {
            //topBar = findViewById(R.id.top_bar)
        }

        fun setListeners() {
            topBar.setTopBarListener(this)
        }



    }
}

