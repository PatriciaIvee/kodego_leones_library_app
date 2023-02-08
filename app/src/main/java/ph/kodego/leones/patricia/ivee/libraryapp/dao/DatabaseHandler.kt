package ph.kodego.leones.patricia.ivee.libraryapp.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context): SQLiteOpenHelper(context,DATABASENAME,null,DATABASEVERSION) {

    companion object {
        private val DATABASEVERSION = 1
        private val DATABASENAME = "library_database"

        val tableAccount = "account_table"
        val accountId = "account_id"
        val userName = "user_name"
        val password  = "password"

        val tableUser = "user_table"
        val userId  = "user_id"
        val firstNameUser = "user_first_name"
        val lastNameUser = "user_last_name"
        val emailUser = "user_email"

        val tablePerson = "person_table"
        val personId = "person_id"
        val personType = "person_type"
        val firstNamePerson = "person_first_name"
        val lastNamePerson = "person_last_name"


        val tableAuthors = "authors_table"
        val authorId = "author_id"
        val publicationAuthorId = "publication_author_id"

//        personId

        val tableIllustrator = "illustrator_table"
        val illustratorId = "illustrator_id"
//        personId

        val tablePublishers = "publishers_table"
        val publisherId = "publisher_id"
        val publisherName = "publisher_name"
        val publisherAddress ="publisher_address"
        val dateEstablished = "date_established"

        val tableBookPublishers = "book_publishers_table"
        val bookPublishersId = "book_publishers_id"

        val tablePublication = "publication_table"
        val publicationId ="publication_id"
        val publicationType = "publication_type"
        val title = "title"
        val datePublished = "date_published"
        val pubStatus = "status"
//        account_id


        val tableBooks = "book_table"
        val bookId = "book_id"
//        publicationId
        val isbn10Number = "isbn10_number"
        val isbn13Number = "isbn13_number"

    }
//TODO: ADD COMICS, MAGAZINE, NEWSPAPER AND AUDIOVIDEOMATERIAL
    override fun onCreate(db: SQLiteDatabase?) {




        val CREATEPUBLICATIONSTABLE =
            "CREATE TABLE $tablePublication " +
                    "($publicationId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$publicationType TEXT, " +
                    "$title TEXT, " +
                    "$datePublished TEXT, " +
                    "$pubStatus TEXT, " +
                    "$accountId INTEGER)"
        db?.execSQL(CREATEPUBLICATIONSTABLE)

        db?.execSQL("INSERT into $tablePublication" +
                "($publicationType,$title,$datePublished,$pubStatus,$accountId)" +
                " values ('Book','The Lovely Bones', '2004-04-20', 'UNSPECIFIED', 0 )")

        db?.execSQL("INSERT into $tablePublication" +
                "($publicationType,$title,$datePublished,$pubStatus,$accountId)" +
                " values ('Book','Pride and Prejudice', '2002-12-31', 'UNSPECIFIED', 0 )")

        db?.execSQL("INSERT into $tablePublication" +
                "($publicationType,$title,$datePublished,$pubStatus,$accountId)" +
                " values ('Book','Sapiens: A Brief History of Humankind', '2015-02-10', 'UNSPECIFIED', 0 )")

        db?.execSQL("INSERT into $tablePublication" +
                "($publicationType,$title,$datePublished,$pubStatus,$accountId)" +
                " values ('Book','The Great Gatsby', '1925-04-10', 'UNSPECIFIED', 0 )")

        db?.execSQL("INSERT into $tablePublication" +
                "($publicationType,$title,$datePublished,$pubStatus,$accountId)" +
                " values ('Book','1984', '1961-01-01', 'UNSPECIFIED', 0 )")

        db?.execSQL("INSERT into $tablePublication" +
                "($publicationType,$title,$datePublished,$pubStatus,$accountId)" +
                " values ('Book','To Kill a Mockingbird', '2002-01-01', 'UNSPECIFIED', 0 )")



    val CREATEAUTHORSTABLE =
        "CREATE TABLE $tableAuthors " +
                "($authorId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$publicationAuthorId INTEGER, " +
                "$firstNamePerson TEXT, " +
                "$lastNamePerson TEXT, " +
                "FOREIGN KEY ($publicationAuthorId) REFERENCES $tablePublication($publicationId))"
    db?.execSQL(CREATEAUTHORSTABLE)

    db?.execSQL("INSERT INTO $tableAuthors($publicationAuthorId, $firstNamePerson, $lastNamePerson) values (1, 'Anne', 'Secole')")
    db?.execSQL("INSERT INTO $tableAuthors($publicationAuthorId, $firstNamePerson, $lastNamePerson) values (2, 'Jane', 'Austen')")
    db?.execSQL("INSERT INTO $tableAuthors($publicationAuthorId, $firstNamePerson, $lastNamePerson) values (3, 'Yuval', 'Harari')")
    db?.execSQL("INSERT INTO $tableAuthors($publicationAuthorId, $firstNamePerson, $lastNamePerson) values (4, 'Scott', 'Fitzgerald')")
    db?.execSQL("INSERT INTO $tableAuthors($publicationAuthorId, $firstNamePerson, $lastNamePerson) values (5, 'George', 'Orwell')")
//    db?.execSQL("INSERT INTO $tableAuthors($publicationAuthorId, $firstNamePerson, $lastNamePerson) values (5, 'Erich', 'Fromm')")
    db?.execSQL("INSERT INTO $tableAuthors($publicationAuthorId, $firstNamePerson, $lastNamePerson) values (6, 'Harper', 'Lee')")


//    "FOREIGN KEY ($publicationId) REFERENCES $tablePublication($publicationId)
//        If you want to put 2 or more authors to one book
//        db?.execSQL("INSERT into $tableBookAuthor($bookId,$authorId)" +
//                "values (1,1), (1,2), (1,3)")

        val CREATEBOOKSTABLE =
            "CREATE TABLE $tableBooks " +
                "($bookId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$isbn10Number TEXT, " +
                "$isbn13Number TEXT, " +
                "$publicationId INTEGER, "  +
                "$publisherId INTEGER, " +
                "FOREIGN KEY ($publicationId) REFERENCES $tablePublication($publicationId), " +
                "FOREIGN KEY ($publisherId) REFERENCES $tablePublishers($publisherId))"
        db?.execSQL(CREATEBOOKSTABLE)

        db?.execSQL("INSERT into $tableBooks" +
                "($isbn10Number, $isbn13Number, $publicationId, $publisherId) " +
                "values ('ISBN 0316168815','ISBN 0000-123456789', 1, 1)")
        db?.execSQL("INSERT into $tableBooks" +
                "($isbn10Number, $isbn13Number, $publicationId, $publisherId) " +
                "values ('ISBN 0141439513','ISBN 978-0141439518', 2, 2)")
        db?.execSQL("INSERT into $tableBooks" +
                "($isbn10Number,$isbn13Number, $publicationId, $publisherId) " +
                "values ('ISBN 0771038518 ','ISBN 978-0062316110', 3, 3)")
        db?.execSQL("INSERT into $tableBooks" +
                "($isbn10Number,$isbn13Number, $publicationId, $publisherId) " +
                "values ('ISBN 1640322795 ','ISBN 979-8409130329', 4, 4)")
        db?.execSQL("INSERT into $tableBooks" +
                "($isbn10Number,$isbn13Number, $publicationId, $publisherId) " +
                "values ('ISBN 0451524934 ','ISBN 978-0451524935', 5, 5)")
        db?.execSQL("INSERT into $tableBooks" +
                "($isbn10Number,$isbn13Number, $publicationId, $publisherId) " +
                "values ('ISBN 0060935464 ','ISBN 978-0060935467', 6, 6)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $tableAuthors")
//        db!!.execSQL("DROP TABLE IF EXISTS $tableBooks")
        db!!.execSQL("DROP TABLE IF EXISTS $tablePublication")

        onCreate(db)
    }

}