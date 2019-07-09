package pl.mobileappacademy.rssreader.fragments.OldFrgments

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel;
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.di.modules.AppModule
import javax.inject.Inject

class BlankFragment1ViewModel : ViewModel() {

    @Inject
    lateinit var context: Context

    init {
        Injector.component.inject(this)
    }
    fun showToast() =  Toast.makeText(context, context.resources.getString(R.string.app_name), Toast.LENGTH_SHORT).show()




}
