public class Book extends Publication {

    Author author;
    String editor;
    int year;


    public Book(String title, String publication, int qty, Author author, String editor, int year) {
        super(title, publication, qty);
        this.setAuthor(author);
        this.setEditor(editor);
        this.setYear(year);
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setEditor(String editor) {
        this.editor = editor == "" ? "unknown" : editor;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public String getEditor() {
        return editor;
    }

    public int getYear() {
        return year;
    }


    public String toString() {
        String book = "" + this.getId() + "-Book '" + this.getTitle() + "' by ";
        book += this.getAuthor().toString();
        book += " published by " + this.getPublication();
        book += " edited by " + this.getEditor() + " (" + this.getYear() + ")" ;
        return book;
    }
}
