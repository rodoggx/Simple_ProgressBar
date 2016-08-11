package com.example.simpletimer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
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

                if (mCounter %2 == 0) {
                    mProgressBar.setVisibility(View.VISIBLE);
                } else mProgressBar.setVisibility(View.INVISIBLE);
            }
            //run log after 1000ms
        }, 1000);
    }
    public void doAlarm(View view) {
        Intent intent = new Intent(this, MyService.class);

        PendingIntent pendingIntent
                = PendingIntent.getService(this, 0, intent, 0);

        AlarmManager alarmManager
                = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(),
                5000,
                pendingIntent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis() + 5000,
                    pendingIntent);
        }
    }
}
