package com.example.sunilm.musicapp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by sunilm on 2/5/2018.
 */

public class ParserUtilityClass {

    static public class Util{

       public static ArrayList<MusicResults> parserMethod(String in) throws JSONException {
            //JsonReader jsonReader = new JsonReader(inputStream);
           ArrayList<MusicResults> retunArrayList = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(in.toString());
           JSONArray jsonArray=jsonObject.getJSONArray("results");

/*

           String trackName;
           String genre;
           String artist;
           String album;
           String trackPrice;
           String albumPrice;
           String releaseDate;
           String trackViewUrl;
*/

         for (int i = 0; i<jsonArray.length()-1;i++)
         {
             JSONObject currentJsonObject = jsonArray.getJSONObject(i);
             MusicResults musicResults = new MusicResults();
             if(currentJsonObject.getString("trackName")!=null) {

                 musicResults.setTrackName(currentJsonObject.getString("trackName"));
             }
                 if(currentJsonObject.getString("primaryGenreName")!=null) {

                     musicResults.setGenre(currentJsonObject.getString("primaryGenreName"));
                 }
                     if(currentJsonObject.getString("artistName")!=null) {

                         musicResults.setArtist(currentJsonObject.getString("artistName"));
                     }
             if(!currentJsonObject.isNull("collectionName")&& currentJsonObject.getString("collectionName")!=null) {
                 musicResults.setAlbum(currentJsonObject.getString("collectionName"));
             }

             if(currentJsonObject.getString("trackPrice")!=null) {

                 musicResults.setTrackPrice(currentJsonObject.getString("trackPrice"));
             }
             if(!currentJsonObject.isNull("collectionPrice")&&currentJsonObject.getString("collectionPrice")!=null) {

                 musicResults.setAlbumPrice(currentJsonObject.getString("collectionPrice"));
             }
             if(currentJsonObject.getString("releaseDate")!=null) {

                 musicResults.setReleaseDate(currentJsonObject.getString("releaseDate"));}
                 if(currentJsonObject.getString("releaseDate")!=null) {

                     musicResults.setTrackViewUrl(currentJsonObject.getString("releaseDate"));
                 }
                     if(currentJsonObject.getString("artworkUrl100")!=null)
                     {
                         musicResults.setArtworkUrl100(currentJsonObject.getString("artworkUrl100"));}
             retunArrayList.add(musicResults);
         }

            return retunArrayList;
        }

    }
}
