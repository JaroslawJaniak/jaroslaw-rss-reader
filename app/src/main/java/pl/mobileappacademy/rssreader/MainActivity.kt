package pl.mobileappacademy.rssreader


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import pl.mobileappacademy.rssreader.appDatabase.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.appDatabase.PortalDao
import pl.mobileappacademy.rssreader.fragments.HomeFragments.HomeViewModel
import pl.mobileappacademy.rssreader.fragments.topBar.TopBar
import pl.mobileappacademy.rssreader.models.HomeItem
import java.util.*

class MainActivity : AppCompatActivity(), TopBar.AppTopBarListener {

    private lateinit var topBar: TopBar
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViews()
        setListeners()

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            topBar.setTopBarTitle(navController.currentDestination?.label as String)
        }


        Toast.makeText(application, navController.currentDestination?.label as String, Toast.LENGTH_LONG).show()

        Injector.reInit(application)
    }

    private fun findViews() {

        topBar = findViewById(R.id.top_bar)
    }

    private fun setListeners() {
        topBar.setTopBarListener(this)
    }
}

