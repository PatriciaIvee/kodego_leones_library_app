package ph.kodego.leones.patricia.ivee.libraryapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.BookItemBinding
import ph.kodego.leones.patricia.ivee.libraryapp.model.Book

class BookAdapter(var books: ArrayList<Book>)
    : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(
        holder: BookAdapter.BookViewHolder,
        position: Int
    ) {
//        what's inside each layout (student name)
//        studentViewHolder Has keyword recycler to save memory
        holder.bindBook(books[position])
//        pass the data to be sent to viewHolder
    }

    inner class BookViewHolder(private val itemBinding: BookItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {
        var book = Book()

        init {
            itemView.setOnClickListener(this)
        }

        fun bindBook(book: Book) {
            this.book = book

            itemBinding.bookTitleText.text = "${book.bookTitle}"
            itemBinding.bookAuthorText.text = "${book.bookAuthor}"
//                to set picture
            itemBinding.bookImage.setImageResource(book.img)
//                to set picture from internet source
//                Bitmap = new Bit
//                itemBinding.profilePicture.resources
        }

        override fun onClick(p0: View?) {
            Snackbar.make(
                itemBinding.root,
                "About Book Not Yet Available",
                Snackbar.LENGTH_SHORT
            ).show()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemBinding = BookItemBinding //ItemAccountBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,false)
        return BookViewHolder(itemBinding)
    }

}