package edu.temple.audiobb

import java.io.Serializable;

class BookList: Serializable{

    var datalist = mutableListOf<Book>()

    fun add(book: Book){
        datalist.add(book)
    }

    fun remove(book: Book){
        datalist.remove(book)
    }

    fun get(index: Int):Book {
        return datalist[index]
    }

    fun size():Int{
        return datalist.size
    }


}