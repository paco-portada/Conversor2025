package com.example.conversor2025

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conversor2025.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit private var binding: ActivityMainBinding
    val RATIO = 0.9 // cambio de dólares a euros

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        // setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view: View = binding.root
        setContentView(binding.root)

        //botón convertir en activity_main.xml
        binding.convertir.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view === binding.convertir) {
            try {
                if (binding.eurosADolares.isChecked) {
                    binding.dolares.setText(
                        Conversion.convertirADolares(binding.euros.text.toString(), RATIO)
                    )
                } else {
                    binding.euros.setText(
                        Conversion.convertirAEuros(binding.dolares.text.toString(), RATIO)
                    )
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Error en la conversión: " + e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}