package com.example.alculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonAllDel, buttonDel, buttonEE, buttonPlus, buttonMinus, buttonDivide, buttonEqually, buttonComma, buttonChange, buttonMultiply;
    TextView textView;
    double num1 = 0.0, num2 = 0.0;
    char operation = '0';
    String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        buttonAllDel = findViewById(R.id.buttonAllDel);
        buttonDel = findViewById(R.id.buttonDel);
        buttonEE = findViewById(R.id.buttonEE);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonEqually = findViewById(R.id.buttonEqually);
        buttonComma = findViewById(R.id.buttonComma);
        buttonChange = findViewById(R.id.buttonChange);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        buttonAllDel.setOnClickListener(this);
        buttonDel.setOnClickListener(this);
        buttonEE.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonEqually.setOnClickListener(this);
        buttonComma.setOnClickListener(this);
        buttonChange.setOnClickListener(this);


    }

    @Override
    public void onClick(View view){

        s = textView.getText().toString();
        if(s.equals("0")) s="";

        switch (view.getId()){
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
                s += ((Button) view).getText();
                break;
            case R.id.buttonComma:
                if (s.indexOf(',') == -1) s += ",";
                break;
            case R.id.buttonDel:
                if (!s.equals("")) s = s.substring(0, s.length() - 1);
                break;
            case R.id.buttonAllDel:
                s = "";
                num1 = 0;
                num2 = 0;
                break;
            case R.id.buttonPlus:
            case R.id.buttonMinus:
            case R.id.buttonMultiply:
            case R.id.buttonDivide:
                operation = ((Button) view).getText().charAt(0);
                num1 = strToDouble(textView.getText().toString());
                s = "";
                break;
            case R.id.buttonEqually:
                num2 = strToDouble(textView.getText().toString());
                s = couint(num1, num2, operation);
                break;
        }
        if (s.equals("")) s += "0";
        textView.setText(s);
    }

    private String couint(double num1, double num2, char operations) {
        if (operations == '+') {
            return String.valueOf(num1 + num2);
        } else if (operations == '-') {
            return String.valueOf(num1 - num2);
        } else if (operations == '*') {
            return String.valueOf(num1 * num2);
        } else if (operations == '/') {
            if (num2 == 0) {
                show();
                return "0";
            }
            return String.valueOf(num1 / num2);
        }
        return "0";
    }

    private Double strToDouble(String s) {
        if (s.equals("")) return 0.0;
        if (s.substring(s.length() - 1, s.length()) == ",") s += "0";
        return Double.parseDouble(s.replace(',', '.'));
    }

    private void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Ошибка!")
                .setMessage("Деление на 0!")
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }


}