package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import android.widget.TextView

class BookDetailsFragment : Fragment() {

    lateinit var name: TextView
    lateinit var author: TextView
    lateinit var layout: View

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

        ViewModelProvider(requireActivity())

            .get(BookView::class.java)
            .getSelectedBook()
            .observe(viewLifecycleOwner, {updateLabels()})

    }


}