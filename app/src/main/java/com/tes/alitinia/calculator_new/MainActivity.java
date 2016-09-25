package com.tes.alitinia.calculator_new;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private static final String TAG = "MainActivity";

    private EditText editText;
    private Button buttonX2, buttonCC;
    private ViewGroup rootView;
    private String[] opList = {"+", "-", "=", "/", "*", "r", "^"};
    private String buttonString;
    private double tmpRes = 0;
    private String currentOp = null;
    //private EditText etNum1;
    //private EditText etNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Button buttonsqroot = (Button) findViewById(R.id.buttonsqroot);
      //  buttonsqroot.setText(Html.fromHtml("x<sup>2</sup>"));
        editText = (EditText) findViewById(R.id.editText);
        editText.setText("0");
        Button buttonCC = (Button) findViewById(R.id.buttonCC);
        buttonCC.setOnClickListener(this);
        rootView = (ViewGroup) findViewById(R.id.rootView);
        setupAllListeners(rootView);


    }

    private void setupAllListeners(ViewGroup rootView) {
        int numChild = rootView.getChildCount();
        //Log.v(TAG, "child number
        for (int i = 0; i < numChild; i++) {
            View view = rootView.getChildAt(i);
            if (view instanceof ViewGroup) {
                setupAllListeners((ViewGroup) view);
            } else if (view instanceof Button) {
                Button button = (Button) view;
                button.setOnClickListener(this);
            }
            //Log.v(TAG,"View id: "+ view.getId());
        }
    }

    public void displayResult(View view) {
        editText.setText("Result");
    }

    @Override
    public void onClick(View v) {
        char[] txt = editText.getText().toString().toCharArray(); //buat cek texbox
        switch (v.getId()) {
            case R.id.buttonCC:
                editText.setText("0");
                break;
            case R.id.buttonmult:
                if (currentOp == null) {
                    tmpRes = Double.parseDouble(editText.getText().toString());
                    currentOp = "*";
                    editText.setText("0");
                } else if (currentOp != "*") {
                    currentOp = "*";
                }
                    break;
            case R.id.buttonadd:
                if (currentOp == null) {
                    tmpRes = Double.parseDouble(editText.getText().toString());
                    currentOp = "+";
                    editText.setText("0");
                } else if (currentOp != "+") {
                    currentOp = "+";
                } else {
                    //nothing
                }
                break;
            case R.id.buttondiv:
                if (currentOp == null) {
                    tmpRes = Double.parseDouble(editText.getText().toString());
                    currentOp = "/";
                    editText.setText("0");
                } else if (currentOp != "/") {
                    currentOp = "/";
                }
                break;
            case R.id.buttonsub:
                if (currentOp == null) {
                    tmpRes = Double.parseDouble(editText.getText().toString());
                    currentOp = "-";
                    editText.setText("0");
                } else if (currentOp != "-") {
                    currentOp = "-";
                }
                break;
            case R.id.buttonpow:
                if (currentOp == null) {
                    tmpRes = Double.parseDouble(editText.getText().toString());
                    currentOp = "^";
                //    editText.setText("0");
                } else if (currentOp != "^") {
                    currentOp = "^";
                } hitungOperasi();
                break;
            case R.id.buttonsqroot:
                if (currentOp == null) {
                    tmpRes = Double.parseDouble(editText.getText().toString());
                    currentOp = "sqroot";
                 //   editText.setText("0");
                } else if (currentOp != "sqroot") {
                    currentOp = "sqroot";
                } hitungOperasi();
                break;
            case R.id.buttonequal:
                if (currentOp != null) {
                    hitungOperasi();
                }
                break;
            default:
                Button button = (Button) v;
                buttonString = button.getText().toString(); // 6
                if (txt[0] == '0') {
                    editText.setText(buttonString);
                } else {
                    editText.setText(editText.getText().toString() + buttonString); //16
                }
                Log.v(TAG, "Log All");
                break;
        }
    }


    public void hitungOperasi() {
        double tmp = Double.parseDouble(editText.getText().toString()); //a op b ini a, tmpRes b
        switch (currentOp) {
            case "+":
                tmp = tmp + tmpRes;
                currentOp = null;
                editText.setText(String.valueOf(tmp));
                break;
            case "-":
                tmp = tmp - tmpRes;
                currentOp = null;
                editText.setText(String.valueOf(tmp));
                break;
            case "*":
                tmp = tmp * tmpRes;
                currentOp = null;
                editText.setText(String.valueOf(tmp));
                break;
            case "/":
                tmp = tmp / tmpRes;
                currentOp = null;
                editText.setText(String.valueOf(tmp));
                break;
            case "^":
                tmp = Math.pow(tmp, 2);
                currentOp = null;
                editText.setText(String.valueOf(tmp));
                break;
            case "sqroot":
                tmp = Math.sqrt(tmp);
                currentOp = null;
                editText.setText(String.valueOf(tmp));
                break;
        }
    }
}


