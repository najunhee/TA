package net.helpgod.ta.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import net.helpgod.ta.R;

import java.util.ArrayList;

/**
 * Created by najunhee on 2015-12-26.
 */
public class ListViewActivity extends Activity {

    String[] numbers = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King"};
    ArrayList<String> QuestionForSliderMenu = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);

        ListView listView = (ListView) findViewById(R.id.listView);


        for (String s : numbers) {

            QuestionForSliderMenu.add(s);

        }

        List2Adapter mAdapter = new List2Adapter(this, QuestionForSliderMenu);

        listView.setAdapter(mAdapter);


    }
}
