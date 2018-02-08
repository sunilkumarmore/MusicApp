package com.example.sunilm.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.example.sunilm.musicapp.AsyncClassToLoadSearchList.RESULT_OKmusic;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    ArrayList<MusicResults> nn;
    TextView searchTextView ;
    TextView limitTextView;
    ListView lv;
    Switch ssss;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == RESULT_OKmusic) {
                    if (msg.getData().containsKey("returnList")) {
                        nn = msg.getData().getParcelableArrayList("returnList");
if(nn!=null && nn.size()>0) {


    lv = (ListView) findViewById(R.id.ListView_music);
    MusicAdapter musicAdapter = new MusicAdapter(MainActivity.this, R.layout.adapterlayout_123, nn);
    lv.setAdapter(musicAdapter);
    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(MainActivity.this, DisplayDetails.class);
            intent.putExtra("fromIntent", nn.get(position));
            startActivity(intent);
        }

    });
}

                    }
                }
                return false;
            }
        });

        searchTextView = (TextView) findViewById(R.id.searchId);
        limitTextView = (TextView) findViewById(R.id.limitId);

         seekBar = (SeekBar) findViewById(R.id.seekBar);
       //seekBar.scrollTo(10,30);
       // seekBar.setMin(10);
        seekBar.setMax(30);

        Log.d("demo",""+seekBar.getProgress());

     ssss = (Switch) findViewById(R.id.switch1);
        ssss.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ssss.isChecked())
                {
                    if(nn!=null&& nn.size()>0)
                    {

                        nn = new MusicClassComparer(nn).getSortedJobCandidateByPrice();
                        MusicAdapter musicAdapter = new MusicAdapter(MainActivity.this, R.layout.adapterlayout_123, nn);
                        lv.setAdapter(musicAdapter);
                    }
                }
                else
                {
                    if(nn!=null&& nn.size()>0)
                    {

                        nn = new MusicClassComparer(nn).getSortedJobCandidateByDate();
                        MusicAdapter musicAdapter = new MusicAdapter(MainActivity.this, R.layout.adapterlayout_123, nn);
                        lv.setAdapter(musicAdapter);
                    }
                }
            }
        });



        Button searchButton = (Button) findViewById(R.id.SearchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("demo",""+seekBar.getProgress());
                Log.d("demo",""+searchTextView.getText());
                new AsyncClassToLoadSearchList(handler).execute("https://itunes.apple.com/search?term=" + searchTextView.getText() + "&limit=" +seekBar.getProgress() );
            }
        });

    }

    }


