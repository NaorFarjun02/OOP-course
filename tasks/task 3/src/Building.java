/**
 * Represents a residential building with a specific address and a collection of apartments.
 * This class provides methods to manage and query apartments within the building.
 */
public class Building {

    private String address;
    private int numberOfFloors;
    private Apartment[] apartments;

    /**
     * Constructs a new Building with a specified address and array of apartments.
     * @param address The physical address of the building.
     * @param apartments An array of Apartment objects contained in the building.
     */
    public Building(String address, Apartment[] apartments) {
        this.setAddress(address);
        this.setApartments(apartments);
        this.setNumberOfFloors(apartments.length);
    }

    /**
     * Copy constructor for Creating a new Building based on an existing one.
     * @param b The Building object to copy.
     */
    public Building(Building b) {
        this.setAddress(b.getAddress());
        this.setApartments(b.getApartments());
        this.setNumberOfFloors(b.getNumberOfFloors());
    }

    /** @return The address of the building. */
    public String getAddress() {
        return this.address;
    }

    /** @param address The address to set for the building. */
    public void setAddress(String address) {
        this.address = address;
    }

    /** @return The number of floors in the building. */
    public int getNumberOfFloors() {
        return this.numberOfFloors;
    }

    /** @param numberOfFloors The number of floors to set. */
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    /** @return An array of all apartments in the building. */
    public Apartment[] getApartments() {
        return this.apartments;
    }

    /** @param apartments The array of apartments to set for this building. */
    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }

    /**
     * Searches for an apartment by its unique number within the building.
     * @param number The apartment number to find.
     * @return The Apartment object if found, null otherwise.
     */
    public Apartment findApartmentByNumber(int number) {
        for (int i = 0; i < getApartments().length; i++) {
            if (getApartments()[i].getNumber() == number) {
                return getApartments()[i];
            }
        }
        return null;
    }

    /**
     * Prints available apartments (not sold) that fall within the specified budget.
     * @param budget The maximum price the buyer is willing to pay.
     * @return Always returns null as per current implementation.
     */
    public int printAptToBuyByBudget(int budget) {
        Apartment[] apts = getApartments();
        int count = 0;
        System.out.println("\nThe apartments at " + this.getAddress() + " are:");
        for (int i = 0; i < apts.length; i++) {
            if (!apts[i].isSold() && apts[i].getPrice() <= budget) {
                System.out.println(apts[i]);
                count++;
            }
        }
        return count;
    }

    /**
     * Marks a specific apartment as sold based on its number.
     * @param number The number of the apartment to be bought.
     */
    public boolean buyApartmentByNumber(int number) {
        Apartment[] apts = getApartments();
        for (Apartment apt : apts) {
            if (apt.getNumber() == number) {
                if (apt.isSold()) {
                    return false;
                }
                apt.setSold(true);
            }
        }
        return true;
    }

    /**
     * Calculates the total financial value of all apartments in the building.
     * @return The sum of prices of all apartments.
     */
    public int getTotalValue() {
        int sum = 0;
        for (int i = 0; i < getApartments().length; i++) {
            sum += getApartments()[i].getPrice();
        }
        return sum;
    }

    /** @return A string representation of all apartments in the building. */
    public String toString() {
        String s = "";
        for (int i = 0; i < this.getApartments().length; i++) {
            s += this.getApartments()[i].toString();
        }
        return s;
    }

    /**
     * Prints details of all apartments that are currently not sold.
     */
    public void printAvailableApartments() {
        for (int i = 0; i < getApartments().length; i++) {
            if (!getApartments()[i].isSold()) {
                System.out.println(getApartments()[i].toString());
            }
        }
    }

    /**
     * Counts the number of apartments of a specific type.
     * @param type The class name of the apartment type (e.g., "Penthouse").
     * @return The count of apartments of that type, or -1 if the type is invalid.
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
     * Finds and prints the details of the apartment with the highest price in the building.
     */
    public void printMostExpensiveApt() {
        Apartment apt = this.getApartments()[0];
        for (Apartment a : this.getApartments()) {
            if (a.getPrice() > apt.getPrice()) {
                apt = a;
            }
        }
        System.out.println("The most expensive apartment in " + this.getAddress() + " is " + apt);
    }
}