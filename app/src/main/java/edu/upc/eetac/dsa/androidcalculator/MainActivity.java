package edu.upc.eetac.dsa.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int start = 1, pos = 0, num = 0, firstDigit = 1, posInitial = 1, sctMode = 0, sMode = 0, cMode = 0, tMode = 0, DR = 0;
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
        Button btn_dr = (Button) findViewById(R.id.button_decrad);



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

                start = 1;
                posInitial = 1;
                firstDigit = 1;
                sctMode = 0; sMode = 0; cMode = 0; tMode = 0;

                btn_sum.setEnabled(true); btn_sub.setEnabled(true); btn_mul.setEnabled(true);
                btn_div.setEnabled(true); btn_sin.setEnabled(true); btn_cos.setEnabled(true);
                btn_tan.setEnabled(true); btn_dr.setVisibility(View.INVISIBLE);
            }
        });

        btn_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(UpdateText(textResult.getText().toString(), "."));
            }
        });

        btn_equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(textPreview.getText() + "  ");
                textPreview.setText("");

                start = 1;
                posInitial = 1;
                firstDigit = 1;
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

                if(sctMode == 0) {

                    btn_sum.setEnabled(false); btn_sub.setEnabled(false); btn_mul.setEnabled(false);
                    btn_div.setEnabled(false); btn_cos.setEnabled(false); btn_tan.setEnabled(false);

                    sctMode = 1; sMode = 1; btn_dr.setVisibility(View.VISIBLE);

                    textResult.setText(UpdateText(textResult.getText().toString(), "sin("));
                    textPreview.setText("= " + result);
                }
                else {
                    btn_sum.setEnabled(true); btn_sub.setEnabled(true); btn_mul.setEnabled(true);
                    btn_div.setEnabled(true); btn_cos.setEnabled(true); btn_tan.setEnabled(true);

                    textResult.setText("0  ");
                    textPreview.setText("");

                    start = 1;
                    posInitial = 1;
                    firstDigit = 1;
                    sctMode = 0; sMode = 0; btn_dr.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sctMode == 0) {

                    btn_sum.setEnabled(false); btn_sub.setEnabled(false); btn_mul.setEnabled(false);
                    btn_div.setEnabled(false); btn_sin.setEnabled(false); btn_tan.setEnabled(false);

                    sctMode = 1; cMode = 1; btn_dr.setVisibility(View.VISIBLE);

                    textResult.setText(UpdateText(textResult.getText().toString(), "cos("));
                    textPreview.setText("= " + result);
                }
                else {
                    btn_sum.setEnabled(true); btn_sub.setEnabled(true); btn_mul.setEnabled(true);
                    btn_div.setEnabled(true); btn_sin.setEnabled(true); btn_tan.setEnabled(true);

                    textResult.setText("0  ");
                    textPreview.setText("");

                    start = 1;
                    posInitial = 1;
                    firstDigit = 1;
                    sctMode = 0; cMode = 0; btn_dr.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sctMode == 0) {

                    btn_sum.setEnabled(false); btn_sub.setEnabled(false); btn_mul.setEnabled(false);
                    btn_div.setEnabled(false); btn_sin.setEnabled(false); btn_cos.setEnabled(false);

                    sctMode = 1; tMode = 1; btn_dr.setVisibility(View.VISIBLE);

                    textResult.setText(UpdateText(textResult.getText().toString(), "tan("));
                    textPreview.setText("= " + result);
                }
                else {
                    btn_sum.setEnabled(true); btn_sub.setEnabled(true); btn_mul.setEnabled(true);
                    btn_div.setEnabled(true); btn_sin.setEnabled(true); btn_cos.setEnabled(true);

                    textResult.setText("0  ");
                    textPreview.setText("");

                    start = 1;
                    posInitial = 1;
                    firstDigit = 1;
                    sctMode = 0; tMode = 0; btn_dr.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn_dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(DR == 1) { DR = 0; }
                else { DR = 1; }
            }
        });
    }

    public String UpdateText(String information, String digit) {
        float op;

        if (start == 1) {

            information = "";
            start = 0;
        }

        if (num < 24) {

            information = information.replace("  ", "");
            information = information + digit + "  ";

            if(sctMode == 0) {

                if ((digit == "+") || (digit == "-") || (digit == "×") || (digit == "/")) {

                    firstDigit = 1;
                    operations[1] = digit;

                    if (posInitial == 1) {

                        posInitial = 0;
                    } else {
                        operations[0] = Float.toString(result);
                    }
                } else if (posInitial == 1) {

                    if (firstDigit == 1) {

                        operations[0] = digit;
                        result = Float.parseFloat(operations[0]);
                        firstDigit = 0;
                    } else {
                        operations[0] = operations[0] + digit;
                        result = Float.parseFloat(operations[0]);
                    }
                } else if (posInitial == 0) {

                    if (firstDigit == 1) {

                        operations[2] = digit;
                        firstDigit = 0;
                    }
                    else {
                        operations[2] = operations[2] + digit;
                    }

                    /// Calculating ///

                    if (operations[1] == "+") {

                        op = Float.parseFloat(operations[0]) + Float.parseFloat(operations[2]);
                        result = op;
                    } else if (operations[1] == "-") {

                        op = Float.parseFloat(operations[0]) - Float.parseFloat(operations[2]);
                        result = op;
                    } else if (operations[1] == "×") {

                        op = Float.parseFloat(operations[0]) * Float.parseFloat(operations[2]);
                        result = op;
                    } else if (operations[1] == "/") {

                        op = Float.parseFloat(operations[0]) / Float.parseFloat(operations[2]);
                        result = op;
                    }
                }
            }

            else {

                if(posInitial == 1)
                {
                    operations[0] = digit;
                    posInitial = 0;
                }
                else {
                    if (firstDigit == 1) {

                        operations[1] = digit;
                        firstDigit = 0;
                    }
                    else {
                        operations[1] = operations[1] + digit;
                    }

                    if(sMode == 1) {

                        if(DR == 1) {
                            op = (float) Math.toRadians(Math.sin(Double.parseDouble(operations[1])));
                        }
                        else {
                            op = (float) Math.tan(Double.parseDouble(operations[1]));
                        }
                        result = op;
                    }

                    if(cMode == 1) {

                        if(DR == 1) {
                            op = (float) Math.toRadians(Math.cos(Double.parseDouble(operations[1])));
                        }
                        else {
                            op = (float) Math.tan(Double.parseDouble(operations[1]));
                        }
                        result = op;
                    }

                    if(tMode == 1) {

                        if(DR == 1) {
                            op = (float) Math.toRadians(Math.tan(Double.parseDouble(operations[1])));
                        }
                        else {
                            op = (float) Math.tan(Double.parseDouble(operations[1]));
                        }
                        result = op;
                    }
                }
            }
            num++;
        }
        return information;
    }
}