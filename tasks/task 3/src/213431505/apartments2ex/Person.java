package apartments2ex;

// Assignment: 2
// Author: Naor Farjun, ID: 213431505
/**
 * Represents a person who can own one or more apartments.
 *
 * <p>This class stores the person's full name and a dynamic list of {@link Apartment} objects
 * they own. It provides methods to add apartments, calculate total property value,
 * count apartments by type, and print ownership details.</p>
 */
public class Person {

    /** The full name of the person (first name + last name). */
    private String name;

    /**
     * The array of apartments owned by this person.
     * Package-private to allow access from within the same package.
     */
    Apartment[] apartments;

    /**
     * Constructs a new {@code Person} with a given first and last name.
     * Initializes the apartments array as empty.
     *
     * @param firstName the person's first name
     * @param lastName  the person's last name
     */
    public Person(String firstName, String lastName) {
        this.setName(firstName + " " + lastName);
        apartments = new Apartment[0];
    }

    /**
     * Copy constructor. Creates a new {@code Person} with the same name and apartments
     * as the given person.
     *
     * <p><b>Note:</b> The apartments array is shallow-copied — each {@link Apartment}
     * reference is copied but not deep-cloned. Changes to individual apartment objects
     * will be reflected in both the original and the copy.</p>
     *
     * @param person the {@code Person} to copy; must not be {@code null}
     */
    public Person(Person person) {
        this.setName(person.getName());
        this.setApartments(person.getApartments());
    }

    /**
     * Sets the full name of this person.
     *
     * @param name the full name to set; must not be {@code null}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the full name of this person.
     *
     * @return the person's full name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the apartments owned by this person by copying the given array.
     *
     * <p><b>Note:</b> This is a shallow copy — apartment references are copied,
     * not deep-cloned. Modifications to the apartment objects themselves will
     * be reflected here.</p>
     *
     * @param apartments the array of apartments to set; must not be {@code null}
     */
    public void setApartments(Apartment[] apartments) {
        this.apartments = new Apartment[apartments.length];
        for (int i = 0; i < apartments.length; i++) {
            this.apartments[i] = apartments[i];
        }
    }

    /**
     * Returns the array of apartments owned by this person.
     *
     * <p><b>Warning:</b> Returns the internal array directly (no defensive copy).
     * External modification of the returned array will affect this object's state.</p>
     *
     * @return the array of {@link Apartment} objects owned by this person
     */
    public Apartment[] getApartments() {
        return this.apartments;
    }

    /**
     * Adds a new apartment to this person's list of owned apartments.
     *
     * <p>Internally creates a new array of size {@code n+1}, copies existing apartments,
     * appends the new one, and then clones the result unnecessarily (see note below).</p>
     *
     * <p><b>Note:</b> The final {@code temp.clone()} call is redundant since {@code temp}
     * is already a fresh array. Consider removing it for clarity.</p>
     *
     * @param apt the {@link Apartment} to add; must not be {@code null}
     */
    public void addApartment(Apartment apt) {
        Apartment[] temp = new Apartment[this.apartments.length + 1];
        for (int i = 0; i < apartments.length; i++) {
            temp[i] = this.apartments[i];
        }
        temp[temp.length - 1] = apt;
        this.apartments = temp.clone();
    }

    /**
     * Calculates and returns the total property value of all apartments owned by this person.
     *
     * <p>The total is computed by summing the result of {@link Apartment#getPrice()} for
     * each apartment. Note that this returns an {@code int}, which may overflow for very
     * large portfolios. Consider using {@code long} if overflow is a concern.</p>
     *
     * @return the sum of prices of all owned apartments
     */
    public int getTotalPropertyValue() {
        int count = 0;
        for (int i = 0; i < this.apartments.length; i++) {
            count += this.apartments[i].getPrice();
        }
        return count;
    }

    /**
     * Returns a human-readable string representing the type of the given apartment.
     *
     * <p>Recognizes {@link StandardApartment}, {@link Penthouse}, and {@code GardenApartment}.
     * Returns {@code "Unknown"} for any other subtype.</p>
     *
     * @param apt the {@link Apartment} whose type is to be determined; must not be {@code null}
     * @return a string such as {@code "StandardApartment"}, {@code "Penthouse"},
     *         {@code "GardenApartment"}, or {@code "Unknown"}
     */
    private String getApartmentType(Apartment apt) {
        if (apt instanceof StandardApartment) {
            return "StandardApartment";
        }
        if (apt instanceof Penthouse) {
            return "Penthouse";
        }
        if (apt instanceof GardenApartment) {
            return "GardenApartment";
        }
        return "Unknown";
    }

    /**
     * Counts the number of apartments of the specified type owned by this person.
     *
     * <p><b>Bug:</b> The validation condition is logically inverted. The current check:</p>
     * <pre>
     *   if (type != "StandardApartment" || type != "Penthouse" || type != "GardenApartment")
     * </pre>
     * <p>is always {@code true} due to use of {@code ||} — any string will differ from
     * at least two of the three literals. This means the method always returns {@code -1}.
     * The condition should use {@code &&} (AND) instead of {@code ||} (OR), and string
     * comparison should use {@code .equals()} instead of {@code !=}:</p>
     * <pre>
     *   if (!type.equals("StandardApartment") &amp;&amp; !type.equals("Penthouse") &amp;&amp; !type.equals("GardenApartment"))
     * </pre>
     * <p><b>Also note:</b> String comparison with {@code !=} compares references, not content.
     * Always use {@code .equals()} for string value comparison in Java.</p>
     *
     * @param type the apartment type name to count; expected values are
     *             {@code "StandardApartment"}, {@code "Penthouse"}, or {@code "GardenApartment"}
     * @return the count of matching apartments, or {@code -1} if the type is invalid
     */
    public int countType(String type) {
        if (type != "StandardApartment" || type != "Penthouse" || type != "GardenApartment")
            return -1;
        int count = 0;
        for (Apartment apartment : apartments) {
            if (apartment.getClass().getSimpleName().equals(type)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Prints a formatted summary of this person's apartment ownership to standard output.
     *
     * <p>The output includes the person's name, the type and details of each apartment,
     * and the total property value. Uses string concatenation in a loop, which may be
     * inefficient for large numbers of apartments — consider using {@link StringBuilder}.</p>
     *
     * <p>Example output:</p>
     * <pre>
     * Name: John Doe
     *  Apartments:
     * {
     * Type: Penthouse
     * Penthouse [...]
     * }Total value: 950000
     * </pre>
     */
    public void printOwnershipDetails() {
        String s = "Name: " + this.getName() + "\n Apartments:\n";
        for (int i = 0; i < this.apartments.length; i++) {
            s += "{ Type: " + this.getApartmentType(this.apartments[i]) + "|" + this.apartments[i].toString() + "}\n";
        }
        s += "Total value: " + this.getTotalPropertyValue();
        System.out.println(s);
    }
}