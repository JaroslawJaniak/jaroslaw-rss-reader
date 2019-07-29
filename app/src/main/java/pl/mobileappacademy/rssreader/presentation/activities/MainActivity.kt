package pl.mobileappacademy.rssreader.presentation.activities


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.presentation.fragments.navBars.BottomBar
import pl.mobileappacademy.rssreader.presentation.fragments.navBars.TopBar

class MainActivity : AppCompatActivity(), TopBar.AppTopBarListener, BottomBar.AppBottomBarListener,
    MainActivityInteractions {

    private lateinit var topBar: TopBar
    private lateinit var bottomBar: BottomBar

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
        bottomBar = findViewById(R.id.bottom_bar)
    }

    fun setListeners() {
        topBar.setTopBarListener(this)
        bottomBar.setBottomBarListener(this)
    }

    override fun getBottomBar(): BottomBar = bottomBar
    override fun getNavigationController(): NavController = Navigation.findNavController(this,
        R.id.nav_host_fragment
    )

    override fun onHomeClick() {
        Navigation.findNavController(this,
            R.id.nav_host_fragment
        ).navigate(R.id.homeFragment)
    }

    override fun onAddClick() {

    }

    override fun onSortClick() {

    }

    override fun onBackClick() {
        onBackPressed()
    }


}

