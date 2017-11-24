package com.teamcookiemonsters.munch;

import android.widget.EditText;
import java.io.Serializable;

/**
 * Created by Sanjeet on 11/23/2017.
 */

public class SearchItem implements Serializable {
    public static String search;

    public SearchItem() {};

    public SearchItem(String input){
        search = input;
    }

    public String getSearch() {return search;}

    public void setSearch(String actSearch) {
       search = actSearch;
    }
}
