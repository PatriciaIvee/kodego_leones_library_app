package ph.kodego.leones.patricia.ivee.libraryapp.fragments.librarylist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import ph.kodego.leones.patricia.ivee.libraryapp.R
import ph.kodego.leones.patricia.ivee.libraryapp.adapter.BookAdapter
import ph.kodego.leones.patricia.ivee.libraryapp.dao.BookDAO
import ph.kodego.leones.patricia.ivee.libraryapp.dao.BookDAOSQLImpl
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.FragmentLibraryListBinding
import ph.kodego.leones.patricia.ivee.libraryapp.model.Author
import ph.kodego.leones.patricia.ivee.libraryapp.model.Book
import ph.kodego.leones.patricia.ivee.libraryapp.model.SwipeCallBack

class LibraryListFragment : Fragment() {
    private var _binding: FragmentLibraryListBinding? = null
    private val binding get() = _binding!!
    private lateinit var bookAdapter: BookAdapter
    private var books: ArrayList<Book> = ArrayList()
    private lateinit var itemTouchHelper: ItemTouchHelper
    private final var LOGINFO = "LIBRARYLISTACTIVITY"
    private lateinit var viewModel: LibraryListViewModel
    private lateinit var dao: BookDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(LibraryListViewModel::class.java)
//        val userNameData = arguments?.getString("userNameBundle")
//        val passwordData = arguments?.getString("passwordBundle")
//        viewModel.userNameBundle.value = userNameData
//        viewModel.passwordBundle.value = passwordData
    }

    fun init(){
        var authors: ArrayList<Author> = ArrayList()
        authors.add(Author("William", "Faulkner"))
        books.add(Book("Absalom, Absalom!", authors, R.drawable.book))
        var authors2:ArrayList<Author> = ArrayList()
        authors2.add(Author("John", "Grisham"))
        books.add(Book("A Time to Kill", authors2, R.drawable.book))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLibraryListBinding.inflate(inflater,container, false)

//        val data = this.arguments
//        binding.helloThereTextview.text = "Hello ${data!!.getString(" userNameBundle ")}"

        val data = this.arguments
        if (data != null) {
            val userNameBundle = data.getString("userNameBundle")
            if (userNameBundle != null) {
                binding.helloThereTextview.text = "Hello $userNameBundle"
            } else {
                Log.e(LOGINFO, "userNameBundle is null")
            }
        } else {
            Log.e(LOGINFO, "arguments bundle is null")
        }

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        init()
//        dao = BookDAOSQLImpl(activity)
        dao = activity?.let { BookDAOSQLImpl(it) }!!
        books = dao.getBooks()

        bookAdapter = BookAdapter(books,activity)
        binding.bookListRecycler.layoutManager = LinearLayoutManager(activity)
        binding.bookListRecycler.adapter = bookAdapter

        var swipeCallBack = SwipeCallBack(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        swipeCallBack.bookAdapter = bookAdapter
        itemTouchHelper = ItemTouchHelper(swipeCallBack)
        itemTouchHelper.attachToRecyclerView(binding.bookListRecycler)

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}