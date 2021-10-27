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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_book_details, container, false)
        return layout
    }
}