package ph.kodego.leones.patricia.ivee.libraryapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ph.kodego.leones.patricia.ivee.libraryapp.R
import ph.kodego.leones.patricia.ivee.libraryapp.adapter.BookAdapter
import ph.kodego.leones.patricia.ivee.libraryapp.adapter.PublicationAdapter
import ph.kodego.leones.patricia.ivee.libraryapp.dao.*
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.FragmentLibraryListBinding
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.FragmentSearchBinding
import ph.kodego.leones.patricia.ivee.libraryapp.model.publications.Book
import ph.kodego.leones.patricia.ivee.libraryapp.model.publications.Publication
import ph.kodego.leones.patricia.ivee.libraryapp.model.publications.PublicationAuthors


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var publicationAdapter: PublicationAdapter
    private var books: ArrayList<Book> = ArrayList()
    private var publications: ArrayList<Publication> = ArrayList()
    private var publicationAuthors: ArrayList<PublicationAuthors> = ArrayList()
    private lateinit var publicationDAO:PublicationDAO
    private lateinit var authorDAO: AuthorDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater,container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        publicationDAO = PublicationDAOSQLImpl(activity)

        publicationDAO = activity?.let { PublicationDAOSQLImpl(it) }!!
        publications = publicationDAO.getPublications()
        authorDAO = activity?.let{AuthorDAOSQLImpl(it)}!!

        var authors = publicationDAO.getPublicationWithAuthors()
        publicationAuthors = publicationDAO.getPublicationWithAuthors()


        publicationAdapter = PublicationAdapter(publications,activity)
        binding.publicationListRecycler.layoutManager = LinearLayoutManager(activity)
        binding.publicationListRecycler.adapter = publicationAdapter
//        authorDAO.getAuthors()

//        publications = publicationDAO.getPublicationType()

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}