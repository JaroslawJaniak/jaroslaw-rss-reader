package pl.mobileappacademy.rssreader.presentation.activities.base.dialogs

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.channel_fragment.view.*
import kotlinx.android.synthetic.main.dialog_filter_spinner.*
import kotlinx.android.synthetic.main.dialog_filter_spinner.view.*

import pl.mobileappacademy.rssreader.R

class DialogFilterFragment : DialogFragment(), AdapterView.OnItemSelectedListener {

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    private lateinit var viewModel: DialogFilterViewModel
    private lateinit var dialogInterface: DialogInterface
    lateinit var mCategory: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_filter_spinner, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DialogFilterViewModel::class.java)



        var list_of_items = arrayOf("Polska", "Świat", "Najnowsze")
        val spinner = spinner_filter
        val spinnerArrayAdapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, list_of_items)

        //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerArrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                mCategory = selectedItem

                if (selectedItem == "Add new category") {
                    // do your stuff
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }










        val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_filter_spinner, null)

        add_dialog_OkBtn.setOnClickListener{
            dialogInterface.categorySelected(mCategory)
            this.dismiss()
        }

        add_dialog_CancelBtn.setOnClickListener{
            this.dismiss()
        }

    }

    fun setInterface(dialogInterface: DialogInterface){
        this.dialogInterface = dialogInterface
    }

    interface DialogInterface {
        fun categorySelected(category: String)
    }

}
