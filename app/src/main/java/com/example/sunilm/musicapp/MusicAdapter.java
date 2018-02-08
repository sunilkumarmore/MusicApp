package com.example.sunilm.musicapp;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilm on 2/5/2018.
 */

public class MusicAdapter extends ArrayAdapter<MusicResults> {
    Context context;
    int resource;
    ArrayList<MusicResults> musicResultses;

    public MusicAdapter(MainActivity context, int resource, ArrayList<MusicResults> objects) {
        super(context, R.layout.adapterlayout_123, objects);
        this.context = context;
        this.resource = resource;
        this.musicResultses = objects;

    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        MusicResults musicResults = musicResultses.get(position);
        ViewGroupOfMusic viewGroupOfMusic = null;
        if (convertView == null) {
            viewGroupOfMusic= new ViewGroupOfMusic();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
            viewGroupOfMusic.artist= convertView.findViewById(R.id.Artist_adapter);
            viewGroupOfMusic.releaseDate= convertView.findViewById(R.id.Date_adapter);
            viewGroupOfMusic.trackName= convertView.findViewById(R.id.adapter_track);
            viewGroupOfMusic.priceOfTrack= convertView.findViewById(R.id.adadpter_price);
            convertView.setTag(viewGroupOfMusic);
        }
            viewGroupOfMusic= (ViewGroupOfMusic) convertView.getTag();
          viewGroupOfMusic.artist.setText("Artist:" +" "+musicResults.getArtist());
            viewGroupOfMusic.releaseDate.setText("Date:"+ " "+musicResults.getReleaseDate());
            viewGroupOfMusic.trackName.setText("Track"+ " "+musicResults.getTrackName());
            viewGroupOfMusic.priceOfTrack.setText("Price"+ " "+musicResults.getTrackPrice()+"$");


        return convertView;
    }

    static class   ViewGroupOfMusic
    {
        TextView artist;
        TextView releaseDate;
        TextView trackName;
        TextView priceOfTrack;

    }
}
