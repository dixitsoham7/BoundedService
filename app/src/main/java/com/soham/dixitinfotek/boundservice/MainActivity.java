package com.soham.dixitinfotek.boundservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button play, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button)findViewById(R.id.playBtn);
        stop = (Button)findViewById(R.id.stopBtn);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    // on click method called when the button is clicked.
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.playBtn:
                Intent playIntent = new Intent(this, MyServiceManager.class);
                // start service with the intent.
                startService(playIntent);
                break;

            case R.id.stopBtn:
                Intent stopIntent = new Intent(this, MyServiceManager.class);
                // stop service with the intent.
                stopService(stopIntent);
                break;

        }
    }
}
