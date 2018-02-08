package com.example.sunilm.musicapp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by sunilm on 2/7/2018.
 */

public class MusicClassComparer {

    ArrayList<MusicResults> musicResults = new ArrayList<>();
    public MusicClassComparer(ArrayList<MusicResults> musicResults) {
        this.musicResults = musicResults;
    }
    public ArrayList<MusicResults> getSortedJobCandidateByDate() {
        Collections.sort(musicResults, MusicResults.dateComparator);
        return musicResults;
    }
    public ArrayList<MusicResults> getSortedJobCandidateByPrice() {
        Collections.sort(musicResults, MusicResults.priceComparator);
        return musicResults;
    }


}

