package com.example.calculator_android;

import android.os.Bundle;
import android.view.ActionProvider;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {



    private MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonCe,buttonBackspace,
    buttonOpenParentheses, buttonCloseParentheses,buttonDivide, buttonMultiply, buttonMinus, buttonSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button num0 = findViewById(R.id.zero);
        Button num1 = findViewById(R.id.one);
        Button num2 = findViewById(R.id.two);
        Button num3 = findViewById(R.id.three);
        Button num4 = findViewById(R.id.four);
        Button num5 = findViewById(R.id.five);
        Button num6 = findViewById(R.id.six);
        Button num7 = findViewById(R.id.seven);
        Button num8 = findViewById(R.id.eight);
        Button num9 = findViewById(R.id.nine);

        Button ce = findViewById(R.id.ce);
        Button backspace = findViewById(R.id.backspace);
        Button openParentheses = findViewById(R.id.parenthesesOne);
        Button closeParentheses = findViewById(R.id.parenthesesTwo);
        Button division = findViewById(R.id.division);
        Button multiply = findViewById(R.id.multiplication);
        Button decrease = findViewById(R.id.decrement);
        Button sum = findViewById(R.id.sum);
        Button dot = findViewById(R.id.dot);
        Button equal = findViewById(R.id.equals);

        TextView screenResult = findViewById(R.id.results);
        TextView screenCalculation = findViewById(R.id.calculation);

        backspace.setText("<");

    }
}