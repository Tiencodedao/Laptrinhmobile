package com.example.laptrinhmobile

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
class Lab2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2)

        val inputNumber = findViewById<EditText>(R.id.inputNumber)
        val btnCreate = findViewById<Button>(R.id.btnCreate)
        val listContainer = findViewById<LinearLayout>(R.id.listContainer)
        val tvError = findViewById<TextView>(R.id.tvError)

        btnCreate.setOnClickListener {
            listContainer.removeAllViews()
            tvError.visibility = TextView.GONE

            val input = inputNumber.text.toString()

            if (input.isEmpty()) {
                tvError.text = "Bạn chưa nhập dữ liệu!"
                tvError.visibility = TextView.VISIBLE
                return@setOnClickListener
            }

            try {
                val n = input.toInt()
                if (n <= 0) {
                    tvError.text = "Vui lòng nhập số lớn hơn 0"
                    tvError.visibility = TextView.VISIBLE
                } else {
                    for (i in 1..n) {
                        val btn = Button(this)
                        btn.text = "$i"
                        btn.textSize = 18f
                        btn.setTextColor(resources.getColor(android.R.color.white))
                        btn.setBackgroundResource(R.drawable.red_textview_background)

                        val params = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        params.setMargins(0, 12, 0, 12)
                        btn.layoutParams = params
                        btn.setPadding(0, 24, 0, 24)

                        listContainer.addView(btn)
                    }
                }
            } catch (e: NumberFormatException) {
                tvError.text = "Dữ liệu bạn nhập không hợp lệ"
                tvError.visibility = TextView.VISIBLE
            }
        }
    }

}