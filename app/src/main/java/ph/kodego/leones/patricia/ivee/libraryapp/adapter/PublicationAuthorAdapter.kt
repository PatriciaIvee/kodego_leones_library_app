package ph.kodego.leones.patricia.ivee.libraryapp.adapter

import android.app.Activity
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.AboutBookDialogueBinding
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.PublicationItemBinding
import ph.kodego.leones.patricia.ivee.libraryapp.model.publications.Publication
import ph.kodego.leones.patricia.ivee.libraryapp.model.publications.PublicationAuthors

//class PublicationAuthorAdapter (var publicationAuthors: ArrayList<PublicationAuthors>, var activity: Activity?)
//    : RecyclerView.Adapter<PublicationAuthorAdapter.PublicationAuthorViewHolder>() {
//
//    override fun getItemCount(): Int {
//        return publicationAuthors.size
//    }
//    fun addPublicationAuthors(publicationAuthors: PublicationAuthors){
//        this.publicationAuthors.add(0,publicationAuthors)
//        notifyItemInserted(0)
//    }
//
//    fun removePublicationAuthor(position: Int){
//        publicationAuthors.removeAt(position)
//        notifyItemRemoved(position)
//    }
//
//    fun updatePublicationAuthors(newPublicationAuthors:ArrayList<PublicationAuthors>){
//        publicationAuthors.clear()
//        publicationAuthors.addAll(newPublicationAuthors)
//        notifyDataSetChanged()
//
//    }
//
//    override fun onBindViewHolder(
//        holder: PublicationAuthors.PublicationAuthorsViewHolder,
//        position: Int
//    ) {
////        what's inside each layout (student name)
////        studentViewHolder Has keyword recycler to save memory
//        holder.bindPublication(publicationAuthors[position])
////        pass the data to be sent to viewHolder
//    }
//
//    inner class PublicationAuthorViewHolder(private val itemBinding: PublicationItemBinding) :
//        RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {
//        private var publication = Publication()
//
//        init {
//            itemView.setOnClickListener(this)
//        }
//
//        fun bindPublication(publication: Publication) {
//            this.publication = publication
//
//            val authorNames = StringBuilder()
//            for (author in publicationAuthors.) {
//                authorNames.append(author.personFirstName + " " + author.personLastName)
////                authorNames.append(", ")
//            }
//            val names = authorNames.toString()
//
//
//            itemBinding.publicationImage.setImageResource(publication.img)
//            itemBinding.publicationTitleText.text = "${publication.publicationTitle}"
//            itemBinding.publicationAuthorText.text = "${authorNames.}"
//
////            itemBinding.bookAuthorText.text = "${names}"
////                to set picture
//
////                to set picture from internet source
////                Bitmap = new Bit
////                itemBinding.profilePicture.resources
//        }
//
//        override fun onClick(p0: View?) {
//            Snackbar.make(
//                itemBinding.root,
//                "About Book Not Yet Available",
//                Snackbar.LENGTH_SHORT
//            ).show()
//            showAboutPublication()
//        }
//
//        private fun showAboutPublication() {
//            return activity?.let {
//                val dialogueBinding: AboutBookDialogueBinding =
//                    AboutBookDialogueBinding.inflate(LayoutInflater.from(activity))
//                val alertDialog = AlertDialog.Builder(activity).setView(dialogueBinding.root).create()
//                alertDialog.show()
//
//            }?: throw IllegalStateException("Activity cannot be null")
//
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicationAuthorViewHolder {
//        val itemBinding = PublicationItemBinding //ItemAccountBinding
//            .inflate(
//                LayoutInflater.from(parent.context),
//                parent,false)
//        return PublicationAuthorViewHolder(itemBinding)
//    }
//
//
//
//}