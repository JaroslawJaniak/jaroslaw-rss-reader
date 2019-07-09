package pl.mobileappacademy.rssreader


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import pl.mobileappacademy.rssreader.fragments.topBar.TopBar

class MainActivity : AppCompatActivity(), TopBar.AppTopBarListener {

    private lateinit var topBar: TopBar

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViews()
        setListeners()

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            topBar.setTopBarTitle(navController.currentDestination?.label as String)
        }

        Injector.reInit(application)
    }

    private fun findViews() {

        topBar = findViewById(R.id.top_bar)
    }

    private fun setListeners() {
        topBar.setTopBarListener(this)
    }
}

