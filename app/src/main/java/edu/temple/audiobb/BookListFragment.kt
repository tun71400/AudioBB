package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider


class BookListFragment : Fragment() {

    lateinit var bookList: BookList
    lateinit var bookListView: RecyclerView
    lateinit var layout: View

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        bookListView = layout.findViewById(R.id.booklist)
        bookListView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = BookConverter(requireContext(), bookList) {
            updateModel(bookListView.getChildAdapterPosition(it))
        }
        bookListView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        layout = inflater.inflate(R.layout.fragment_book_list, container, false)
        return layout
    }


    private fun updateModel(index: Int) {

        ViewModelProvider(requireActivity())
            .get(BookView::class.java)
            .setSelectedBook(bookList.get(index))
        (requireActivity() as DoubleLayout).selectionMade()
    }

}