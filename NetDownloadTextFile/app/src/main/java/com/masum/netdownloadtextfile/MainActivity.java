package com.masum.netdownloadtextfile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity implements AsyncResponse {
    //Activity context;
    TextView txtview;
    ProgressDialog pd;
    protected void onCreate(Bundle savedInstanceState) {
        //TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //context=this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onStart(){
        super.onStart();
        BackTask bt=new BackTask();
        bt.execute("http://www.worldbestlearningcenter.com/example.txt");
    }

    @Override
    public void processFinish(String output) {
        Log.i("tag", output);
    }

    //background process to download the file from internet
    private class BackTask extends AsyncTask<String,Integer,Void>{
        String text="";
        public AsyncResponse delegate= MainActivity.this;
        protected void onPreExecute(){
            super.onPreExecute();
            //display progress dialog
            pd = new ProgressDialog(MainActivity.this);
            pd.setTitle("Reading the text file");
            pd.setMessage("Please wait.");
            pd.setCancelable(true);
            pd.setIndeterminate(false);
            pd.show();

        }

        protected Void doInBackground(String...params){
            URL url;
            try {
                //create url object to point to the file location on internet
                url = new URL(params[0]);
                //make a request to server
                HttpURLConnection con=(HttpURLConnection)url.openConnection();
                //get InputStream instance
                InputStream is=con.getInputStream();
                //create BufferedReader object
                BufferedReader br=new BufferedReader(new InputStreamReader(is));
                String line;
                //read content of the file line by line
                while((line=br.readLine())!=null){
                    text+=line;
                }
                br.close();
            }catch (Exception e) {
                e.printStackTrace();
                //close dialog if error occurs
                if(pd!=null) pd.dismiss();
            }
            return null;
        }

        protected void onPostExecute(Void result){
            //close dialog
            if(pd!=null)
                pd.dismiss();
            txtview=(TextView)findViewById(R.id.text_view);
            //display read text in TextVeiw
            txtview.setText(text);
            delegate.processFinish("this is niec");
        }
    }
}

interface AsyncResponse {
    void processFinish(String output);
}