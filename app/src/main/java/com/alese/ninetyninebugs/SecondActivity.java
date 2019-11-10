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
    public void patchBug(View v)
    {
        // Get intent from MainActivity
        Intent intent = getIntent();
        // Get extras: previous bug total, bug number
        newBugTotal = intent.getExtras().getInt(MainActivity.BUG_TOTAL);
        String bugString = intent.getExtras().getString(MainActivity.BUG);

        // if bug number == 1
        if (bugString == "1")
        {
            newBugTotal -= 1;
        }
        else
        {
            newBugTotal -= 2;
        }
        Toast.makeText(this, Integer.toString(newBugTotal), Toast.LENGTH_SHORT).show();
    }

    public void bugOut(View v)
    {
        Intent bugs = new Intent(this, MainActivity.class);
        bugs.putExtra(MainActivity.BUG_TOTAL, Integer.toString(newBugTotal));
        setResult(RESULT_OK, bugs);
        finish();
    }
}
