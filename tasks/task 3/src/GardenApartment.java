/**
 * Represents a specialized Apartment that includes a garden and potentially a pool.
 * Extends the basic Apartment class.
 */
public class GardenApartment extends Apartment {
    private int gardenSize;
    private boolean hasPool;

    /**
     * Constructs a new GardenApartment.
     * @param number Apartment number.
     * @param area Living area size.
     * @param isSold Sales status.
     * @param gardenSize Size of the garden in square meters.
     * @param hasPool Indicates if there is a swimming pool.
     */
    public GardenApartment(int number, int area, boolean isSold, int gardenSize, boolean hasPool) {
        super(number, area, isSold);
        this.setGardenSize(gardenSize);
        this.setHasPool(hasPool);
    }

    /**
     * Copy constructor for GardenApartment.
     * @param gardenApartment The source object to copy.
     */
    public GardenApartment(GardenApartment gardenApartment) {
        super(gardenApartment.getNumber(), gardenApartment.getArea(), gardenApartment.isSold());
        this.setGardenSize(gardenApartment.getGardenSize());
        this.setHasPool(gardenApartment.hasPool);
    }

    /** @return The size of the garden. */
    public int getGardenSize() {
        return gardenSize;
    }

    /** @param gardenSize The garden size to set. */
    public void setGardenSize(int gardenSize) {
        this.gardenSize = gardenSize;
    }

    /** @return true if it has a pool, false otherwise. */
    public boolean isHasPool() {
        return hasPool;
    }

    /** @param hasPool The pool status to set. */
    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    /**
     * Calculates the final price based on base price, garden size, and pool availability.
     * @return Total price of the garden apartment.
     */
    @Override
    public int getPrice() {
        int price = this.price + 80000 + (this.getGardenSize() * 1000);
        return this.isHasPool() ? price : price + 100000;
    }

    /** @return Comprehensive string details of the garden apartment. */
    @Override
    public String toString() {
        String s = "Garden apartment [" + super.toString();
        s += ",garden size:" + this.getGardenSize() + "-Square meter, Pool:" + this.isHasPool() + " ]";
        return s;
    }
}