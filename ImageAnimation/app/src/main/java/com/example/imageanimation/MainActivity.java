package com.example.imageanimation;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button fadeButton;
    Button rotateButton;
    Button scaleButton;
    Button translateButton;
    ImageView iv_image;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_image = (ImageView) findViewById(R.id.iv_image);
        fadeButton = (Button) findViewById(R.id.fadeImage);
        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_image.animate().alpha(0f).setDuration(1000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        iv_image.animate().alpha(1f).setDuration(1000);
                    }
                });
            }
        });
        
        rotateButton = (Button) findViewById(R.id.rotateImage);
        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_image.animate().rotationBy(360f).setDuration(1000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        iv_image.animate().rotationBy(-360f).setDuration(1000).setStartDelay(250).start();
                    }
                });
            }
        });
        
        scaleButton = (Button) findViewById(R.id.scaleImage);
        scaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_image.animate().scaleXBy(-0.95f).scaleYBy(-0.95f).setDuration(1000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        iv_image.animate().scaleXBy(1f).scaleYBy(1f).setDuration(1000);
                    }
                });
            }
        });
        
        translateButton = (Button) findViewById(R.id.translateImage);
        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_image.animate().translationX(-250f).setDuration(1000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        iv_image.animate().translationX(250f).setDuration(1000).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                iv_image.animate().translationX(0).setDuration(500);
                            }
                        });
                    }
                });
            }
        });
    }
}
