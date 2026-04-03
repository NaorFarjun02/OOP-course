package publication;

/**
 * Represents a book in the library system.
 * <p>
 * A {@code Book} extends {@link Publication} and adds information about the author,
 * editor, and publication year. If no editor is provided (empty string), the editor
 * defaults to {@code "unknown"}.
 * </p>
 *
 * <p><b>Note:</b> The editor check in {@link #setEditor(String)} uses {@code ==} instead of
 * {@code .equals()}, which means the fallback to {@code "unknown"} will not work correctly
 * for non-literal empty strings.</p>
 */
public class Book extends Publication {

    /** The author of this book. */
    Author author;

    /** The editor of this book. Defaults to {@code "unknown"} if not provided. */
    String editor;

    /** The year this book was published. */
    int year;

    /**
     * Constructs a {@code Book} with all required fields.
     *
     * @param title       the title of the book
     * @param publication the name of the publisher
     * @param qty         the available quantity in stock
     * @param author      the {@link Author} of this book
     * @param editor      the editor of this book; defaults to {@code "unknown"} if empty
     * @param year        the year the book was published
     */
    public Book(String title, String publication, int qty, Author author, String editor, int year) {
        super(title, publication, qty);
        this.setAuthor(author);
        this.setEditor(editor);
        this.setYear(year);
    }

    /**
     * Sets the author of this book.
     *
     * @param author the {@link Author} to assign
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Sets the editor of this book.
     * If the provided value is an empty string literal, it defaults to {@code "unknown"}.
     *
     * <p><b>Note:</b> Uses {@code ==} for comparison instead of {@code .equals()},
     * which may not behave as expected for non-literal empty strings.</p>
     *
     * @param editor the editor name to set
     */
    public void setEditor(String editor) {
        this.editor = editor == "" ? "unknown" : editor;
    }

    /**
     * Sets the publication year of this book.
     *
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns the author of this book.
     *
     * @return the {@link Author} of this book
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Returns the editor of this book.
     *
     * @return the editor's name, or {@code "unknown"} if none was provided
     */
    public String getEditor() {
        return editor;
    }

    /**
     * Returns the year this book was published.
     *
     * @return the publication year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns a string representation of this book in the format:
     * <pre>id-Book 'title' by author published by publisher edited by editor (year)</pre>
     *
     * @return a formatted string describing this book
     */
    public String toString() {
        String book = "" + this.getId() + "-Book '" + this.getTitle() + "' by ";
        book += this.getAuthor().toString();
        book += " published by " + this.getPublication();
        book += " edited by " + this.getEditor() + " (" + this.getYear() + ")" ;
        return book;
    }
}