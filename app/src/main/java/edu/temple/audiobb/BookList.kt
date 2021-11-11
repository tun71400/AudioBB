package edu.temple.audiobb

import java.io.Serializable;

class BookList: Serializable{

    private val bookList = ArrayList<Book>()

    fun add(bookAdd: Book){

        bookList.add(bookAdd)
    }

    fun clear() {

        bookList.clear()
    }

    fun remove(bookRemove: Book){

        bookList.remove(bookRemove)
    }

    fun get(index: Int):Book {

        return bookList[index]
    }

    fun size():Int{

        return bookList.size
    }


}
