package publication;

/**
 * Represents a publication item in the library system.
 * <p>
 * This is the base class for all publication types (e.g., {@link Book}, {@link Journal}, {@link Encyclopedia}).
 * Each publication is automatically assigned a unique ID, starting from 10,
 * using a shared static counter.
 * </p>
 *
 * <p><b>Note:</b> Fields {@code title}, {@code publication}, and {@code qty} are package-private.</p>
 */
public class Publication {
    String title;
    String publication;
    int qty;

    /** Shared counter used to auto-generate unique IDs. Starts at 10. */
    private static int counter = 10;//count how much object created - start from 10

    /** The unique ID assigned to this publication instance upon creation. */
    private final int id;

    /**
     * Default constructor. Creates a {@code Publication} with empty strings and zero quantity.
     * Automatically assigns a unique ID.
     */
    public Publication() {
        this.id = counter++;

        this.setTitle("");
        this.setPublication("");
        this.setQty(0);
    }

    /**
     * Constructs a {@code Publication} with the specified title, publisher, and quantity.
     * Automatically assigns a unique ID.
     *
     * @param title       the title of the publication
     * @param publication the name of the publisher
     * @param qty         the available quantity in stock
     */
    public Publication(String title, String publication, int qty) {
        this.id = counter++;

        this.setTitle(title);
        this.setPublication(publication);
        this.setQty(qty);
    }

    /**
     * Sets the title of this publication.
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the publisher name of this publication.
     *
     * @param publication the publisher name to set
     */
    public void setPublication(String publication) {
        this.publication = publication;
    }

    /**
     * Sets the available quantity of this publication.
     *
     * @param qty the quantity to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * Returns the title of this publication.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the publisher name of this publication.
     *
     * @return the publisher name
     */
    public String getPublication() {
        return publication;
    }

    /**
     * Returns the available quantity of this publication.
     *
     * @return the quantity
     */
    public int getQty() {
        return qty;
    }

    /**
     * Returns the unique ID of this publication.
     * The ID is assigned automatically at construction time and cannot be changed.
     *
     * @return the unique publication ID
     */
    public int getId() {
        return id;
    }
}