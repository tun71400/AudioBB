package edu.temple.audiobb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView




class BookConverter(private val items: BookList, private val listener: (Book)-> Unit) :
    RecyclerView.Adapter<BookConverter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookConverter.ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val bookView = inflater.inflate(R.layout.recycler_view_layout,parent,false)

        return ViewHolder(bookView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]

        holder.bind(item!!)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount(): Int {
        return items.size()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name = itemView.findViewById<TextView>(R.id.rcvAuthorView)
        private val title =itemView.findViewById<TextView>(R.id.rcvTitleView)
        private val image = itemView.findViewById<ImageView>(R.id.image)

        fun bind(item: Book) {
            name.text = item.author
            title.text = item.title

        }

    }

}
