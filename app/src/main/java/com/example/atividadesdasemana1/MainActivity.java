package com.example.atividadesdasemana1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button buttonClick;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ContaCliques
        buttonClick = findViewById(R.id.buttonClick);
        buttonClick.setOnClickListener(v -> count());

        // Sorteio
        editTextMin = findViewById(R.id.editTextMin);
        editTextMax = findViewById(R.id.editTextMax);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void count(){
        count++;
        buttonClick.setText(Integer.toString(count));
    }

    //Sorteio
    private EditText editTextMin;
    private EditText editTextMax;
    private TextView textViewResult;

    public void drawRandomNumber(View view) {
        String minString = editTextMin.getText().toString();
        String maxString = editTextMax.getText().toString();

        if (!minString.isEmpty() && !maxString.isEmpty()) {
            int min = Integer.parseInt(minString);
            int max = Integer.parseInt(maxString);

            if (min <= max) {
                Random random = new Random();
                int randomNumber = random.nextInt(max - min + 1) + min;
                textViewResult.setText("Número sorteado: " + randomNumber);
            } else {
                textViewResult.setText("Intervalo inválido");
            }
        } else {
            textViewResult.setText("Preencha ambos os campos");
        }
    }

}
