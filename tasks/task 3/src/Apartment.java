/**
 * Abstract base class representing a generic Apartment.
 * Defines common properties such as number, area, and sales status.
 */
public abstract class Apartment {
    private int number;
    private int area;
    private boolean isSold;
    protected int price;

    /**
     * Constructs a new Apartment with basic details and a default base price.
     * @param number The apartment identification number.
     * @param area The total area of the apartment in square meters.
     * @param isSold The current sales status of the apartment.
     */
    public Apartment(int number, int area, boolean isSold) {
        this.setNumber(number);
        this.setArea(area);
        this.setSold(isSold);
        this.setPrice(700000);
    }

    /**
     * Copy constructor for creating a new Apartment from an existing one.
     * @param apartment The Apartment object to copy.
     */
    public Apartment(Apartment apartment) {
        this.setNumber(apartment.getNumber());
        this.setArea(apartment.getArea());
        this.setSold(apartment.isSold());
        this.setPrice(apartment.getPrice());
    }

    /** @return The apartment number. */
    public int getNumber() {
        return number;
    }

    /** @param number The apartment number to set. */
    public void setNumber(int number) {
        this.number = number;
    }

    /** @return The area of the apartment. */
    public int getArea() {
        return area;
    }

    /** @param area The area to set. */
    public void setArea(int area) {
        this.area = area;
    }

    /** @return true if the apartment is sold, false otherwise. */
    public boolean isSold() {
        return isSold;
    }

    /** @param isSold The sales status to set. */
    public void setSold(boolean isSold) {
        this.isSold = isSold;
    }

    /**
     * Abstract method to calculate the final price of the apartment.
     * Implementation varies based on the specific type of apartment.
     * @return The calculated price.
     */
    public abstract int getPrice();

    /** @param price The base price to set. */
    public void setPrice(int price) {
        this.price = price;
    }

    /** @return A string representation of the apartment's basic details. */
    public String toString() {
        return "{" +
                "number=" + this.getNumber() +
                ", area=" + this.getArea() +
                ", price=" + this.getPrice() +
                '}';
    }
}