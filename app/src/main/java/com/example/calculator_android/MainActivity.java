package com.example.calculator_android;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double first_num;
    String operation;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView screen_result = findViewById(R.id.results);
        TextView screen_calculation = findViewById(R.id.calculations);

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
        Button sum = findViewById(R.id.sum_button);
        Button minus = findViewById(R.id.minus_button);
        Button multiplication = findViewById(R.id.multiplication_button);
        Button division = findViewById(R.id.division_button);
        Button percentage = findViewById(R.id.percent_button);
        Button dot = findViewById(R.id.dot_button);
        Button equals = findViewById(R.id.equals_button);
        Button ac_button = findViewById(R.id.ac_button);
        Button backspace = findViewById(R.id.backspace);
        Button backspace_2 = findViewById(R.id.backspace_2);


        ac_button.setOnClickListener(View -> {
            first_num = 0;
            screen_result.setText("0");
            screen_calculation.setText("");
        });

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        for (Button b : nums) {
            b.setOnClickListener(view -> {
                if (!screen_result.getText().toString().equals("0")) {
                    screen_result.setText(screen_result.getText().toString() + b.getText().toString());
                    screen_calculation.setText(screen_calculation.getText().toString() + b.getText());
                } else {
                    screen_result.setText(b.getText().toString());
                    screen_calculation.setText(screen_calculation.getText().toString() + b.getText().toString());
                }

            });
        }
        ArrayList<Button> operators = new ArrayList<>();
        operators.add(sum);
        operators.add(minus);
        operators.add(multiplication);
        operators.add(division);
        operators.add(percentage);


        for (Button b: operators) {
            b.setOnClickListener(view -> {
                first_num = Double.parseDouble(screen_result.getText().toString());
                operation = b.getText().toString();
                if (!screen_result.getText().toString().equals("0")) {
                    screen_calculation.setText(screen_calculation.getText().toString() + b.getText().toString());
                    screen_result.setText("0");
                }
            });
        }

        backspace.setOnClickListener((view -> {
            String num = screen_result.getText().toString();
            String num_2 = screen_calculation.getText().toString();
            if (num.length()>1 && num_2.length()>1){
                screen_result.setText(num.substring(0,num.length()-1));
                screen_calculation.setText(num_2.substring(0,num_2.length()-1));
            } else if (num.length() <= 1 && num_2.length() <= 1) {
                screen_result.setText("0");
                screen_calculation.setText("");
            }
        }));

        backspace_2.setOnClickListener((view -> {
            String num = screen_result.getText().toString();
            String num_2 = screen_calculation.getText().toString();
            if (num.length()>1 && num_2.length()>1){
                screen_result.setText(num.substring(0,num.length()-1));
                screen_calculation.setText(num_2.substring(0,num_2.length()-1));
            } else if (num.length() <= 1 && num_2.length() <= 1) {
                screen_result.setText("0");
                screen_calculation.setText("");
            }
        }));

        dot.setOnClickListener(view -> {
            if (!screen_result.getText().toString().contains(".")) {
                screen_result.setText(screen_result.getText().toString() + ".");
                screen_calculation.setText(screen_calculation.getText().toString() + ".");
            }
        });

        equals.setOnClickListener(view ->{
                if (operation == null){
                    operation = "+";
                }
                double second_num = Double.parseDouble(screen_result.getText().toString());
                double result;
                switch (operation) {
                    case "-":
                        result = first_num - second_num;
                        break;
                    case "+":
                        result = first_num + second_num;
                        break;
                    case "*":
                        result = first_num * second_num;
                        break;
                    case "/":
                        result = first_num / second_num;
                        break;

                    case "%":
                        result = (first_num / 100) * second_num;
                        break;

                    default:
                        result = first_num;
                }

                screen_result.setText(String.valueOf(result));
                screen_calculation.setText(String.valueOf(result));
                first_num = result;

        });
    }
}