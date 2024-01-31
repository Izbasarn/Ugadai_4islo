package com.example.elementi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomNumber;
    private int attempts;
    private EditText guessEditText;
    private TextView resultTextView;
    private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Генерируем случайное число от 1 до 100
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;

        guessEditText = findViewById(R.id.guessEditText);
        resultTextView = findViewById(R.id.resultTextView);
        checkButton = findViewById(R.id.checkButton);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });
    }

    private void checkGuess() {
        String guessStr = guessEditText.getText().toString();

        if (guessStr.isEmpty()) {
            resultTextView.setText("Введите число");
            return;
        }

        int guess = Integer.parseInt(guessStr);
        attempts++;

        if (guess < randomNumber) {
            resultTextView.setText("Загаданное число больше");
        } else if (guess > randomNumber) {
            resultTextView.setText("Загаданное число меньше");
        } else {
            resultTextView.setText("Поздравляем! Вы угадали число " + randomNumber + " за " + attempts + " попыток.");
            guessEditText.setEnabled(false);
            checkButton.setEnabled(false);
        }
    }
}
