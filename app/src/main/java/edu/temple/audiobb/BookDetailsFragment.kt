package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import android.view.View
import android.view.ViewGroup
import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.net.URL
import android.util.Log

class BookDetailsFragment : Fragment() {

    lateinit var name: TextView
    lateinit var author: TextView
    lateinit var layout: View
    lateinit var cover: ImageView

    companion object {

        @JvmStatic
        fun newInstance() = BookDetailsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    private fun updateLabels() {
        val book = ViewModelProvider(requireActivity())
            .get(BookView::class.java)
            .getSelectedBook()

        name.text = book.value?.title
        author.text = book.value?.author

        if (book.value == null || book.value?.coverURL.isNullOrEmpty()) {
            Log.d("Image", "waiting for image")
        } else {
            Picasso.get().load(book.value?.coverURL).into(cover)
        }
    }


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        layout = inflater.inflate(R.layout.fragment_book_details, container, false)
        return layout
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        name = layout.findViewById(R.id.titleText)
        author = layout.findViewById(R.id.authortext)
        cover = layout.findViewById(R.id.coverView)

        ViewModelProvider(requireActivity())

            .get(BookView::class.java)
            .getSelectedBook()
            .observe(viewLifecycleOwner, {updateLabels()})

    }




}









}