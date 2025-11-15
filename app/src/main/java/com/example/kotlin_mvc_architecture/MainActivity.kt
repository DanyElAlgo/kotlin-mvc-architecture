package com.example.kotlin_mvc_architecture

import CounterModel
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.LinearLayout.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT

class MainActivity : AppCompatActivity() {

    // CONTROLADOR
    private val counterModel = CounterModel()

    // VISTA
    private lateinit var tvCount: TextView
    private lateinit var btnIncrement: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // VISTA
        val rootLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
            setPadding(50, 50, 50, 50)
        }

        tvCount = TextView(this).apply {
            layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                bottomMargin = 50
            }
            textSize = 24f
        }

        btnIncrement = Button(this).apply {
            layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            text = "Incrementar Contador"
        }

        rootLayout.addView(tvCount)
        rootLayout.addView(btnIncrement)

        setContentView(rootLayout)

        updateView()

        btnIncrement.setOnClickListener {
            handleIncrementClick()
        }
    }

    // Solicitud al controlador por parte del usuario
    private fun handleIncrementClick() {
        // Solicitud al modelo mediante el controlador
        counterModel.increment()

        // Solicitud a la vista mediante el controlador
        updateView()
    }

    // Actualización de la vista
    @SuppressLint("SetTextI18n")
    private fun updateView() {
//        val currentCount = counterModel.getCount()
//        tvCount.text = "Contador: $currentCount"
        tvCount.text = "Contador: ${counterModel.getCount()}"
    }
}