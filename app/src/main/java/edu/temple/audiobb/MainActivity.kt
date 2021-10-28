package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {

    lateinit var bookView: BookView
    var fragmentTwo = false
    private val emptyBook = Book("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var newbook:BookList = BookList()

        newbook.add(Book("Space is Big","Tom H."))
        newbook.add(Book("Cube Houses","Sarah L."))
        newbook.add(Book("Lighting from the Sky","Ryan S."))
        newbook.add(Book("Grumpy the Mouse","Lauren Y."))
        newbook.add(Book("The Art of Pillows","Derick W."))
        newbook.add(Book("The Yawn at Dawn","Tim U."))
        newbook.add(Book("Phone Pieces and Parts Volume 2","Sam N."))
        newbook.add(Book("The perfect Bowtie","Lee Y."))
        newbook.add(Book("Friends and Enemies","Will W."))
        newbook.add(Book("The Last Call","Norm A."))

    bookView = ViewModelProvider(this).get(BookView::class.java)

        fragmentTwo = findViewById<FragmentContainerView>(R.id.BookDetailCon) != null


    if (fragmentTwo) {

        if (supportFragmentManager.findFragmentById(R.id.BookListCon) is BookDetailsFragment) {

            supportFragmentManager.popBackStack()
        }


        if (supportFragmentManager.findFragmentById(R.id.BookListCon) == null) {


            supportFragmentManager.beginTransaction()

                .add(R.id.BookListCon, BookDetailsFragment.newInstance())
                .commit()
        }
    } else if (bookView.getSelectedBook().value != emptyBook) {

        supportFragmentManager.beginTransaction()

            .replace(R.id.BookListCon, BookDetailsFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

        if (savedInstanceState == null) {

            bookView.setSelectedBook(emptyBook)

            if (fragmentTwo) {

                supportFragmentManager.beginTransaction()

                    .add(R.id.BookListCon, BookListFragment.newInstance(newbook))
                    .commit()
            } else {

                supportFragmentManager.beginTransaction()

                    .add(R.id.BookListCon, BookListFragment.newInstance(newbook))
                    .addToBackStack(null)
                    .commit()
            }
        }

    }

    fun selectionMade() {
        if (!fragmentTwo) {

            supportFragmentManager.beginTransaction()

                .replace(R.id.BookListCon, BookDetailsFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
}
}