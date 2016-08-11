package com.example.simpletimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ProgressbarTAG_";
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.main_progessbar);
        mTextView = (TextView) findViewById(R.id.main_textview);

    }

    public void doMagic(View view) {
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: ");
                mProgressBar.setVisibility(View.INVISIBLE);
                handler.postDelayed(this, 1000);

                mCounter++;
                mTextView.setText(String.valueOf(mCounter));
            }
            //run log after 1000ms
        }, 1000);
    }
}
