package ph.kodego.leones.patricia.ivee.libraryapp.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException
import ph.kodego.leones.patricia.ivee.libraryapp.model.publications.Book

interface BookDAO {
    fun addBook (book: Book)
//    fun returnBook(book: Book)
//    fun changeBookStatus (book: Book)
    fun getBooks(): ArrayList<Book>
//    fun searchBooks(search:String): ArrayList<Book>
}

class BookDAOSQLImpl(var context: Context): BookDAO{
    override fun addBook(book: Book) {
        var databaseHandler: DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues().apply {
            put(DatabaseHandler.title, book.publicationTitle)
//            put(DatabaseHandler.lastNamePerson, DatabaseHandler.firstNamePerson, book.authors)
        }

        val success = db.insert(DatabaseHandler.tablePublication,null,contentValues)
//        Always close after use because it will cause memory build up
        db.close()
    }

// TODO: Get other publications (COMICS, MAGAZINE ETC.) MAYBE PUT IT IN A NEW DAO
    override fun getBooks(): ArrayList<Book> {
        val bookList :ArrayList<Book> = ArrayList()

        val selectQuery = "SELECT ${DatabaseHandler.bookId}, " +
                "bookTable.${DatabaseHandler.isbn10Number}, " +
                "bookTable.${DatabaseHandler.isbn13Number}, " +
                "bookTable${DatabaseHandler.publicationId}, " +
                "bookTable${DatabaseHandler.publisherId}, " +
                "publicationTable.${DatabaseHandler.title} " +
                "FROM ${DatabaseHandler.tableBooks} bookTable"


        val databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery,null)
        }catch (e: SQLiteException) {
            db.close()
            return ArrayList()
        }
        var book = Book()
        if (cursor.moveToFirst()) {
            do {
                book = Book()
                book.bookId = cursor.getInt(0)
                book.publicationTitle = ""
                book.isbn10number = cursor.getString(1)
                book.isbn13number = cursor.getString(2)
                book.publicationId =  cursor.getInt(3)
                book.publisherId = cursor.getInt(4)

                bookList.add(book)

            }while (cursor.moveToNext())
        }

        db.close()
        return bookList
    }
}