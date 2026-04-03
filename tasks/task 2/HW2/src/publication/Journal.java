package publication;

/**
 * Represents a journal (periodical) in the library system.
 * <p>
 * A {@code Journal} extends {@link Publication} and adds an issue number
 * and the year of publication.
 * </p>
 */
public class Journal extends Publication {

    /**
     * The issue number of this journal.
     */
    int issueNumber;

    /**
     * The year this journal issue was published.
     */
    int year;

    /**
     * Default constructor. Creates a {@code Journal} with issue number {@code 0} and year {@code 0}.
     */
    public Journal() {
        this.setIssueNumber(0);
        this.setYear(0);
    }

    /**
     * Constructs a {@code Journal} with all required fields.
     *
     * @param title       the title of the journal
     * @param publication the name of the publisher
     * @param qty         the available quantity in stock
     * @param issueNumber the issue number of this journal
     * @param year        the year this journal issue was published
     */
    public Journal(String title, String publication, int qty, int issueNumber, int year) {
        super(title, publication, qty);
        this.setIssueNumber(issueNumber);
        this.setYear(year);
    }

    /**
     * Returns the issue number of this journal.
     *
     * @return the issue number
     */
    public int getIssueNumber() {
        return issueNumber;
    }

    /**
     * Sets the issue number of this journal.
     *
     * @param issueNumber the issue number to set
     */
    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    /**
     * Returns the year this journal issue was published.
     *
     * @return the publication year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the publication year of this journal.
     *
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns a string representation of this journal in the format:
     * <pre>id-Journal title (issueNumber) published by publisher (year)</pre>
     *
     * @return a formatted string describing this journal
     */
    public String toString() {
        String journal = "" + this.getId() + "-Journal " + this.getTitle() + " (" + this.getIssueNumber() + ") ";
        journal += "published by " + this.getPublication() + " (" + this.getYear() + ")";

        return journal;
    }
}