package edu.temple.audiobb

import java.io.Serializable;

class BookList: Serializable{

    private val list = ArrayList<Book>()

    fun add(bookAdd: Book){
        list.add(bookAdd)
    }

    fun remove(bookRemove: Book){
        list.remove(bookRemove)
    }

    fun get(index: Int):Book {
        return list[index]
    }

    fun size():Int{
        return list.size
    }


}