package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception
import java.lang.reflect.Executable

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
            try {
                val x = number.text.toString().toInt()
                if (x > 1000000) resultText.text = "შეიყვანეთ მილიონზე ნაკლები"
                else resultText.text = NumberInterpreter(x).readNumber()

            } catch (e: Exception) {
                resultText.text = "შეიყვანეთ მილიონზე ნაკლები"
            }
        }
    }
}