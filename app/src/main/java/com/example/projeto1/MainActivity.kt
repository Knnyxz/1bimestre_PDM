package com.example.projeto1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val lblCalculo = findViewById<TextView>(R.id.lblCalculo)
        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        /* metodo calcular imc */
        btnCalcular.setOnClickListener {
            val peso = edtPeso.text.toString().toDoubleOrNull()
            val altura = edtAltura.text.toString().toDoubleOrNull()

            if (peso != null && altura != null) {
                var imc: Double? = peso / (altura * altura)
                val imcFormatado = String.format("%.2f", imc)
                if ((imc ?: 0.0) <= 18.5) {
                    lblCalculo.text = "IMC: "+ imcFormatado +"\nAbaixo do Peso"
                } else if (((imc ?: 0.0) >= 18.50) && ((imc ?: 0.0) <= 24.9)) {
                    lblCalculo.text = "IMC: "+ imcFormatado +"\nPeso Normal"
                } else if (((imc ?: 0.0) >= 25) && ((imc ?: 0.0) <= 29.9)) {
                    lblCalculo.text = "IMC: "+ imcFormatado +"\nSobrepeso"
                } else if (((imc ?: 0.0) >= 30) && ((imc ?: 0.0) <= 34.9)) {
                    lblCalculo.text = "IMC: "+ imcFormatado +"\nObesidade I"
                } else if (((imc ?: 0.0) >= 35) && ((imc ?: 0.0) <= 39.9)) {
                    lblCalculo.text = "IMC: "+ imcFormatado +"\nObesidade II"
                } else if ((imc ?: 0.0) >= 40) {
                    lblCalculo.text = "IMC: Obesidade III"
                } else {
                    lblCalculo.text = "Coloque Valores acima de 0"
                }

            }


        }
    }
}