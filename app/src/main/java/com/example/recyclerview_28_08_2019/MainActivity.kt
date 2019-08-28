package com.example.recyclerview_28_08_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val json = readJSONFromAsset()


        val type = object : TypeToken<List<Book>>() {}.type
        val books = Gson().fromJson<List<Book>>(json, type)

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
