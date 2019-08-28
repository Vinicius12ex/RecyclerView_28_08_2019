package com.example.recyclerview_28_08_2019

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BooksAdapter() : ListAdapter<Book, BooksAdapter.BookViewHolder>(BookDiffUtils()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book_layout, null)
        return BookViewHolder(view);
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class  BookViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val title : TextView=view.findViewById(R.id.title)
        private val page : TextView=view.findViewById(R.id.pages)
        private val description : TextView=view.findViewById(R.id.description)

        fun bind(book:Book){
            title.text = book.title
            page.text = book.pageCount.toString()
            description.text = book.shortDescription
        }
    }

    class BookDiffUtils: DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.title == newItem.title
        }

    }
}