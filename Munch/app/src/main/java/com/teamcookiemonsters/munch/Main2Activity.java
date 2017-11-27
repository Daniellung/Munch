//I'm not Dianna K
package com.teamcookiemonsters.munch;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.yelp.fusion.client.connection.YelpFusionApi;
import com.yelp.fusion.client.connection.YelpFusionApiFactory;
import com.yelp.fusion.client.models.Business;
import com.yelp.fusion.client.models.SearchResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;

import static junit.framework.Assert.assertNotNull;

public class Main2Activity extends AppCompatActivity
        implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    //EditText mEdit;
    //String text;

    private SearchManager searchManager;
    private android.widget.SearchView searchView;
    private MyExpandableListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<ParentRow> parentList = new ArrayList<ParentRow>();
    private ArrayList<ParentRow> showTheseParentList = new ArrayList<ParentRow>();
    private MenuItem searchItem;

    public String clientID = "eJuUlcITJQl5ZFtbE-Vs6g";
    public String clientSecret = "q79eV6MADDyFMboJWaBNg41qaxBsAiAkxhElntcYQr2FfaCJPigDfJn4hJvuq97A";
    public String web = "https://api.yelp.com/oauth2/token";
    public String accessToken = "h0hbwDp-INaIDxBnvI75S9GNpokFCIiUq6k8PG6ZSvS96o8pJFWLtBpvNGhXrb6qUVNoHdo_cifBSv-W5EooyI2AEceKbXlhHUWDsqz8A6bCCGk1wKkY8xIwnZ__WXYx";

    Thread t;

    public String testOne;
    public YelpFusionApi mYelpFusionApi;
    public YelpFusionApiFactory apiFactory;
    public Map<String, String> mParams;

    public static int listDisplay = 0;
    //SearchResponse response;

    String[] lists = new String[20];

    //public int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       Intent intent = getIntent();

       SearchItem search = (SearchItem)intent.getSerializableExtra("Search");

       String text = search.getSearch();

       // SearchItem newSearch = new SearchItem();
       // newSearch.setSearch("indian");
       // String meow = newSearch.getSearch();

        apiFactory = new YelpFusionApiFactory();
        try {
            //yelpFusionApi = apiFactory.createAPI(clientID, clientSecret);
            mYelpFusionApi = apiFactory.createAPI(accessToken);
        } catch (IOException ex) {
            Log.d("CREATION", "PLEASE WORK");
            //Toast.makeText(this,"Didnt Work",Toast.LENGTH_LONG).show();
        }

        mParams = new HashMap<>();

        //mParams.put("San Francisco", "indian food");


        String woof = "Indian Food";

        //setSearch();

        mParams.put("term", text);
        mParams.put("latitude", "40.581140");
        mParams.put("longitude", "-111.914184");

        new GetData().execute();

        try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(8000);
        } catch (Exception e) {
            Toast.makeText(this,"Didnt Work",Toast.LENGTH_LONG).show();
        }

        /*Call<SearchResponse> call = yelpFusionApi.getBusinessSearch(params);

        Response<SearchResponse> response = null;



        if (call != null){*/
        /*Call<Business> call = yelpFusionApi.getBusiness("japacurry-truck-san-francisco");
        Response<Business> response;

        try {
             response = call.execute();
            Business business = response.body();
        } catch (IOException e){
            Toast.makeText(this,"Didnt Work",Toast.LENGTH_LONG).show();
        }

        */
       /* try {
          businessSearchTest();
          //response = call.execute();
        } catch (IOException ex){
            Toast.makeText(this,"Didnt Work",Toast.LENGTH_LONG).show();
        }*/

        //response.body().getBusinesses().get(0);
        //testOne = response.getBusinesses().get(0).getName();



        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSuportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH)
                        .setAction("Action", null).show();
            }
        });*/
        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        parentList = new ArrayList<ParentRow>();
        showTheseParentList = new ArrayList<ParentRow>();

        //app will crash if display list not called here
        displayList();
        //expands the list of contents
        expandAll();

        /*
        myList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent naviIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(naviIntent);
            }
        });
        */
    }

    /*public void setSearch(){
        mEdit = (EditText)findViewById(R.id.searchText);
        text = mEdit.getText().toString();
    }*/




   /* public void businessSearchTest() throws IOException {
        Map<String, String> parms = new HashMap<>();
        parms.put("term", "indian food");
        parms.put("latitude", "40.581140");
        parms.put("longitude", "-111.914184");
        Call<SearchResponse> call = mYelpFusionApi.getBusinessSearch(parms);
        Response<SearchResponse> response = call.execute();
        testOne = response.body().getBusinesses().get(0).getName();
        assertNotNull(response);
    }*/

    private void loadData() {
        ArrayList<ChildRow> childRows = new ArrayList<ChildRow>();
        ParentRow parentRow = null;
        /*
        childRows.add(new ChildRow(R.mipmap.ic_launcher_round
                , "Text1"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher_round
                , testOne));
        */
        for(int i = 0; i < 14; i++){
            childRows.add(new ChildRow(R.mipmap.ic_launcher_round
                    , lists[i]));
        }

        parentRow = new ParentRow("First Group", childRows);

        parentList.add(parentRow);

        /*
        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.ic_launcher_round
                , "Text3"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher_round
        , testOne));
        parentRow = new ParentRow("Second Group", childRows);
        parentList.add(parentRow);
        */
    }

    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            myList.expandGroup(i);
        }
    }

    private void displayList() {
        loadData();

        myList = (ExpandableListView) findViewById(R.id.expandableListView_search);
        listAdapter = new MyExpandableListAdapter(Main2Activity.this, parentList);
        myList.setAdapter(listAdapter);
    }

    //gets random integer for the index i in lists[i] which is the list used to display search results
    private int getRandomInt() {
        int min = 1;
        int max = 14;
        Random rand = new Random();
        int randInt = rand.nextInt((max-min)+1)+min;
        return randInt;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu; this adds items to the aciton bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.requestFocus();

        return true;
    }

    @Override
    public boolean onClose() {
        listAdapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.filterData(newText);
        expandAll();
        return false;
    }


    class GetData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            Call<SearchResponse> call = mYelpFusionApi.getBusinessSearch(mParams);
            Response<SearchResponse> response = null;
            try {
                response = call.execute();
            } catch (IOException e){
                e.printStackTrace();
            }
            if(response != null){
                for(int i = 0; i < 14; i++) {
                    Log.v("Businesses", response.body().getBusinesses().get(i).getName());
                    lists[i] = response.body().getBusinesses().get(i).getName();
                }
            }
            return null;
        }
    }
}