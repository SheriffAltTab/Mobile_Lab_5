package com.example.task4_8;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageButton button;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button = findViewById(R.id.button);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // При натисканні показуємо focused зображення
                        button.setImageResource(R.drawable.smile_focused);
                        return true;
                        
                    case MotionEvent.ACTION_UP:
                        // При відпусканні показуємо pressed зображення
                        button.setImageResource(R.drawable.smile_pressed);
                        Toast.makeText(MainActivity.this, "Кнопку натиснуто", Toast.LENGTH_SHORT).show();
                        
                        // Через секунду повертаємо normal зображення
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                button.setImageResource(R.drawable.smile_normal);
                            }
                        }, 1000);
                        return true;
                }
                return false;
            }
        });
    }
}