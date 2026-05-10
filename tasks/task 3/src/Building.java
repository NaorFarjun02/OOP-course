public class Building {

    private String address;
    private int numberOfFloors;
    private Apartment[] apartments;

    public Building(String address, Apartment[] apartments) {
        this.setAddress(address);
        this.setApartments(apartments);
        this.setNumberOfFloors(apartments.length);
    }

    public Building(Building b) {
        this.setAddress(b.getAddress());
        this.setApartments(b.getApartments());
        this.setNumberOfFloors(b.getNumberOfFloors());
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfFloors() {
        return this.numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Apartment[] getApartments() {
        return this.apartments;
    }

    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }


    public Apartment findApartmentByNumber(int number) {
        for (int i = 0; i < getApartments().length; i++) {
            if (getApartments()[i].getNumber() == number) {
                return getApartments()[i];
            }
        }
        return null;
    }

    public int getTotalValue() {
        int sum = 0;
        for (int i = 0; i < getApartments().length; i++) {
            sum += getApartments()[i].getPrice();
        }
        return sum;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < this.getApartments().length; i++) {
            s += this.getApartments()[i].toString();
        }
        return s;
    }


    public void printAvailableApartments() {
        for (int i = 0; i < getApartments().length; i++) {
            if (!getApartments()[i].isSold()) {
                System.out.println(getApartments()[i].toString());
            }
        }
    }


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
}
