package com.example.laptrinhmobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EX2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex2)

        // Khai báo các view
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvError = findViewById<TextView>(R.id.tvError)
        val tvSuccess = findViewById<TextView>(R.id.tvSuccess)


        // Xử lý sự kiện click button
        btnCheck.setOnClickListener {
            // Ẩn thông báo lỗi cũ
            tvError.visibility = TextView.GONE
            tvSuccess.visibility = TextView.GONE

            // Lấy email từ EditText
            val email = edtEmail.text.toString().trim()

            // Kiểm tra email rỗng hoặc null
            if (email.isEmpty()) {
                tvError.text = "Email không hợp lệ"
                tvError.visibility = TextView.VISIBLE
                return@setOnClickListener
            }

            // Kiểm tra email có chứa "@"
            if (!email.contains("@")) {
                tvError.text = "Email không đúng định dạng"
                tvError.visibility = TextView.VISIBLE
                return@setOnClickListener
            }
            else{
                tvSuccess.text = "Bạn đã nhập email hợp lệ"
                tvSuccess.visibility = TextView.VISIBLE
                return@setOnClickListener
            }

        }

    }

}
