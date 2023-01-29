package ph.kodego.leones.patricia.ivee.libraryapp.adapter

import android.app.Activity
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.AboutBookDialogueBinding
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.BookItemBinding
import ph.kodego.leones.patricia.ivee.libraryapp.model.Book

class BookAdapter(var books: ArrayList<Book>, var activity: Activity?)
    : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {



    override fun getItemCount(): Int {
        return books.size
    }
    fun addBook(book:Book){
        books.add(0,book)
        notifyItemInserted(0)
    }

    fun removebook(position: Int){
        books.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateBooks(newBooks:ArrayList<Book>){
        books.clear()
        books.addAll(newBooks)
        notifyDataSetChanged()

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

            val authorNames = StringBuilder()
            for (author in book.authors) {
                authorNames.append(author.personFirstName + " " + author.personLastName)
//                authorNames.append(", ")
            }
            val names = authorNames.toString()

            itemBinding.bookTitleText.text = "${book.title}"
            itemBinding.bookAuthorText.text = "${names}"
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
            showAboutBook()
        }

        private fun showAboutBook() {
            return activity?.let {
                val dialogueBinding:AboutBookDialogueBinding =
                    AboutBookDialogueBinding.inflate(LayoutInflater.from(activity))
                val alertDialog = AlertDialog.Builder(activity).setView(dialogueBinding.root).create()
                alertDialog.show()

            }?: throw IllegalStateException("Activity cannot be null")

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