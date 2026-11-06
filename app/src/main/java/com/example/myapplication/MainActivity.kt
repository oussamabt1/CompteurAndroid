
package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.graphics.Color
import android.widget.Toast

class MainActivity : Activity() {

    private var compteur = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val valeur = findViewById<TextView>(R.id.valeurCompteur)

        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMoins = findViewById<Button>(R.id.btnMoins)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnPlus5 = findViewById<Button>(R.id.btnPlus5)
        val btnMoins5 = findViewById<Button>(R.id.btnMoins5)
        if (savedInstanceState != null) {
            compteur = savedInstanceState.getInt("COMPTEUR")
            valeur.text = compteur.toString()
            changecouleur(valeur)
        }

        btnPlus.setOnClickListener {
            compteur++
            valeur.text = compteur.toString()
            changecouleur(valeur)
        }

        btnMoins.setOnClickListener {
            compteur--
            valeur.text = compteur.toString()
            changecouleur(valeur)
        }

        btnReset.setOnClickListener {
            compteur = 0
            valeur.text = compteur.toString()
            changecouleur(valeur)
            Toast.makeText(
                this,
                "Compteur réinitialisé",
                Toast.LENGTH_SHORT
            ).show()
        }
        btnPlus5.setOnClickListener {
            compteur += 5
            valeur.text = compteur.toString()
            changecouleur(valeur)
        }
        btnMoins5.setOnClickListener {
            compteur -= 5
            valeur.text = compteur.toString()
            changecouleur(valeur)
        }
    }

        private fun changecouleur(valeur: TextView) {
            when {
                compteur > 0 ->
                    valeur.setTextColor(Color.GREEN)

                compteur < 0 ->
                    valeur.setTextColor(Color.RED)

                else ->
                    valeur.setTextColor(Color.BLACK)
            }
        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COMPTEUR", compteur)
    }
    }
