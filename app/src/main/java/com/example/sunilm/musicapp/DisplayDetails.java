package com.example.sunilm.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/



        if(getIntent().getExtras().containsKey("fromIntent"))
        {
            MusicResults musicResults= getIntent().getExtras().getParcelable("fromIntent");

            //Log.d("demoimage",musicResults.getAlbumPrice());
            ImageView imageView = (ImageView) findViewById(R.id.musicdeatilsimage);
            imageView.setVisibility(View.VISIBLE);
           Picasso.with(this).load(musicResults.getArtworkUrl100()).into(imageView);
            TextView trackName = findViewById(R.id.TrackId_details);
            TextView genre = findViewById(R.id.Genere_id);
            TextView atist = findViewById(R.id.Artist_id);
            TextView album = findViewById(R.id.Album_id);
            TextView trackprice =  findViewById(R.id.tackPrice_id);
            TextView albumPrice = findViewById(R.id.album_priceid);

            trackName.append(musicResults.getTrackName());
            genre.append(musicResults.getGenre());
            atist.append(musicResults.getArtist());
            album.append(musicResults.getAlbum());
            trackprice.append(musicResults.getTrackPrice());
           albumPrice.append(musicResults.getAlbumPrice());

            findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();

                }
            });

        }
    }

}
