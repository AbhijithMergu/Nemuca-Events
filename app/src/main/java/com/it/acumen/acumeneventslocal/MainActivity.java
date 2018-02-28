package com.it.acumen.acumeneventslocal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, Game> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        listAdapter.notifyDataSetChanged();
        expListView.setAdapter(listAdapter);

    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, Game>();

        // Adding child data
        listDataHeader.add("737-101 \t Sravya");
        listDataHeader.add("737-073 \t Krushi");
        listDataHeader.add("737-314 \t Bhavani");

//        // Adding child data
//        List<String> top250 = new ArrayList<String>();

        List<PlayerDetails> playerDetails = new ArrayList<>();
        playerDetails.add(new PlayerDetails("player1","Abhijith"));
        listDataChild.put(listDataHeader.get(0),new Game("12345",playerDetails));

        playerDetails = new ArrayList<>();
        playerDetails.add(new PlayerDetails("player2","Abhijith2"));
        listDataChild.put(listDataHeader.get(1),new Game("13454",playerDetails));

        playerDetails = new ArrayList<>();
        playerDetails.add(new PlayerDetails("player3","Abhijith3"));
        listDataChild.put(listDataHeader.get(2),new Game("0876666",playerDetails));

        //top250.add("Abhijith");
//        top250.add("The Godfather");
//        top250.add("The Godfather: Part II");
//        top250.add("Pulp Fiction");
//        top250.add("The Good, the Bad and the Ugly");
//        top250.add("The Dark Knight");
//        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Krushi");
//        nowShowing.add("Despicable Me 2");
//        nowShowing.add("Turbo");
//        nowShowing.add("Grown Ups 2");
//        nowShowing.add("Red 2");
//        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Bhavani");
//        comingSoon.add("The Smurfs 2");
//        comingSoon.add("The Spectacular Now");
//        comingSoon.add("The Canyons");
//        comingSoon.add("Europa Report");

//        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), nowShowing);
//        listDataChild.put(listDataHeader.get(2), comingSoon);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        listAdapter.onActivityResult(requestCode, resultCode, data);
    }

}