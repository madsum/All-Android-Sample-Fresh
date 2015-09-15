package com.masum.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView customListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customListView = (ListView) findViewById(R.id.customListView);
        customListView.setAdapter(new MyBaseAdapter(this));
        customListView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onArrayDapter(View view) {
        Intent intent = new Intent(this, ListViewNArrayAdapter.class);
        startActivity(intent, null);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView title = (TextView) parent.findViewById(R.id.tvTitle);
        Toast.makeText(this, title.getText() + " item: " + position, Toast.LENGTH_LONG).show();
    }

    public void onGridView(View view) {
        startActivity(new Intent(this, GrideViewWithBaseAdapter.class));

    }

    public void onSpinnerView(View view) {
        startActivity(new Intent(this, SpinnerAdapter.class));
    }
}

class SingleItem {
    String title;
    String description;
    int image;

    public SingleItem(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}

class MyBaseAdapter extends BaseAdapter {

    ArrayList<SingleItem> list;
    Context context;

    public MyBaseAdapter(Context context) {
        this.context = context;
        list = new ArrayList<SingleItem>();
        String[] title = context.getResources().getStringArray(R.array.title);
        String[] description = context.getResources().getStringArray(R.array.description);
        int[] image = {R.drawable.apple, R.drawable.lucky, R.drawable.whatsapp, R.drawable.apple, R.drawable.lucky};

        for (int i = 0; i < title.length; i++) {
            list.add(new SingleItem(title[i], description[i], image[i]));
        }

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // for simple static list this method is meaningless. But for database it means the row id.
        return position;
    }

    class MyViewHolder{

        TextView title;
        TextView description;
        ImageView image;

        public  MyViewHolder(View view){
            // now using root view we can find child views
            // only  expensive call findViewById in constructor. Then just set the view for each view.
            title = (TextView) view.findViewById(R.id.tvTitle);
            description = (TextView) view.findViewById(R.id.tvDescription);
            image = (ImageView) view.findViewById(R.id.ivIcon);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
        1. find the root view (int this case )
        2. find the child vies inside root
        3. set the values
         */

        /*
        Here is resource optimization tric. For the very fast time convertView is null.
        Once it is created it has ref to previously created view.
        */
        View row = convertView;
        MyViewHolder holder = null;
        if (row == null) {
            // If we want to find a existing view Just use findViewById. If want to create a new view we must use LayoutInflater
            // In this case we have to create new view each time for new row.
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // row contains a ref to root view LinearLayout named activity_list_single_row.xml
            row = inflater.inflate(R.layout.activity_list_single_row, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
        }else{
            holder = (MyViewHolder) row.getTag();
        }

        SingleItem temp = list.get(position);


        holder.title.setText(temp.title);
        holder.description.setText(temp.description);
        holder.image.setImageResource(temp.image);
        //TextView description = (TextView) row.findViewById(R.id.tvDescription);
        //ImageView image = (ImageView) row.findViewById(R.id.ivIcon);
        return row;
    }
}
