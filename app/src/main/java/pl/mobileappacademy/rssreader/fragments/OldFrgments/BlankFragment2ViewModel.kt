package pl.mobileappacademy.rssreader.fragments.OldFrgments

import android.content.Context
import androidx.lifecycle.ViewModel;
import pl.mobileappacademy.rssreader.Injector
import javax.inject.Inject

class BlankFragment2ViewModel : ViewModel() {

    @Inject
    lateinit var context: Context

    init {
        Injector.component.inject(this)
    }

}
