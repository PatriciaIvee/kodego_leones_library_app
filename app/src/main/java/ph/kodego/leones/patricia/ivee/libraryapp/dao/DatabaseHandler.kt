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

        val tableAuthor = "author_table"
        val authorId = "author_id"
        val tableBookAuthors = "book_authors_table"
        val bookAuthorId = "book_author_id"

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
        val status = "status"
//        account_id



        val tableBooks = "book_table"
        val bookId = "book_id"
//        publicationId
        val isbn10Number = "isbn10_number"
        val isbn13Number = "isbn13_number"

    }
//TODO: ADD COMICS, MAGAZINE, NEWSPAPER AND AUDIOVIDEOMATERIAL
    override fun onCreate(db: SQLiteDatabase?) {

        val CREATEPERSONSTABLE =
            "CREATE TABLE $tablePerson " +
                    "($personId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$firstNamePerson TEXT, " +
                    "$lastNamePerson TEXT)"
        db?.execSQL(CREATEPERSONSTABLE)
//        removed person type

        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Anne', 'Secole')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Jane', 'Austen')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Yuval', 'Harari')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Scott', 'Fitzgerald')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('George', 'Orwell')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Erich', 'Fromm')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Harper', 'Lee')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Frank', 'Miller')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Klaus', 'Janson')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Lynn', 'Varley')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Bryan', 'Talbot')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Alan', 'Moore')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Eddie', 'Campbell')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Daniel', 'Clowes')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('David', 'Lloyd')")
        db?.execSQL("INSERT into $tablePerson($firstNamePerson,$lastNamePerson)" +
                "values ('Charles', 'Burns')")


        val CREATEAUTHORSTABLE =
            "CREATE TABLE $tableAuthor " +
                    "($authorId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$personId INTEGER, " +
                    "FOREIGN KEY($personId) REFERENCES $tablePerson($personId))"
        db?.execSQL(CREATEAUTHORSTABLE)

        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (1)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (2)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (3)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (4)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (5)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (6)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (7)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (8)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (11)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (12)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (14)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (16)")

//        question: Should I remove the Primary Key autoIncrement

        val CREATEBOOKAUTHORSTABLE =
            "CREATE TABLE $tableBookAuthors " +
                    "($bookAuthorId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$bookId INTEGER, " +
                    "$authorId INTEGER, " +
                    "FOREIGN KEY($bookId) REFERENCES $tableBooks($bookId), " +
                    "FOREIGN KEY($authorId) REFERENCES $tableAuthor($authorId))"
        db?.execSQL(CREATEBOOKAUTHORSTABLE)

//        If you want to put 2 or more authors to one book
//        db?.execSQL("INSERT into $tableBookAuthor($bookId,$authorId)" +
//                "values (1,1), (1,2), (1,3)")

        db?.execSQL("INSERT into $tableBookAuthors($bookId,$authorId)" +
                "values (1,1)")
        db?.execSQL("INSERT into $tableBookAuthors($bookId,$authorId)" +
                "values (2,2)")
        db?.execSQL("INSERT into $tableBookAuthors($bookId,$authorId)" +
                "values (3,3)")
        db?.execSQL("INSERT into $tableBookAuthors($bookId,$authorId)" +
                "values (4,4)")
        db?.execSQL("INSERT into $tableBookAuthors($bookId,$authorId)" +
                "values (5,5), (5,6)")
        db?.execSQL("INSERT into $tableBookAuthors($bookId,$authorId)" +
                "values (6,7)")

        val CREATEPUBLICATIONSTABLE =
            "CREATE TABLE $tablePublication " +
                    "($publicationId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$publicationType TEXT, " +
                    "$title TEXT, " +
                    "$datePublished DATE, " +
                    "$status TEXT, " +
                    "$accountId INTEGER)"
        db?.execSQL(CREATEPUBLICATIONSTABLE)

        db?.execSQL("INSERT into $tablePublication" +
                "($publicationType,$title,$datePublished,$status,$accountId)" +
                " values ('Book','The Lovely Bones', '2004-04-20', 'UNSPECIFIED', 0 )")

        db?.execSQL("INSERT into $tablePublication" +
                "($publicationType,$title,$datePublished,$status,$accountId)" +
                " values ('Book','Pride and Prejudice', '2002-12-31', 'UNSPECIFIED', 0 )")

        db?.execSQL("INSERT into $tablePublication" +
                "($publicationType,$title,$datePublished,$status,$accountId)" +
                " values ('Book','Sapiens: A Brief History of Humankind', '2015-02-10', 'UNSPECIFIED', 0 )")

        db?.execSQL("INSERT into $tablePublication" +
                "($publicationType,$title,$datePublished,$status,$accountId)" +
                " values ('Book','The Great Gatsby', '1925-04-10', 'UNSPECIFIED', 0 )")

        db?.execSQL("INSERT into $tablePublication" +
                "($publicationType,$title,$datePublished,$status,$accountId)" +
                " values ('Book','1984', '1961-01-01', 'UNSPECIFIED', 0 )")

        db?.execSQL("INSERT into $tablePublication" +
                "($publicationType,$title,$datePublished,$status,$accountId)" +
                " values ('Book','To Kill a Mockingbird', '2002-01-01', 'UNSPECIFIED', 0 )")

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


        val CREATEPUBLISHERSTABLE =
            "CREATE TABLE $tablePublishers " +
                    "($publisherId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$publisherName TEXT, " +
                    "$publisherAddress TEXT," +
                    "$dateEstablished DATE)"
        db?.execSQL(CREATEPUBLISHERSTABLE)

        db?.execSQL("INSERT into $tablePublishers ($publisherName, $publisherAddress, $dateEstablished)" +
                "values ('Bay Back Books', '', '')")
        db?.execSQL("INSERT into $tablePublishers ($publisherName, $publisherAddress, $dateEstablished)" +
                "values ('Penguin Books', '', '')")
        db?.execSQL("INSERT into $tablePublishers ($publisherName, $publisherAddress, $dateEstablished)" +
                "values ('Harper Perennial', '', '')")
        db?.execSQL("INSERT into $tablePublishers ($publisherName, $publisherAddress, $dateEstablished)" +
                "values ('Charles Scribner''s Sons'  , '', '')")
        //        You can do this too
//        db?.execSQL("INSERT into $tablePublishers ($publisherName, $publisherAddress, $dateEstablished)" +
//                "values (\"Charles Scribner's Sons\" , '', '')")
        db?.execSQL("INSERT into $tablePublishers ($publisherName, $publisherAddress, $dateEstablished)" +
                "values ('Signet Classic'  , '', '')")

        val CREATEBOOKPUBLISHERSTABLE =
            "CREATE TABLE $tableBookPublishers " +
                    "($bookPublishersId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$bookId INTEGER, " +
                    "$publisherId INTEGER, " +
                    "FOREIGN KEY ($bookId) REFERENCES $tableBooks($bookId), " +
                    "FOREIGN KEY ($publisherId) REFERENCES $tablePublishers($publisherId))"
        db?.execSQL(CREATEBOOKPUBLISHERSTABLE)

        db?.execSQL("INSERT into $tableBookPublishers($bookId,$publisherId) values(1, 1)")
        db?.execSQL("INSERT into $tableBookPublishers($bookId,$publisherId) values(2, 2)")
        db?.execSQL("INSERT into $tableBookPublishers($bookId,$publisherId) values(3, 3)")
        db?.execSQL("INSERT into $tableBookPublishers($bookId,$publisherId) values(4, 4)")
        db?.execSQL("INSERT into $tableBookPublishers($bookId,$publisherId) values(5, 5)")
        db?.execSQL("INSERT into $tableBookPublishers($bookId,$publisherId) values(6, 3)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $tableBookAuthors")
        db!!.execSQL("DROP TABLE IF EXISTS $tableAuthor")
        db!!.execSQL("DROP TABLE IF EXISTS $tableBooks")
        db!!.execSQL("DROP TABLE IF EXISTS $tablePerson")
        db!!.execSQL("DROP TABLE IF EXISTS $tablePublication")
        db!!.execSQL("DROP TABLE IF EXISTS $tablePublishers")
        db!!.execSQL("DROP TABLE IF EXISTS $tableBookPublishers")
        onCreate(db)
    }

}