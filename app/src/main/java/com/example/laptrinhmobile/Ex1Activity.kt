package com.example.laptrinhmobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ex1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex1)

        // Khai báo các view
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Xử lý sự kiện click button
        btnCheck.setOnClickListener {
            // Lấy dữ liệu từ EditText
            val name = edtName.text.toString().trim()
            val ageStr = edtAge.text.toString().trim()

            // Kiểm tra họ tên có rỗng không
            if (name.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập họ và tên", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Kiểm tra tuổi có rỗng không
            if (ageStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập tuổi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Chuyển đổi tuổi sang số
            try {
                val age = ageStr.toInt()

                // Kiểm tra tuổi hợp lệ
                if (age < 0) {
                    Toast.makeText(this, "Tuổi không hợp lệ", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Xác định nhóm tuổi
                val category = when {
                    age < 2 -> "em bé"
                    age in 2..6 -> "trẻ em"
                    age in 7..65 -> "người lớn"
                    else -> "người già"
                }

                // Hiển thị kết quả
                tvResult.text = "$name là $category"
                tvResult.visibility = TextView.VISIBLE

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Tuổi phải là số", Toast.LENGTH_SHORT).show()
            }
        }
    }
}