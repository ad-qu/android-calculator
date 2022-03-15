package edu.upc.eetac.dsa.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int start = 1, pos = 0, num = 0, firstDigit = 0;
    float result;
    String[] operations = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        TextView textResult = (TextView) findViewById(R.id.textResult);
        TextView textPreview = (TextView) findViewById(R.id.textPreview);

        Button btn_0 = (Button) findViewById(R.id.button_0);
        Button btn_1 = (Button) findViewById(R.id.button_1);
        Button btn_2 = (Button) findViewById(R.id.button_2);
        Button btn_3 = (Button) findViewById(R.id.button_3);
        Button btn_4 = (Button) findViewById(R.id.button_4);
        Button btn_5 = (Button) findViewById(R.id.button_5);
        Button btn_6 = (Button) findViewById(R.id.button_6);
        Button btn_7 = (Button) findViewById(R.id.button_7);
        Button btn_8 = (Button) findViewById(R.id.button_8);
        Button btn_9 = (Button) findViewById(R.id.button_9);
        Button btn_AC = (Button) findViewById(R.id.button_AC);
        Button btn_com = (Button) findViewById(R.id.button_com);
        Button btn_equ = (Button) findViewById(R.id.button_equ);
        Button btn_sum = (Button) findViewById(R.id.button_sum);
        Button btn_sub = (Button) findViewById(R.id.button_sub);
        Button btn_mul = (Button) findViewById(R.id.button_mul);
        Button btn_div = (Button) findViewById(R.id.button_div);
        Button btn_sin = (Button) findViewById(R.id.button_sin);
        Button btn_cos = (Button) findViewById(R.id.button_cos);
        Button btn_tan = (Button) findViewById(R.id.button_tan);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "0"));
                textPreview.setText("= " + result);
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "1"));
                textPreview.setText("= " + result);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "2"));
                textPreview.setText("= " + result);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "3"));
                textPreview.setText("= " + result);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "4"));
                textPreview.setText("= " + result);
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "5"));
                textPreview.setText("= " + result);
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "6"));
                textPreview.setText("= " + result);
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "7"));
                textPreview.setText("= " + result);
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "8"));
                textPreview.setText("= " + result);
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "9"));
                textPreview.setText("= " + result);
            }
        });

        btn_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText("0  ");
                textPreview.setText("");

                operations[0] = "null"; operations[1] = "null"; operations[2] = "null";

                start = 1;
            }
        });

        btn_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), ","));
            }
        });

        btn_equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(textPreview.getText() + "  ");
                textPreview.setText("");
            }
        });

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "+"));
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "-"));
            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "×"));
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "/"));
            }
        });

        btn_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "sin("));
            }
        });

        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "cos("));
            }
        });

        btn_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "tan("));
            }
        });
    }

    public String UpdateText(String information, String digit)
    {
        float op;

        if(start == 1) {
            information = "";
        }

        if(num < 24)
        {
            information = information.replace("  ", "");
            information = information + digit + "  ";

            if((digit == "+") || (digit == "-") || (digit == "×") || (digit == "/") || (digit == "sin(") || (digit == "cos(") || (digit == "tan(")) {
                operations[1] = digit;
                firstDigit = 0;
                pos = 2;
            }
            else if(pos == 0)
            {
                if(start == 1) {
                    operations[0] = digit;
                    result = Float.parseFloat(digit);
                    start = 0;
                }
                else {
                    operations[0] = operations[0] + Float.parseFloat(digit);
                    result = result + Float.parseFloat(digit);
                }
            }
            else if(pos == 2)
            {
                if(firstDigit == 0) {
                    operations[2] = digit;
                    firstDigit = 1;
                }
                else {
                    operations[2] = operations[2] + digit;
                }

                if (operations[1] == "+") {
                    op = Float.parseFloat(operations[0]) + Float.parseFloat(operations[2]);
                    result = op;
                }
                if (operations[1] == "-") {
                    op = Float.parseFloat(operations[0]) - Float.parseFloat(operations[2]);
                    result = op;
                }
                if (operations[1] == "×") {
                    op = Float.parseFloat(operations[0]) * Float.parseFloat(operations[2]);
                    result = op;
                }
                if (operations[1] == "/") {
                    op = Float.parseFloat(operations[0]) / Float.parseFloat(operations[2]);
                    result = op;
                }
            }
            num++;
        }
        return information;
    }
}