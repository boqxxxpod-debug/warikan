package com.example.warikan

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val amountInput = findViewById<EditText>(R.id.amountInput)
        val peopleInput = findViewById<EditText>(R.id.peopleInput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        calculateButton.setOnClickListener {
            val amount = amountInput.text.toString().toDoubleOrNull()
            val people = peopleInput.text.toString().toIntOrNull()

            if (amount == null || amount < 0 || people == null || people <= 0) {
                resultText.text = "金額と人数を正しく入力してください"
                return@setOnClickListener
            }

            val perPerson = amount / people
            val formatter = NumberFormat.getCurrencyInstance(Locale.JAPAN)
            resultText.text = "1人あたり ${formatter.format(perPerson)}"
        }
    }
}
