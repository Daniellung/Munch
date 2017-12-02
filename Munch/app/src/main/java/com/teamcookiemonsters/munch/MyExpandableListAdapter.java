package com.teamcookiemonsters.munch;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Justin Tse on 10/24/2017.
 */

//adapter for expandable list
public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<ParentRow> parentRowList;
    private ArrayList<ParentRow> originalList;

    public MyExpandableListAdapter(Context context, ArrayList<ParentRow> originalList){
        this.context =context;
        this.parentRowList = new ArrayList<>();
        this.parentRowList.addAll(originalList);
        this.originalList = new ArrayList<>();
        this.originalList.addAll(originalList);
    }

    //number of parent row
    @Override
    public int getGroupCount() {
        return parentRowList.size();
    }

    //number of child rows
    @Override
    public int getChildrenCount(int groupPosition) {
        return parentRowList.get(groupPosition).getChildList().size();
    }

    //gets the parent row containing the child row
    @Override
    public Object getGroup(int groupPosition) {
        return parentRowList.get(groupPosition);
    }

    //gets child row
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return parentRowList.get(groupPosition).getChildList().get(childPosition);
    }

    //gets location of child row's id
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //gets the child row id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //checks ids
    @Override
    public boolean hasStableIds() {
        return true;
    }

    //gets group view
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup viewGroup) {
        ParentRow parentRow = (ParentRow) getGroup(groupPosition);

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.parent_row, null);
        }
        TextView heading = (TextView) convertView.findViewById(R.id.parent_text);

        heading.setText(parentRow.getName().trim());
        return convertView;
    }

    //gets child view
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup viewGroup) {
        ChildRow childRow = (ChildRow) getChild(groupPosition, childPosition);
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_row, null);
        }
        ImageView childIcon = (ImageView) convertView.findViewById(R.id.child_icon);
        childIcon.setImageResource(childRow.getIcon());

        final TextView childText = (TextView) convertView.findViewById(R.id.child_text);
        childText.setText(childRow.getText().trim());

        final View finalConvertView = convertView;
        childText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(finalConvertView.getContext()
                        , childText.getText()
                        , Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    //checks if child is selectable
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    //fiters data
    public void filterData(String query){
        query = query.toLowerCase();
        parentRowList.clear();

        if(query.isEmpty()){
            parentRowList.addAll(originalList);
        }else{
            for (ParentRow parentRow : originalList){
                ArrayList<ChildRow> childList = parentRow.getChildList();
                ArrayList<ChildRow> newList = new ArrayList<ChildRow>();

                for (ChildRow childRow: childList){
                    if (childRow.getText().toLowerCase().contains(query)){
                        newList.add(childRow);
                    }
                }
                if (newList.size() > 0){
                    ParentRow nParentRow = new ParentRow(parentRow.getName(), newList);
                    parentRowList.add(nParentRow);
                }
            }
        }
        notifyDataSetChanged();
    }
}
