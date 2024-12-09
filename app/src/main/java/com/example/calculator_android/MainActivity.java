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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView screenResult, screenCalculation;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonCe,buttonBackspace,
    buttonOpenParentheses, buttonCloseParentheses,buttonDivide, buttonMultiply, buttonMinus, buttonSum, buttonEquals, buttonDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenResult = findViewById(R.id.results);
        screenCalculation = findViewById(R.id.calculation);

        assingId(button0, R.id.zero);
        assingId(button1, R.id.one);
        assingId(button2, R.id.two);
        assingId(button3, R.id.three);
        assingId(button4, R.id.four);
        assingId(button5, R.id.five);
        assingId(button6, R.id.six);
        assingId(button7, R.id.seven);
        assingId(button8, R.id.eight);
        assingId(button9, R.id.nine);
        assingId(buttonCe, R.id.ce);
        assingId(buttonBackspace, R.id.backspace);
        assingId(buttonOpenParentheses, R.id.parenthesesOne);
        assingId(buttonCloseParentheses, R.id.parenthesesTwo);
        assingId(buttonDivide, R.id.division);
        assingId(buttonMultiply, R.id.multiplication);
        assingId(buttonMinus, R.id.decrement);
        assingId(buttonSum, R.id.sum);
        assingId(buttonEquals, R.id.equals);
        assingId(buttonDot, R.id.dot);

    }

    void assingId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    void Cal(TextView screenCalculation) {

    }


    @Override
    public void onClick(View v) {
        MaterialButton button = (MaterialButton) v;
        String buttonText = button.getText().toString();
        String calculationData = screenCalculation.getText().toString();

        if(buttonText.equals("CE")) {
            screenCalculation.setText("");
            screenResult.setText("0");
            return;
        }
        if(buttonText.equals("=")) {
            screenResult.setText(screenCalculation.getText());
            screenCalculation.setText("");
            return;
        }
        if(buttonText.equals("C")) {
            if (!screenCalculation.getText().equals("")) {
                calculationData = calculationData.substring(0, calculationData.length() - 1);
            }

        } else {
            if(!buttonText.equals("=")) {
                calculationData = calculationData + buttonText;
            }
        }
        screenCalculation.setText(calculationData);

    }
}
