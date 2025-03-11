package com.example.libraryapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.model.Book
import com.example.libraryapp.model.User

class BorrowActivity : AppCompatActivity() {
    private lateinit var edtUserId: EditText
    private lateinit var edtBookId: EditText
    private lateinit var btnBorrow: Button
    private val users = mutableListOf<User>()
    private val books = mutableListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrow)

        edtUserId = findViewById(R.id.edtUserId)
        edtBookId = findViewById(R.id.edtBookId)
        btnBorrow = findViewById(R.id.btnBorrow)

        users.add(User("U001", "Nguyễn Văn A"))
        users.add(User("U002", "Trần Văn B"))

        books.add(Book("B001", "Lập trình Kotlin", "Nguyễn Văn A"))
        books.add(Book("B002", "Học Android Studio", "Trần Văn B"))

        btnBorrow.setOnClickListener {
            val userId = edtUserId.text.toString()
            val bookId = edtBookId.text.toString()

            val user = users.find { it.id == userId }
            val book = books.find { it.id == bookId }

            if (user != null && book != null && book.isAvailable) {
                book.isAvailable = false
                user.borrowedBooks.add(book.id)
                Toast.makeText(this, "Mượn thành công: ${book.title}", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Mượn sách thất bại!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
