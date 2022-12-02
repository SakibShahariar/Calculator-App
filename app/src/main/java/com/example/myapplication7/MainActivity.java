package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;



public class MainActivity extends AppCompatActivity {


    private MaterialButton btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0;
    private MaterialButton btn_dot,btn_plus,btn_ac,btn_divide,btn_minus,btn_multiplication, btn_equal, btn_op, btn_cl, btn_c;
    private TextView inputText,outputText;
    private String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText= findViewById(R.id.input_Text);
        outputText= findViewById(R.id.Output_Text);

        btn_0= findViewById(R.id.btn_0);
        btn_1= findViewById(R.id.btn_1);
        btn_2= findViewById(R.id.btn_2);
        btn_3= findViewById(R.id.btn_3);
        btn_4= findViewById(R.id.btn_4);
        btn_5= findViewById(R.id.btn_5);
        btn_6= findViewById(R.id.btn_6);
        btn_7= findViewById(R.id.btn_7);
        btn_8= findViewById(R.id.btn_8);
        btn_9= findViewById(R.id.btn_9);

        btn_ac= findViewById(R.id.btn_ac);
        btn_op= findViewById(R.id.btn_op);
        btn_c= findViewById(R.id.btn_c);
        btn_cl= findViewById(R.id.btn_cl);
        btn_dot= findViewById(R.id.btn_dot);
        btn_plus= findViewById(R.id.btn_plus);
        btn_equal= findViewById(R.id.btn_equal);
        btn_minus= findViewById(R.id.btn_minus);
        btn_divide = findViewById(R.id.btn_divide);
        btn_multiplication= findViewById(R.id.btn_multiplication);

        btn_0.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"0");
        });

        btn_1.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"1");
        });

        btn_2.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"2");
        });

        btn_3.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"3");
        });

        btn_4.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"4");
        });

        btn_5.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"5");
        });

        btn_6.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"6");
        });

        btn_7.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"7");
        });

        btn_8.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"8");
        });

        btn_9.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"9");
        });

        btn_dot.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+".");
        });

        btn_op.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"(");
        });

        btn_cl.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+")");
        });

        btn_c.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data.substring(0, data.length() - 1));
        });



        btn_ac.setOnClickListener(view -> {
            inputText.setText("");
            outputText.setText("");
        });

        btn_plus.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"+");
        });

        btn_minus.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"-");
        });

        btn_multiplication.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"×");
        });

        btn_divide.setOnClickListener(view -> {
            data=inputText.getText().toString();
            inputText.setText(data+"/");
        });

        btn_equal.setOnClickListener(view -> {
            data = inputText.getText().toString();

            data=data.replaceAll("×","*");
            data=data.replaceAll("÷","/");

            String conv = data;

            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initStandardObjects();
            String finalResult=context.evaluateString(scriptable,data,"Javascript",1,null).toString();


            String TAG = "MyActivity";

//                Integer x = Integer.valueOf(finalResult);
//                Double y = Double.valueOf(finalResult);

            //Log.i(TAG, "MyClass.getView() — get item number " + x.toString() + y.toString());

            Integer i, j;
            i = finalResult.indexOf(".");
            j = finalResult.length() - i - 1;

            if(finalResult.substring(finalResult.length() - 2, finalResult.length()).equals(".0")){
                finalResult = finalResult.substring(0, finalResult.length() - 2);
            }
            else{
                if(j > 4)
                    finalResult = finalResult.substring(0, i + 5);
            }


            Log.i(TAG, "MyClass.getView() — get item number " + inputText.getText().toString());


            outputText.setText(finalResult);
        });

    }
}