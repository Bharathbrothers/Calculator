package com.starks.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView screen;
    private String str;
    private String str2;
    private String result;
    private String sign;
    private Double a,b,c,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen=(TextView)findViewById(R.id.Textview);
        str="";
        /*Toast.makeText("Calculator",Toast.LENGTH_SHORT,Toast.LENGTH_LONG).show();*/
    }
    public void onClick(View v)
    {
        Button button = (Button) v;
        str +=button.getText().toString();
        screen.setText(str);
        a= Double.parseDouble(str);
    }

    public void onClicksigns(View v)
    {
        Button button = (Button) v;
        sign=button.getText().toString();
        screen.setText(sign);
        str="";
        d=a;
    }
    public void calcuate(View v)
    {

        str2 = screen.getText().toString();
        b= Double.parseDouble(str2);

        switch (sign)
        {
            case "+":
                        c=d+b;
                        result=c+"";
                        break;
            case "-":
                        c=d-b;
                        result=c+"";
                        break;
            case "*":
                        c=d*b;
                        result=c+"";
                        break;
            case "/":
                        c=d/b;
                        result=c+"";
                        break;
            case "^":
                        c=Math.pow(d,b);
                        result=c+"";
                        break;
        }
        screen.setText(result);
    }
    public void clear(View v){
        str="";
        d=a;
        screen.setText(str);
    }
    public void root( View v){
        Button button = (Button) v;
        sign=button.getText().toString();
        screen.setText(sign);
        str="";
        d=a;
        c=Math.sqrt(d);
        result=c+"";
        screen.setText(result);
    }

    public void backspace(View v){
        Button button = (Button) v;
        str= screen.getText().toString();
        if(str.length()>1)
        {
            str=str.substring(0,str.length()-1);
            screen.setText(str);
        }
        else{
            screen.setText("0");
        }

    }
    public void Decimal(View v)
    {
        Button button = (Button) v;
        str =button.getText().toString();
        str2=screen.getText().toString();
        //screen.setText(str);
        String str3=str2.substring((str2.length()-2),(str2.length()-1));
        if(str2.length()==0)
        {
            screen.setText(".");
        }
        else if(str3.equals("."))
        {
            str=str2.substring(0,(str.length()-1));
            screen.setText(str);
        }
        else if(str2.length()>1)
        {
            screen.setText(str);
        }
        else{
            screen.setText(str);
        }

    }

}
