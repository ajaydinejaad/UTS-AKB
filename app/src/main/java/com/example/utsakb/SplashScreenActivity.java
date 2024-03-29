package com.example.utsakb;
/* 10118707 , R Wiranda Purba , IF 10
 */
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
                    finish();
                }
            }
        };
    }
}