package edu.temple.audiobb


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookView : ViewModel() {

    private val currentBook: MutableLiveData<Book> by lazy {

        MutableLiveData<Book>()
    }

    fun getSelectedBook(): LiveData<Book> {

        return currentBook
    }

    fun setSelectedBook(book: Book) {

        currentBook.value = book
    }

}