package com.alese.ninetyninebugs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Widget variables
    TextView bugNumberTextView;
    Button takeOneButton;

    // Other variables
    Integer bugNumber = 99;
    public static final String BUGS = "bugs";
    public static final int REQUEST_1 = 1;

    /* ------------- Activity Callback Methods --------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up widget variables
        bugNumberTextView = (TextView)findViewById(R.id.bugNumberTextView);
        takeOneButton = (Button)findViewById(R.id.takeOneButton);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // manipulate bugNumberTextView
        bugNumberTextView.setText(data.getStringExtra(BUGS) + " Bugs on the Wall");
    }

    /* ------------- Event Handlers --------------*/

    // Click handler for takeOneButton, referenced in layout/activity_main.xml
    public void takeOne(View v)
    {
        Toast.makeText(this, Integer.toString(bugNumber), Toast.LENGTH_SHORT).show();
        // Start second activity and send info from main activity
        Intent intent = new Intent(this, SecondActivity.class);
        // Sends data to 2nd activity, turns bugNumber to a string
        intent.putExtra(BUGS, Integer.toString(bugNumber));
        startActivityForResult(intent, REQUEST_1);
    }
}
