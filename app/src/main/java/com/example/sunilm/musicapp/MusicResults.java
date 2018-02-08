package com.example.sunilm.musicapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

/**
 * Created by sunilm on 2/5/2018.
 */

public class MusicResults implements Parcelable{

    @Override
    public String toString() {
        return "MusicResults{" +
                "trackName='" + trackName + '\'' +
                ", genre='" + genre + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", trackPrice='" + trackPrice + '\'' +
                ", albumPrice='" + albumPrice + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", trackViewUrl='" + trackViewUrl + '\'' +
                ", artworkUrl100='" + artworkUrl100 + '\'' +
                '}';
    }

    public MusicResults(String trackName, String genre, String artist, String album, String trackPrice, String albumPrice, String releaseDate, String trackViewUrl, String artworkUrl100) {
        this.trackName = trackName;
        this.genre = genre;
        this.artist = artist;
        this.album = album;
        this.trackPrice = trackPrice;
        this.albumPrice = albumPrice;
        this.releaseDate = releaseDate;
        this.trackViewUrl = trackViewUrl;
        this.artworkUrl100 = artworkUrl100;
    }


    public static Comparator<MusicResults> priceComparator = new Comparator<MusicResults>() {
        @Override
        public int compare(MusicResults jc1, MusicResults jc2) {
            return (int) (jc1.getTrackPrice().compareTo(jc2.getTrackPrice()));
        }
    };

    public static Comparator<MusicResults> dateComparator = new Comparator<MusicResults>() {
        @Override
        public int compare(MusicResults jc1, MusicResults jc2) {
            return (int) (jc1.getReleaseDate().compareTo(jc2.getReleaseDate()   ));
        }
    };



    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getAlbumPrice() {
        return albumPrice;
    }

    public void setAlbumPrice(String albumPrice) {
        this.albumPrice = albumPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    String trackName;
    String genre;
    String artist;
    String album;
    String trackPrice;
    String albumPrice;
    String releaseDate;
    String trackViewUrl;

    public MusicResults() {

    }

    String artworkUrl100;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(trackName);
        parcel.writeString(genre);
        parcel.writeString(artist);
        parcel.writeString(album);
        parcel.writeString(trackPrice);
        parcel.writeString(albumPrice);
        parcel.writeString(releaseDate);
        parcel.writeString(trackViewUrl);
        parcel.writeString(artworkUrl100);
    }



    public static final Parcelable.Creator<MusicResults> CREATOR
            = new Parcelable.Creator<MusicResults>() {
        public MusicResults createFromParcel(Parcel in) {
            return new MusicResults(in);
        }

        public MusicResults[] newArray(int size) {
            return new MusicResults[size];
        }
    };

    public MusicResults(Parcel in) {
/*        String trackName;
        String genre;
        String artist;
        String album;
        String trackPrice;
        String albumPrice;
        String releaseDate;
        String trackViewUrl;
        String artworkUrl100;*/
        this.trackName = in.readString();
        this.genre= in.readString();
        this.artist= in.readString();
        this.album= in.readString();
        this.trackPrice= in.readString();
        this. albumPrice= in.readString();
        this. releaseDate= in.readString();
        this. trackViewUrl= in.readString();
        this. artworkUrl100= in.readString();

    }
}
