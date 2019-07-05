package pl.mobileappacademy.rssreader.fragments.adapters

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent
import android.widget.BaseAdapter;
import android.widget.ImageView
import android.widget.TextView;
import pl.mobileappacademy.rssreader.models.Portal
//import java.awt.print.Book
//import java.awt.print.Book







public class GrideViewTest: BaseAdapter() {


    //internal var feedIcons: Array<Int>? = null

    internal var feedIcons = arrayOfNulls<Int>(8)
    //internal var imageView: ImageView? = null

    private var mContext: Context? = null
    private var portals: Array<Portal>? = null

    fun MainPageAdapter(context: Context, portals: Array<Portal>) {
        this.mContext = context
        this.portals = portals
    }


    override fun getItemId(p0: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return portals!!.size
    }

    override fun getItem(p0: Int): Any? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return null;
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        val textView = TextView(mContext)
        textView.setText("some text...")

        return textView
    }






    //private final Book[] books;

//  // 1
//  public BooksAdapter(Context context, Book[] books) {
//    this.mContext = context;
//    this.books = books;
//  }
//
//  // 2
//  @Override
//  public int getCount() {
//    return books.length;
//  }
//
//  // 3
//  @Override
//  public long getItemId(int position) {
//    return 0;
//  }
//
//  // 4
//  @Override
//  public Object getItem(int position) {
//    return null;
//  }
//

//  @Override
//  public View getView(int position, View convertView, ViewGroup parent) {
//    TextView dummyTextView = new TextView(mContext);
//    dummyTextView.setText(String.valueOf(position));
//    return dummyTextView;
//  }

}
