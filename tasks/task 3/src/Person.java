public class Person {

    private String name;
    Apartment[] apartments;

    public Person(String firstName,String lastName) {
        this.setName(firstName+lastName);
    }

    public Person(Person person) {
        this.setName(person.getName());
        this.setApartments(person.getApartments());

    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setApartments(Apartment[] apartments) {
        this.apartments = new Apartment[apartments.length];
        for (int i = 0; i < apartments.length; i++) {
            this.apartments[i] = apartments[i];
        }
    }

    public Apartment[] getApartments() {
        return this.apartments;
    }


    public void addApartment(Apartment apt) {
        Apartment[] temp = new Apartment[this.apartments.length + 1];
        for (int i = 0; i < apartments.length; i++) {
            temp[i] = this.apartments[i];
        }
        temp[temp.length - 1] = apt;

        this.apartments = temp.clone();

    }


    public int getTotalPropertyValue() {
        int count = 0;
        for (int i = 0; i < this.apartments.length; i++) {
            count += this.apartments[i].getPrice();
        }
        return count;
    }

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

    public void printOwnershipDetails() {
        String s = "Name: " + this.getName() + "\n Apartments:\n";
        for (int i = 0; i < this.apartments.length; i++) {
            s += "{ \nType: " + this.getApartmentType(this.apartments[i]) + "\n" + this.apartments[i].toString() + "\n}";
        }
        s += "Total value: " + this.getTotalPropertyValue();

        System.out.println(s);
    }

}
