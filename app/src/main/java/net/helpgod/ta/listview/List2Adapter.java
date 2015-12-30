package net.helpgod.ta.listview;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListPopupWindow;
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
public class List2Adapter extends BaseAdapter {

    private ArrayList<String> mainList;
    private Context mContext;

    private Integer[] imgs = new Integer[]{0, 1, 2, 3, 4, 5};
    private ListPopupWindow mListPopupWindow;

    public List2Adapter(Context applicationContext,
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

        ViewHolder holder;

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_row_stack, null);

            holder = new ViewHolder();

            holder.tv1 = (TextView) convertView.findViewById(R.id.row_textView1);
            holder.tv2 = (TextView) convertView.findViewById(R.id.row_install_textView1);
            holder.imageIcon = (ImageView) convertView.findViewById(R.id.row_imageView1);
            holder.imageClick = (ImageView) convertView.findViewById(R.id.row_click_imageView1);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        try {

            holder.tv1.setText(" List Item " + " : " + position);
            holder.imageClick.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if(mListPopupWindow.isShowing() == true) {
                        mListPopupWindow.dismiss();
                    } else {
                        mListPopupWindow.show();
                    }

                }
            });

        } catch (Exception e) {

            e.printStackTrace();
        }

        mListPopupWindow = new ListPopupWindow(mContext);
        mListPopupWindow.setWidth(400);
        mListPopupWindow.setHeight(450);
        mListPopupWindow.setAnchorView(holder.imageClick);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(mContext, android.R.layout.simple_list_item_1, imgs);
        mListPopupWindow.setAdapter(adapter);

        mListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (true) {
                    android.util.Log.v("CLICK", "Click Position : " + position);

                    if (mListPopupWindow.isShowing() == true) {
                        mListPopupWindow.dismiss();
                    }
                }
            }
        });

        return convertView;
    }

    public static class ViewHolder{

        TextView tv1;
        TextView tv2;
        ImageView imageIcon;
        ImageView imageClick;
    }

}
