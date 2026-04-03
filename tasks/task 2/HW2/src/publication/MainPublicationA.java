package publication;

public class MainPublicationA {

    public static void main(String[] args) {

        Author[] authors = new Author[4];
        authors[0] = new Author("Harper Lee", "harper@somewhere.com");
        authors[1] = new Author("F. Scott Fitzgerald", "scott@somewhere.com");
        authors[2] = new Author("Amos Oz", "oz@somewhere.com");
        authors[3] = new Author("publication.Encyclopedia Staff", "staff@encyclopedia.com");

        Book[] books = new Book[3];
        books[0] = new Book(
                "To Kill a Mockingbird",
                "J. B. Lippincott & Co.",
                2,
                authors[0],
                "Tay Hohoff",
                1960
        );

        books[1] = new Book(
                "The Great Gatsby",
                "Charles Scribner's Sons",
                1,
                authors[1],
                "Maxwell Perkins",
                1925
        );

        books[2] = new Book(
                "Sippur Al Ahava VeChoshech",
                "Houghton Mifflin Harcourt",
                1,
                authors[2],
                "",
                2002
        );

        Journal[] journals = new Journal[3];
        journals[0] = new Journal(
                "Scientific American",
                "Springer Nature",
                5,
                135,
                2021
        );

        journals[1] = new Journal(
                "Teva Hadvarim",
                "Hahevra le-Heker Haadam ve-Hasovev ltd",
                5,
                297,
                2020
        );

        journals[2] = new Journal(
                "Nature",
                "Springer Nature",
                5,
                590,
                2021
        );

        Encyclopedia[] encyclopedias = new Encyclopedia[3];
        encyclopedias[0] = new Encyclopedia(
                "publication.Encyclopedia Britannica",
                "publication.Encyclopedia Britannica, Inc.",
                1,
                "",
                1
        );

        encyclopedias[1] = new Encyclopedia(
                "publication.Encyclopedia Britannica",
                "publication.Encyclopedia Britannica, Inc.",
                1,
                "",
                3
        );

        encyclopedias[2] = new Encyclopedia(
                "publication.Encyclopedia Americana",
                "Scholastic Corporation",
                1,
                "",
                30
        );

        System.out.println("List of books:");
        System.out.println("==============");
        printBooks(books);

        System.out.println();
        System.out.println("List of journals:");
        System.out.println("=================");
        printJournals(journals);

        System.out.println();
        System.out.println("List of encyclopedias:");
        System.out.println("======================");
        printEncyclopedias(encyclopedias);
    }

    public static void printBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println(books[i]);
                System.out.println();
            }
        }
    }

    public static void printJournals(Journal[] journals) {
        for (int i = 0; i < journals.length; i++) {
            if (journals[i] != null) {
                System.out.println(journals[i]);
                System.out.println();
            }
        }
    }

    public static void printEncyclopedias(Encyclopedia[] encyclopedias) {
        for (int i = 0; i < encyclopedias.length; i++) {
            if (encyclopedias[i] != null) {
                System.out.println(encyclopedias[i]);
                System.out.println();
            }
        }
    }
}