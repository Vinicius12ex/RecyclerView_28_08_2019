package com.example.recyclerview_28_08_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val json = readJSONFromAsset()


    val type = object : TypeToken<List<Book>>() {}.type
    val books = Gson().fromJson<List<Book>>(json, type)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        val adapter = BooksAdapter()
        recyclerview.adapter = adapter
        adapter.submitList(books)

    }

    private fun readJSONFromAsset(): String? {
        var json: String?
        try {
            val  inputStream: InputStream = assets.open("books.json")
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}
