package com.kelompok1.aplikasitanamanhias.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.kelompok1.tanamanhias.R;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if(Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        final int welcomeScreen = 3000;//3 detik
        Thread welcome = new Thread(){
            int wait = 0;

            public void run(){
                try {
                    super.run();
                    while (wait < welcomeScreen){
                        sleep(100);
                        wait += 100;
                    }
                }catch (Exception e){
                    System.out.println("Exception : "+e);
                }finally {
                    Intent intent = new Intent(SplashScreen.this,Kategori.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        welcome.start();
    }
}