package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import java.sql.*;

public class MainActivity extends AppCompatActivity {
TextView tv;
Connection c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        new mytask().execute("");

    }
    private class mytask extends AsyncTask<String,String,String>{
        String msg="";

        @Override
        protected void onPreExecute() {
            tv.setText("Please waiting to connect");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                c=DBConnect.getConnect();
                if(c!=null){
                    msg = "Connect Success";

                }else if(c==null){
                    msg="fail";

                }

            }catch (Exception ex){
                msg="Not Connect";
            }
            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            tv.setText(s);
        }
    }
}