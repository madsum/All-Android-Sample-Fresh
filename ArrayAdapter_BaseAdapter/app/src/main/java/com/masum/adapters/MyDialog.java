package com.masum.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
        int countryFlagId;
        String countryName;

        Intent intent = getIntent();

        if (intent != null) {
            countryFlagId = intent.getIntExtra("countryFlagId", R.drawable.france);
            countryName = intent.getStringExtra("countryName");

            TextView dialogTv = (TextView) findViewById(R.id.dialogTv);
            ImageView imageView = (ImageView) findViewById(R.id.diglogImage);
            dialogTv.setText(countryName);
            imageView.setImageResource(countryFlagId);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_dialog, menu);
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

    public void onClose(View view) {
        finish();
    }
}
