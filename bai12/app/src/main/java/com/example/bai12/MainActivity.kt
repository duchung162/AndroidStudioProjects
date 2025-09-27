package com.example.bai12


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EquationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equation)

        val etA = findViewById<EditText>(R.id.etA)
        val etB = findViewById<EditText>(R.id.etB)
        val etC = findViewById<EditText>(R.id.etC)
        val btnSolve = findViewById<Button>(R.id.btnSolve)
        val tvSolution = findViewById<TextView>(R.id.tvSolution)

        btnSolve.setOnClickListener {
            try {
                val a = etA.text.toString().toDouble()
                val b = etB.text.toString().toDouble()
                val c = etC.text.toString().toDouble()

                if (a == 0.0) {
                    // Phương trình bậc nhất
                    val x = -c / b
                    tvSolution.text = "Nghiệm: x = ${String.format("%.2f", x)}"
                } else {
                    val delta = b * b - 4 * a * c
                    when {
                        delta < 0 -> tvSolution.text = "Phương trình vô nghiệm"
                        delta == 0.0 -> {
                            val x = -b / (2 * a)
                            tvSolution.text = "Nghiệm kép: x = ${String.format("%.2f", x)}"
                        }
                        else -> {
                            val x1 = (-b + sqrt(delta)) / (2 * a)
                            val x2 = (-b - sqrt(delta)) / (2 * a)
                            tvSolution.text = "Nghiệm: x1 = ${String.format("%.2f", x1)}, x2 = ${String.format("%.2f", x2)}"
                        }
                    }
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Nhập hệ số hợp lệ!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}