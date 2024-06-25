package com.example.game3

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        generarNumeros()
    }

    private fun generarNumeros() {
        val numero1 = (0..9).random()
        val numero2 = (0..9).random()

        val btnIzquierdo = findViewById<Button>(R.id.btn_izquierdo)
        val btnDerecho = findViewById<Button>(R.id.btn_derecho)

        btnIzquierdo.text = numero1.toString()
        btnDerecho.text = numero2.toString()
        btnIzquierdo.setBackgroundColor(Color.LTGRAY)
        btnDerecho.setBackgroundColor(Color.LTGRAY)
        btnIzquierdo.isEnabled = true
        btnDerecho.isEnabled = true

    }

    fun validar_Izquierdo(view: View) {
        val btnIzquierdo = findViewById<Button>(R.id.btn_izquierdo)
        val btnDerecho = findViewById<Button>(R.id.btn_derecho)

        val numero1 = btnIzquierdo.text
        val numero2 = btnDerecho.text

        if (Integer.parseInt(numero1.toString()) > Integer.parseInt(numero2.toString())) {
            btnIzquierdo.setBackgroundColor(Color.GREEN)
        } else {
            btnIzquierdo.setBackgroundColor(Color.RED)
        }

        btnDerecho.isEnabled = false
    }

    fun validar_Derecho(view: View) {
        val btnIzquierdo = findViewById<Button>(R.id.btn_izquierdo)
        val btnDerecho = findViewById<Button>(R.id.btn_derecho)

        val numero1 = btnIzquierdo.text
        val numero2 = btnDerecho.text

        if (Integer.parseInt(numero2.toString()) > Integer.parseInt(numero1.toString())) {
            btnDerecho.setBackgroundColor(Color.GREEN)
        } else {
            btnDerecho.setBackgroundColor(Color.RED)
        }

        btnIzquierdo.isEnabled = false
    }

    fun reiniciarJuego(view: View) {
        generarNumeros()
    }
}
