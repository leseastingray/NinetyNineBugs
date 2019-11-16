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
    public Integer bugTotal = 99;
    public Integer bugNumber = 1;
    public String bugTotalString ="";
    public static final String BUG_NUMBER = "bugNumber";
    public static final String BUG_TOTAL = "bugTotal";
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

        // extract bugTotal from intent data
        bugTotal = data.getIntExtra(BUG_TOTAL, bugTotal);
        bugTotalString = Integer.toString(bugTotal);

        // manipulate bugNumberTextView
        bugNumberTextView.setText((bugTotalString) + " Bugs on the Wall");
    }

    /* ------------- Event Handlers --------------*/

    // Click handler for takeOneButton, referenced in layout/activity_main.xml
    public void takeOne(View v)
    {
        bugNumber = 1;
        //Toast.makeText(this, Integer.toString(bugNumber), Toast.LENGTH_SHORT).show();
        // Start second activity and send info from main activity
        Intent intent = new Intent(this, SecondActivity.class);
        // Sends data to 2nd activity
        intent.putExtra(BUG_NUMBER, bugNumber);
        intent.putExtra(BUG_TOTAL, bugTotal);
        startActivityForResult(intent, REQUEST_1);
    }
    // Click handler for takeTwoButton, referenced in layout/activity_main.xml
    public void takeTwo(View v)
    {
        bugNumber = 2;
        //Toast.makeText(this, Integer.toString(bugNumber), Toast.LENGTH_SHORT).show();
        // Start second activity and send info from main activity
        Intent intent = new Intent(this, SecondActivity.class);
        // Sends data to 2nd activity
        intent.putExtra(BUG_NUMBER, bugNumber);
        intent.putExtra(BUG_TOTAL, bugTotal);
        startActivityForResult(intent, REQUEST_1);
    }
}
