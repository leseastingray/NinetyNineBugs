package com.alese.ninetyninebugs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Widget variables
    Button takeOneButton;

    // Other variables
    Integer bugNumber = 99;

    /* ------------- Activity Callback Methods --------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up widget variables
        takeOneButton = (Button)findViewById(R.id.takeOneButton);
    }

    /* ------------- Event Handlers --------------*/

    // Click handler for takeOneButton, referenced in layout/activity_main.xml
    public void takeOne(View v)
    {
        Toast.makeText(this, Integer.toString(bugNumber), Toast.LENGTH_SHORT).show();
    }
}
