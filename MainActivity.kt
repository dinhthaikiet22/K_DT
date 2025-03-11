package com.example.libraryapp

import com.example.libraryapp.AddBookActivity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.model.Book
import com.example.libraryapp.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var bookListView: ListView
    private lateinit var btnAddBook: Button
    private val bookList = mutableListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookListView = findViewById(R.id.bookListView)
        btnAddBook = findViewById(R.id.btnAddBook)

        // Thêm sách mẫu
        bookList.add(Book("B001", "Lập trình Kotlin", "Nguyễn Văn A"))
        bookList.add(Book("B002", "Học Android Studio", "Trần Văn B"))
        bookList.add(Book("B003", "Cấu trúc dữ liệu & Giải thuật", "Lê Thị C"))

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, bookList.map { it.title })
        bookListView.adapter = adapter

        // Sự kiện khi nhấn vào sách
        bookListView.setOnItemClickListener { _, _, position, _ ->
            val selectedBook = bookList[position]
            Toast.makeText(this, "Bạn chọn: ${selectedBook.title}", Toast.LENGTH_SHORT).show()
        }

        // Chuyển sang màn hình thêm sách
        btnAddBook.setOnClickListener {
            val intent = Intent(this, AddBookActivity::class.java)
            startActivity(intent)
        }
    }
}
