package net.helpgod.ta.listview;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.helpgod.ta.R;

import java.util.ArrayList;

import static android.support.v7.widget.PopupMenu.OnMenuItemClickListener;

/**
 * Created by najunhee on 2015-12-26.
 */
public class ListAdapter extends BaseAdapter {

    private ArrayList<String> mainList;
    private Context mContext;


    public ListAdapter(Context applicationContext,
                       ArrayList<String> questionForSliderMenu) {

        super();
        this.mContext = applicationContext;
        this.mainList = questionForSliderMenu;

    }

//    public ListAdapter() {
//
//        super();
//        this.mainList = QuestionForSliderMenu;
//
//    }

    @Override
    public int getCount() {

        return mainList.size();
    }

    @Override
    public Object getItem(int position) {

        return mainList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_row_stack, null);
        }

        TextView tv1 = (TextView) convertView.findViewById(R.id.row_textView1);
        TextView tv2 = (TextView) convertView.findViewById(R.id.row_install_textView1);
        ImageView imageIcon = (ImageView) convertView.findViewById(R.id.row_imageView1);
        ImageView imageClick = (ImageView) convertView.findViewById(R.id.row_click_imageView1);

        try {

            tv1.setText(" List Item " + " : " + position);
            imageClick.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    switch (v.getId()) {
                        case R.id.row_click_imageView1:

                            PopupMenu popup = new PopupMenu(mContext, v);
                            popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                            popup.show();
                            popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem item) {

                                    switch (item.getItemId()) {
                                        case R.id.install:

                                            //Or Some other code you want to put here.. This is just an example.
                                            Toast.makeText(mContext, " Install Clicked at position " + " : " + position, Toast.LENGTH_LONG).show();

                                            break;
                                        case R.id.addtowishlist:

                                            Toast.makeText(mContext, "Add to Wish List Clicked at position " + " : " + position, Toast.LENGTH_LONG).show();

                                            break;

                                        default:
                                            break;
                                    }

                                    return true;
                                }
                            });

                            break;

                        default:
                            break;
                    }


                }
            });

        } catch (Exception e) {

            e.printStackTrace();
        }

        return convertView;
    }

}
