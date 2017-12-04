package com.teamcookiemonsters.munch;

import android.widget.EditText;
import java.io.Serializable;

/**
 * Created by Sanjeet on 11/23/2017.
 * Search Object passed to List Activity
 */

public class SearchItem implements Serializable {
    public static String search;

    // empty constructor
    public SearchItem() {};

    // constructor
    public SearchItem(String input){
        search = input;
    }

    // returns search string
    public String getSearch() {return search;}

    // sets search string
    public void setSearch(String actSearch) {
        search = actSearch;
    }
}

