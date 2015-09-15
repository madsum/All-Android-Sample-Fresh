package com.masum.adapters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewNArrayAdapter extends AppCompatActivity implements AdapterView.OnItemClickListener {

   String[] days = null;
   ListView lv = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_n_array_adapter);
        days = getResources().getStringArray(R.array.Days);
        lv = (ListView) findViewById(R.id.listView);
        // predefined layout form Android sdk Library/Android/sdk/platforms/android-22/data/res/layout/simple_list_item_1.xml
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, days);
        //Layout layout = (Layout) findViewById(R.layout.activity_list_single_row);

       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_list_single_row, days);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view_narray_adapter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tempTv = (TextView) view;

        Toast.makeText(this, tempTv.getText()+" item: "+position, Toast.LENGTH_LONG).show();

    }
}
