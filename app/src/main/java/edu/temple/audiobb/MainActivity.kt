package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
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
    }
}