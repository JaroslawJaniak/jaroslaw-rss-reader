package pl.mobileappacademy.rssreader.fragments.adapters

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView
import android.widget.TextView;



public class MainPageAdapter: BaseAdapter() {


    //internal var feedIcons: Array<Int>? = null

    internal var feedIcons = arrayOfNulls<Int>(8)
    internal var imageView: ImageView? = null
    //private val mContext: Context? = null



    override fun getItemId(p0: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(p0: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        //val textView = TextView(mContext)
        //textView.setText(String.valueOf(p0))

        //return textView
    }

    private val  mContext: Context? = null




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
