package com.example.task3;

import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources r = getResources();
        String[] stationsArray = r.getStringArray(R.array.stations);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                R.layout.list_item, stationsArray);
        setListAdapter(aa);
        ListView lv = getListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                CharSequence text = ((TextView) v).getText();
                int duration = Toast.LENGTH_LONG;
                Context context = getApplicationContext();
                Toast.makeText(context, text, duration).show();
            }
        });
    }
}