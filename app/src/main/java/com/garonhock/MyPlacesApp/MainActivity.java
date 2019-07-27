package com.garonhock.MyPlacesApp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PLACE_CREATE = 1 ;
    private ListView mListView;
    private ArrayAdapter <Place> mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list_view); //Wired up list view


        ArrayList<Place> myPlaces = new ArrayList <Place>();
        myPlaces.add(new Place("Laney College", "Near Lake Merritt")); // PUT DATA IN OUR ARRAY LIST
        myPlaces.add(new Place("Berkeley College", "Near UC Berkeley"));
        myPlaces.add(new Place("Merritt College","On Alameda Island"));
        myPlaces.add(new Place("Alameda College", "Near Skyline"));

        mArrayAdapter = new PlaceArrayAdapter(this, myPlaces);
        //Want to build a layout in android that only has one thing in it cheat code
        //Put array list inside of our adapter

        mListView.setAdapter(mArrayAdapter);//gave the adapter to our list view so it can render it
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //need to inflate by giving options
        //inflates options bar at top of screen

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;


        //at this point he created a new menu directory from res folder
        //Still doesnt do anything NEED Next override

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if (item.getItemId()==R.id.main_menu_create){
           launchCreateActivity();

           //TO DO: launch the create place screen
           return true;
       }

        return false;
        //whether or not method onOptionsItemsselected has been handled
    }

    @Override

    //THIS METHOD IS DONE SO THAT WE KNOW When ACTIVITies are CLOSED
    //GETS CALLED WHEN ANY ACTIVITY THAT HAS ANY RESULT CLOSES

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_PLACE_CREATE){
            if (data !=null){
                String name = data.getStringExtra("place_name"); //GET OUT TWO PIECES OF INFO
                String description = data.getStringExtra("place_description"); //FROM INTENT

                Place added = new Place(name, description); //CREATED OBJECT
                mArrayAdapter.add(added); //ADDED TO LIST

            }
        }
    }

    private void launchCreateActivity(){
        Intent createIntent = new Intent(this,PlaceCreateActivity.class);
        startActivityForResult(createIntent, REQUEST_PLACE_CREATE);
    }
}
