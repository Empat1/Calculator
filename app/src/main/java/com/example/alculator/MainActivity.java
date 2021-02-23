package com.example.alculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button0 , button1 , button2, button3,button4,button5 , button6 , button7, button8 , button9;
    Button buttonAllDel, buttonDel, buttonEE , buttonPlus, buttonMinus,buttonDivide,buttonEqually,buttonComma,buttonChange , buttonMultiply;
    TextView textView;
    double numBuffer=0.0;
    int operations;
    String s="";
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
        if("Деление на 0".equals(s)) s="";
        if(s.equals("0")) s="";

        switch (view.getId()){
            case R.id.button0:
                s+="0";
                break;
            case R.id.button1:
                s+="1";
                break;
            case R.id.button2:
                s+="2";
                break;
            case R.id.button3:
                s+="3";
                break;
            case R.id.button4:
                s+="4";
                break;
            case R.id.button5:
                s+="5";
                break;
            case R.id.button6:
                s+="6";
                break;
            case R.id.button7:
                s+="7";
                break;
            case R.id.button8:
                s+="8";
                break;
            case R.id.button9:
                s+="9";
                break;
            case R.id.buttonComma:
                if(s.equals("")) s+="0";
                if(s.indexOf(',')==-1) s+=",";
                break;
            case R.id.buttonDel:
                if(!s.equals("")) s = s.substring(0 , s.length()-1);
                break;
            case R.id.buttonAllDel:
                s="";
                numBuffer=0;
                break;
            case R.id.buttonPlus:
                numBuffer=strToDouble(s);
                operations=1;
                s="";
                break;
            case R.id.buttonMinus:
                numBuffer= strToDouble(s);
                operations=2;
                s="";
                break;
            case R.id.buttonMultiply:
                numBuffer= strToDouble(s);
                operations=3;
                s="";
                break;
            case R.id.buttonDivide:
                numBuffer= strToDouble(s);
                operations=4;
                s="";
                break;
            case R.id.buttonEqually:
                s = couting(s);
                break;
            case R.id.buttonChange:


        }
        textView.setText(s);
    }

    private Double strToDouble(String s){
        if(s.equals("")) return 0.0;
        if(s.substring(s.length()-1 , s.length()) == ",") s+="0";
        return Double.parseDouble(s.replace(',' , '.'));
    }

    private String couting(String s){
        double num = strToDouble(s);
        Log.d("MainActicity",num + " " + numBuffer + " операция " + operations );
        switch (operations){
            case 1:
                return String.valueOf(numBuffer+num);
            case 2:
                return String.valueOf(numBuffer-num);
            case 3:
                return String.valueOf(numBuffer*num);
            case 4:
                if(num==0) return "Деление на 0";
                return String.valueOf(numBuffer/num);
        }

        return "";
    }

    private String inputDisplay(){
        return textView.getText().toString();
    }

    private void outputDisplay(String s){
        if(s.length() < 10) {
            textView.setText(s);
        }
    }


}