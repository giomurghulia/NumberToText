package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var number: EditText
    private lateinit var button: Button
    private lateinit var resultText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        number = findViewById(R.id.inputText)
        button = findViewById(R.id.submitButton)
        resultText = findViewById(R.id.resultText)

        button.setOnClickListener {
            val x = number.text.toString().toInt()
            if (x > 1000000) resultText.text = "შეიყვანეთ 1000001 ზე ნაკლები"
            else resultText.text = NumberInterpreter(x).readNumber()
        }
    }
}