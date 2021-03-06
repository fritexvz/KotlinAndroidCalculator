package com.yogeshojha.calculator

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainLayout = findViewById(R.id.mainlinearlayout) as RelativeLayout
        val result = findViewById(R.id.textview_result) as TextView
        val button_add = findViewById(R.id.button_add) as Button
        val button_minus = findViewById(R.id.button_minus) as Button
        val button_multiply = findViewById(R.id.button_multiple) as Button
        val button_divide = findViewById(R.id.button_divide) as Button
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        button_add.setOnClickListener(View.OnClickListener {
            view -> result.text = if(getNum1().equals(-1) || getNum2().equals(-1))"Either of the values Cannot be empty" else (getNum1() + getNum2()).toString()
            //hide keyboard on button click
            imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
        })

        button_minus.setOnClickListener(View.OnClickListener {
            view -> result.text = if(getNum1().equals(-1) || getNum2().equals(-1))"Either of the values Cannot be empty" else (getNum1() - getNum2()).toString()
            //hide keyboard on button click
            imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
        })

        button_multiply.setOnClickListener(View.OnClickListener {
            view -> result.text = if(getNum1().equals(-1) || getNum2().equals(-1))"Either of the values Cannot be empty" else (getNum1() * getNum2()).toString()
            //hide keyboard on button click
            imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
        })
        button_divide.setOnClickListener(View.OnClickListener {
            view -> result.text = if(getNum1().equals(-1) || getNum2().equals(-1))"Either of the values Cannot be empty" else if(getNum2() == 0) "Error\nDivisible By Zero" else ((getNum1() / getNum2()).toString())
            //hide keyboard on button click
            imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);

        })

    }

    fun getNum1(): Int{
        val input_num1 = findViewById(R.id.edittext_num1) as EditText
        return if(input_num1.text.toString().equals("")) -1 else Integer.parseInt(input_num1.text.toString())
    }

    fun getNum2(): Int {
        val input_num2 = findViewById(R.id.edittext_num2) as EditText
        return if(input_num2.text.toString().equals("")) -1 else Integer.parseInt(input_num2.text.toString())
    }
}
