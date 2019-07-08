package pl.mobileappacademy.rssreader.base

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController


open class BaseFragment : Fragment() {
    var navigate: NavController? = null
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //navigate = (context as? MainActivityInteractions)?.getNavigationController()
    }

    override fun onDetach() {
        super.onDetach()
        navigate = null
    }

    fun showToast(message: String?) {
        Toast.makeText(activity, message ?: IllegalStateException().message ?: "", Toast.LENGTH_LONG).show()
    }
}