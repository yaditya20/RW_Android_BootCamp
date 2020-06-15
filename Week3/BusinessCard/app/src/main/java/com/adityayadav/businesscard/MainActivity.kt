package com.adityayadav.businesscard

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    internal lateinit var bookTextView: TextView
    internal lateinit var changeBookButton: Button

    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val BOOK_KEY = "BOOK_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookTextView = findViewById(R.id.bookTextView)
        changeBookButton = findViewById(R.id.changeBookButton)

        changeBookButton.setOnClickListener { view ->
            getRandomBook()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.actionAbout) {
            showInfo()
        }
        return true
    }

    private fun showInfo() {
        val dialogTitle = getString(R.string.aboutTitle, BuildConfig.VERSION_NAME)
        val dialogMessage = getString(R.string.aboutMessage)

        val builder = AlertDialog.Builder(this)
        builder.setTitle(dialogTitle)
        builder.setMessage(dialogMessage)
        builder.create().show()
    }

    private fun getRandomBook() {
        val res = resources
        val books = res.getStringArray(R.array.my_books)
        val randomBook = Random.nextInt(books.size)
        bookTextView.text = getString(R.string.myFavBook, books[randomBook])
    }
}