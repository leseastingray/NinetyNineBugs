package com.alese.ninetyninebugs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {


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

        // Get intent from MainActivity
        Intent intent = getIntent();

    }

    /* ------------- Event Handlers --------------*/
    // Method for patching bug (subtracting it from total)
    public void patchBug()
    {

    }
    public void bugOut(View v)
    {
        Intent bugs = new Intent(this, MainActivity.class);
        //bugs.putExtra(MainActivity.BUGS, Integer.toString(bugNumber));
        //setResult(REQUEST_OK, bugs);
        finish();
    }
}
