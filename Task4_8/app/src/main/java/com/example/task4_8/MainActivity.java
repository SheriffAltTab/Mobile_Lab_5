package com.example.task4_8;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageButton button;
    private Handler handler = new Handler();
    private EditText userName;

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

        // Обробка введення тексту
        userName = findViewById(R.id.user_name);
        userName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    Toast.makeText(getApplicationContext(), userName.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }

    public void onCheckboxClicked(View v) {
        if (((CheckBox) v).isChecked()) {
            Toast.makeText(this, "Відмічено", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Не відмічено", Toast.LENGTH_SHORT).show();
        }
    }

    public void onToggleClicked(View v) {
        if (((ToggleButton) v).isChecked()) {
            Toast.makeText(this, "Увімкнено", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Вимкнено", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRadioButtonClicked(View v) {
        RadioButton rb = (RadioButton) v;
        Toast.makeText(this, "Вибраний звір: " + rb.getText(), Toast.LENGTH_SHORT).show();
    }

    public void onClearClicked(View v) {
        userName.setText("");
        Toast.makeText(this, "Поле очищено", Toast.LENGTH_SHORT).show();
    }
}