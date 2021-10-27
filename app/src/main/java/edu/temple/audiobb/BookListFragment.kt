package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.GridLayoutManager
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider


class BookListFragment : Fragment() {

    lateinit var bookList: BookList
    lateinit var layout: View
    lateinit var bookListView: RecyclerView

    companion object {
        @JvmStatic
        fun newInstance(_bookList: BookList): BookListFragment {

            val frag = BookListFragment().apply {
                bookList = _bookList
                arguments = Bundle().apply {
                    putSerializable("bookList", bookList)
                }
            }
            return frag
        }
    }

    interface DoubleLayout {
        fun selectionMade()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            bookList = it.getSerializable("bookList") as BookList
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_book_list, container, false)
        return layout
    }

}