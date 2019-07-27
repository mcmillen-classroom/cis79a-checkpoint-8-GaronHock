package com.garonhock.MyPlacesApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlaceCreateActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSubmitButton;
    private EditText mNameEditText;
    private EditText mDescriptionEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_create);
        setTitle(R.string.place_create_title);

        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mNameEditText = (EditText) findViewById(R.id.place_name_edit_text);
        mDescriptionEditText = (EditText) findViewById(R.id.place_description_edit_text);

        mSubmitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String name = mNameEditText.getText().toString();
        String description = mDescriptionEditText.getText().toString();

        Intent resultData = new Intent(); //This intent is just meant to hold components that we're going to
        // send back to main activity

        resultData.putExtra("place_name", name);
        resultData.putExtra("place_description", description);

        setResult(RESULT_OK, resultData);//RESULT_OK means nothing has crashed

        finish(); //if you call finish inside of activity it will close the activity

        //TO get this to make a new bar in the list view must use onActivityResult method
        //in main activity

    }
}
