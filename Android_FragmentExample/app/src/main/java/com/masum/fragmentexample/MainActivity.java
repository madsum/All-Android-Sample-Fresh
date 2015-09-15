package com.masum.fragmentexample;

/*
1. Static fragment is defined in XML file. Check activity_main.xml

2. As all fragment has it's own layout. So static fragment layout also defiend in xml. Check static_fragment_layout.xml

3. Dynamic fragment needs place holder to present it. Usually it is done by FrameLayout. Check activity_main.xml

4. Get FragmentManager then get FragmentTransaction by getFragmentManager().beginTransaction(). Check  MainActivity



 */


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentA fragmentA;
    FragmentB fragmentB;

    FragmentTransaction

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        if (savedInstanceState == null) {
            getFragmentManager()
            .beginTransaction()
                    .add(R.id.fragmentHolder, fragmentA)
                    .commit();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentHolder2, fragmentB)
                    .commit();
        }
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

    public void btnClickedFragB(View view) {
        Toast.makeText(this, "Fragment B button clicked.", Toast.LENGTH_LONG).show();
    }

    public void btnClickedFragA(View view) {
        Toast.makeText(this, "Fragment A button clicked.", Toast.LENGTH_LONG).show();
    }

    public void onFragReplaceA(View view) {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentHolder2, fragmentB)
                .commit();
    }

    public void onFragReplaceB(View view) {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentHolder, fragmentA)
                .commit();
    }

    public void onRemoveFrag(View view) {
        getFragmentManager().beginTransaction()
                .remove(fragmentA)
                .commit();
        getFragmentManager().beginTransaction()
                .remove(fragmentB)
                .commit();
    }

    public void onBtnStatic(View view) {
        Toast.makeText(this, "Static Fragment button clicked.", Toast.LENGTH_LONG).show();
    }

    public void onAddFragB(View view) {
        getFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentHolder2, fragmentB)
                .commit();
    }

    public void onAddFragA(View view) {
        getFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentHolder, fragmentA)
                .commit();
    }

}
