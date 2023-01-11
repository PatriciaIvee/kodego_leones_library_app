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
        books.add(Book("Absalom, Absalom!", "William Faulkner",R.drawable.book))
        books.add(Book("A Time to Kill", "John Grisham", R.drawable.book))
        books.add(Book("Noli Me Tangere", "Jose Rizal",R.drawable.book))
        books.add(Book("The Fault in Our Stars", "John Greene",R.drawable.book))
        books.add(Book("I Know Why The Caged Bird Sings", "Maya Angelou",R.drawable.book))
        books.add(Book("Dance Dance Dance", "Haruki Murakami",R.drawable.book))
        books.add(Book("Gone With The Wind","Margaret Mitchell",R.drawable.book))
        books.add(Book("Don Quixote", "Miguel de Cervantes",R.drawable.book))
        books.add(Book("Lord of the Rings", "J.R.R Tolkien",R.drawable.book))
        books.add(Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling",R.drawable.book))
        books.add(Book("And Then There Were None", "Agatha Cristie",R.drawable.book))
        books.add(Book("Alice's Adventures In The Wonderland", "Lewis Carroll",R.drawable.book))
        books.add(Book("Pinocchio", "Carlo Callodi",R.drawable.book))
        books.add(Book("Catcher In The Rye", "J.D. Salinger",R.drawable.book))
        books.add(Book("Anne Of Green Gables", "L.M. Montgomery",R.drawable.book))
        books.add(Book("Twenty Thousand Leagues Under the Sea", "Jules Verne",R.drawable.book))
    }
}