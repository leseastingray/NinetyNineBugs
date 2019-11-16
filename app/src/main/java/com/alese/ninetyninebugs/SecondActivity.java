package com.alese.ninetyninebugs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;
import com.alese.ninetyninebugs.MainActivity;

public class SecondActivity extends AppCompatActivity {

    // variables
    public Integer newBugTotal = 99;
    public Integer newBugNumber = 0;
    public String bugString = "";

    /* ------------- Activity Callback Methods --------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

    }

    /* ------------- Event Handlers --------------*/
    // Method for patching bug (subtracting it from total)
    public int patchBug(View v)
    {
        // Get intent from MainActivity
        Intent intent = getIntent();
        // Get extras: previous bug total, bug number
        newBugTotal = intent.getExtras().getInt(MainActivity.BUG_TOTAL);
        newBugNumber = intent.getExtras().getInt(MainActivity.BUG_NUMBER);

        // Display toast to show patching
        Toast.makeText(this, "Patching...", Toast.LENGTH_SHORT).show();

        // subtract newBugNumber (1 or 2) from newBugTotal to update newBugTotal
        newBugTotal -= newBugNumber;
        return newBugTotal;
    }

    public void bugOut(View v)
    {
        Intent bugs = new Intent(this, MainActivity.class);
        bugs.putExtra(MainActivity.BUG_TOTAL, newBugTotal);
        setResult(RESULT_OK, bugs);
        finish();
    }
}
