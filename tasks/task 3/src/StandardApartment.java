/**
 * Represents a standard apartment that extends the base {@link Apartment} class.
 *
 * <p>A standard apartment may have one or more balconies, each with a recorded size
 * in square meters. The price of a standard apartment is calculated based on the base
 * price plus a fixed fee per balcony.</p>
 */
public class StandardApartment extends Apartment {

    /**
     * An array holding the size (in square meters) of each balcony in this apartment.
     * The length of this array indicates the number of balconies.
     */
    private int[] balconiesSize;

    /**
     * Constructs a new {@code StandardApartment} with the specified attributes.
     *
     * <p>Copies {@code numberOfBalconies} entries from the provided {@code balconiesSize} array.
     * If {@code numberOfBalconies} is greater than {@code balconiesSize.length}, an
     * {@link ArrayIndexOutOfBoundsException} will be thrown.</p>
     *
     * @param number             the apartment number
     * @param area               the total area of the apartment in square meters
     * @param isSold             {@code true} if the apartment has been sold, {@code false} otherwise
     * @param numberOfBalconies  the number of balconies (determines how many entries are read from {@code balconiesSize})
     * @param balconiesSize      an array of balcony sizes in square meters; must have at least
     *                           {@code numberOfBalconies} elements
     */
    public StandardApartment(int number, int area, boolean isSold, int numberOfBalconies, int[] balconiesSize) {
        super(number, area, isSold);
        this.balconiesSize = new int[numberOfBalconies];
        for (int i = 0; i < numberOfBalconies; i++) {
            this.balconiesSize[i] = balconiesSize[i];
        }
    }

    /**
     * Copy constructor. Creates a new {@code StandardApartment} with the same field values
     * as the given instance.
     *
     * <p><b>Note:</b> The {@code balconiesSize} array is assigned directly via
     * {@link #setBalconiesSize(int[])}, which does <em>not</em> perform a defensive copy.
     * This means both the original and the copy share the same array reference, and
     * mutations to one will affect the other. Consider deep-copying the array.</p>
     *
     * @param standardApartment the {@code StandardApartment} to copy; must not be {@code null}
     */
    public StandardApartment(StandardApartment standardApartment) {
        super(standardApartment.getNumber(), standardApartment.getArea(), standardApartment.isSold());
        this.setBalconiesSize(standardApartment.getBalconiesSize());
    }

    /**
     * Returns the array of balcony sizes for this apartment.
     *
     * <p><b>Warning:</b> Returns the internal array directly (no defensive copy).
     * External modification of the returned array will affect this object's state.</p>
     *
     * @return an {@code int[]} where each element is the size of a balcony in square meters
     */
    public int[] getBalconiesSize() {
        return this.balconiesSize;
    }

    /**
     * Sets the balcony sizes for this apartment.
     *
     * <p><b>Note:</b> This method assigns the given array reference directly without
     * copying it. If the caller later modifies the passed array, the change will be
     * reflected in this object. Consider using a defensive copy:
     * {@code this.balconiesSize = balconiesSize.clone();}</p>
     *
     * @param balconiesSize an {@code int[]} of balcony sizes in square meters;
     *                      must not be {@code null}
     */
    public void setBalconiesSize(int[] balconiesSize) {
        this.balconiesSize = balconiesSize;
    }

    /**
     * Calculates and returns the price of this standard apartment.
     *
     * <p>The price formula is:</p>
     * <pre>
     *   price = base price + (number of balconies × 12,000)
     * </pre>
     *
     * <p><b>Note:</b> This method accesses the {@code price} field directly from the parent
     * class, which assumes {@code price} is at least package-private in {@link Apartment}.</p>
     *
     * @return the calculated price of this apartment in currency units
     */
    @Override
    public int getPrice() {
        return (this.price + (this.balconiesSize.length * 12000));
    }

    /**
     * Returns a formatted string representation of this standard apartment.
     *
     * <p>Includes the parent class's {@code toString()} output and a listing of each
     * balcony with its index and size in square meters.</p>
     *
     * <p><b>Note:</b> "Standart" in the output is a typo — it should be "Standard".</p>
     *
     * <p>Example output:</p>
     * <pre>
     * Standart apartment [number=5, area=80, isSold=false, balconiesSize={ B1:12-Square meter B2:8-Square meter }]
     * </pre>
     *
     * @return a string describing this apartment
     */
    @Override
    public String toString() {
        String s = "Standart apartment [" + super.toString();
        s += ", balconiesSize={ ";
        for (int i = 0; i < this.balconiesSize.length; i++) {
            s += "B" + (i + 1) + ":" + this.balconiesSize[i] + "-Square meter ";
        }
        return s + "}]";
    }
}