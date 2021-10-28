package edu.temple.audiobb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookListView : ViewModel() {
    private val BookData = MutableLiveData<BookList>()

    fun getBookList () : LiveData<BookList> {
        return BookData
    }

    fun setBookList(book: BookList) {
        BookData.value = book
    }
}