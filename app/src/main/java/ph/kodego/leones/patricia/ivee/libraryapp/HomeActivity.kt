package ph.kodego.leones.patricia.ivee.libraryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ph.kodego.leones.patricia.ivee.libraryapp.adapter.BookAdapter
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.ActivityHomeBinding
import ph.kodego.leones.patricia.ivee.libraryapp.model.Book

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var bookAdapter: BookAdapter
    private var books: ArrayList<Book> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        bookAdapter = BookAdapter(books)
        binding.bookListRecycler.layoutManager = LinearLayoutManager(applicationContext)
        binding.bookListRecycler.adapter = bookAdapter
    }

    fun init(){
        books.add(Book("Dave", "Navor",R.drawable.book))
        books.add(Book("Victor", "Yu", R.drawable.book))
        books.add(Book("JP", "Soriano",R.drawable.book))
        books.add(Book("CJ", "Tronco",R.drawable.book))
        books.add(Book("Rene", "Palma",R.drawable.book))
        books.add(Book("Joni", "James",R.drawable.book))
        books.add(Book("Janreign","Aragon",R.drawable.book))
        books.add(Book("John Rey", "Balais",R.drawable.book))
        books.add(Book("James Nico", "Rara",R.drawable.book))
        books.add(Book("Pat Ivee", "Leones",R.drawable.book))
        books.add(Book("Matthew", "Mottos",R.drawable.book))
    }
}