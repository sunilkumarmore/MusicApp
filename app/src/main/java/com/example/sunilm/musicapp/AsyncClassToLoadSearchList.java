package com.example.sunilm.musicapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by sunilm on 2/5/2018.
 */

public class AsyncClassToLoadSearchList extends AsyncTask<String,Integer,ArrayList<MusicResults>> {
    final static int RESULT_OKmusic = 0x00;
    public AsyncClassToLoadSearchList(Handler handler) {
        this.handler = handler;
    }

    Handler handler;

    @Override
    protected ArrayList<MusicResults> doInBackground(String... params) {

        try {
            URL url = new URL(params[0]);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
           InputStream in =  con.getInputStream();
int statusCode = con.getResponseCode();
            if(statusCode== HttpURLConnection.HTTP_OK)
            {
                Log.d("demo","i got here");
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while(line!=null)
                {
                    sb.append(line);
                    line= br.readLine();
                }
                Log.d("demo","i got string "+sb.toString());
                return ParserUtilityClass.Util.parserMethod(sb.toString());
            }
            else
            {
                return null;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<MusicResults> musicResultses) {
        super.onPostExecute(musicResultses);
        Message msg = new Message();
//Log.d("demo",musicResultses.toString());
        Bundle bundle = new Bundle();
        msg.what = RESULT_OKmusic;
        bundle.putParcelableArrayList("returnList",musicResultses);
        msg.setData(bundle);
        handler.sendMessage(msg);


    }
}
