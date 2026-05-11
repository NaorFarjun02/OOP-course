/**
 * Represents a penthouse apartment that extends the base {@link Apartment} class.
 *
 * <p>A penthouse has a single balcony, whose size (in square meters) contributes to
 * both its price calculation and its luxury classification. Penthouses are considered
 * luxury if their area exceeds 200 m² and their balcony exceeds 50 m².</p>
 *
 * <p><b>Note on naming:</b> The field and methods use the spelling {@code balconie}
 * (instead of the standard {@code balcony}). Consider renaming to {@code balconySize},
 * {@code getBalconySize()}, and {@code setBalconySize()} for correctness and clarity.</p>
 */
public class Penthouse extends Apartment {

    /**
     * The size of this penthouse's single balcony, in square meters.
     *
     * <p><b>Note:</b> The name {@code balconieSize} is a misspelling of {@code balconySize}.
     * Consider renaming for clarity.</p>
     */
    private int balconieSize;

    /**
     * Constructs a new {@code Penthouse} with the specified attributes.
     *
     * @param number        the apartment number
     * @param area          the total area of the penthouse in square meters
     * @param isSold        {@code true} if the penthouse has been sold, {@code false} otherwise
     * @param balconieSize  the size of the balcony in square meters; should be non-negative
     */
    public Penthouse(int number, int area, boolean isSold, int balconieSize) {
        super(number, area, isSold);
        this.setBalconieSize(balconieSize);
    }

    /**
     * Copy constructor. Creates a new {@code Penthouse} with the same field values
     * as the given instance.
     *
     * <p>Since all fields are primitives, this is effectively a deep copy
     * (no shared mutable state between the original and the copy).</p>
     *
     * @param penthouse the {@code Penthouse} to copy; must not be {@code null}
     */
    public Penthouse(Penthouse penthouse) {
        super(penthouse.getNumber(), penthouse.getArea(), penthouse.isSold());
        this.setBalconieSize(penthouse.balconieSize);
    }

    /**
     * Returns the size of this penthouse's balcony.
     *
     * @return the balcony size in square meters
     */
    public int getBalconieSize() {
        return balconieSize;
    }

    /**
     * Sets the size of this penthouse's balcony.
     *
     * @param balconieSize the balcony size in square meters; should be non-negative
     */
    public void setBalconieSize(int balconieSize) {
        this.balconieSize = balconieSize;
    }

    /**
     * Determines whether this penthouse qualifies as a luxury unit.
     *
     * <p>A penthouse is considered luxury if <em>both</em> of the following conditions hold:</p>
     * <ul>
     *   <li>Total area is greater than 200 square meters</li>
     *   <li>Balcony size is greater than 50 square meters</li>
     * </ul>
     *
     * @return {@code true} if this penthouse is classified as luxury, {@code false} otherwise
     */
    public boolean isLuxury() {
        return this.getArea() > 200 && this.getBalconieSize() > 50;
    }

    /**
     * Calculates and returns the price of this penthouse.
     *
     * <p>The price formula is:</p>
     * <pre>
     *   price = base price + (area × 3,000) + (balcony size × 2,000)
     * </pre>
     *
     * <p><b>Note:</b> This method accesses the {@code price} field directly from the parent
     * class, which assumes {@code price} is at least package-private in {@link Apartment}.
     * For large area and balcony values, this calculation may overflow {@code int}.
     * Consider using {@code long} if overflow is a concern.</p>
     *
     * @return the calculated price of this penthouse in currency units
     */
    @Override
    public int getPrice() {
        return this.price + (this.getArea() * 3000) + (this.getBalconieSize() * 2000);
    }

    /**
     * Returns a formatted string representation of this penthouse.
     *
     * <p>Includes the parent class's {@code toString()} output and the balcony size.</p>
     *
     * <p>Example output:</p>
     * <pre>
     * Penthouse [number=10, area=250, isSold=false, balconieSize=60-Square meter ]
     * </pre>
     *
     * @return a string describing this penthouse
     */
    @Override
    public String toString() {
        String s = "Penthouse [" + super.toString() + ", balconieSize=" + balconieSize + "-Square meter ]";
        return s;
    }
}