//I'm not Dianna K
package com.teamcookiemonsters.munch;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity
    implements SearchView.OnQueryTextListener, SearchView.OnCloseListener{

    private SearchManager searchManager;
    private android.widget.SearchView searchView;
    private MyExpandableListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<ParentRow> parentList = new ArrayList<ParentRow>();
    private ArrayList<ParentRow> showTheseParentList = new ArrayList<ParentRow>();
    private MenuItem searchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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
    }

    private void loadData() {
        ArrayList<ChildRow> childRows = new ArrayList<ChildRow>();
        ParentRow parentRow = null;

        childRows.add(new ChildRow(R.mipmap.ic_launcher_round
                , "Text1"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher_round
                , "Text2"));
        parentRow = new ParentRow("First Group", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.ic_launcher_round
                , "Text3"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher_round
                , "Text4"));
        parentRow = new ParentRow("Second Group", childRows);
        parentList.add(parentRow);
    }

    private void expandAll(){
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            myList.expandGroup(i);
        }
    }
    private void displayList(){
        loadData();

        myList = (ExpandableListView) findViewById(R.id.expandableListView_search);
        listAdapter = new MyExpandableListAdapter(Main2Activity.this, parentList);
        myList.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
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
}