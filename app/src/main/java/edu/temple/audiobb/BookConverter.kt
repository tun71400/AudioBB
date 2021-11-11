package edu.temple.audiobb

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View



class BookConverter(_context: Context, _books: BookList, _vocl: View.OnClickListener) : RecyclerView.Adapter<BookConverter.ViewHolder>() {

    private val context = _context
    private val books = _books

    private val vocl = _vocl
    private val inflater = LayoutInflater.from(context)


    class ViewHolder(_view: View) : RecyclerView.ViewHolder(_view) {

        val view = _view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = inflater.inflate(R.layout.fragment_book_list, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val titleLabel = holder.view.findViewById<TextView>(R.id.authortext)
        titleLabel.setText(books.get(position).title)
        val authorLabel = holder.view.findViewById<TextView>(R.id.authortext)
        authorLabel.setText(books.get(position).author)

        holder.view.setOnClickListener(vocl)
    }

    override fun getItemCount(): Int {

        return books.size()
    }


}

