import java.util.Scanner;

public class Main {

    static final int NUM_BUILDINGS = 3;
    static final int NUM_PEOPLE = 4;
    static final int B_SIZE = 6;

    public static void main(String[] args) {

        // ============================
        // People
        // ============================
        Person[] people = new Person[NUM_PEOPLE];

        people[0] = new Person("Alice", "Smith");
        people[1] = new Person("Bob", "Johnson");
        people[2] = new Person("Charlie", "Williams");
        people[3] = new Person("Diana", "Brown");

        // ============================
        // Buildings + Apartments
        // ============================

        Apartment[] building1Apartments = new Apartment[B_SIZE];
        building1Apartments[0] = new GardenApartment(101, 120, false, 50, true);
        building1Apartments[1] = new StandardApartment(201, 80, false, 2, new int[]{5, 7});
        building1Apartments[2] = new StandardApartment(202, 85, false, 1, new int[]{6});
        building1Apartments[3] = new StandardApartment(301, 75, false, 1, new int[]{4});
        building1Apartments[4] = new StandardApartment(302, 90, false, 2, new int[]{5, 5});
        building1Apartments[5] = new Penthouse(401, 210, false, 60);

        Building building1 = new Building("123 Main St", building1Apartments);

        Apartment[] building2Apartments = new Apartment[B_SIZE];
        building2Apartments[0] = new GardenApartment(101, 100, false, 40, false);
        building2Apartments[1] = new StandardApartment(201, 70, false, 1, new int[]{5});
        building2Apartments[2] = new StandardApartment(202, 80, false, 2, new int[]{6, 4});
        building2Apartments[3] = new StandardApartment(301, 75, false, 1, new int[]{5});
        building2Apartments[4] = new StandardApartment(302, 85, false, 2, new int[]{5, 5});
        building2Apartments[5] = new Penthouse(401, 220, false, 55);

        Building building2 = new Building("456 Oak Ave", building2Apartments);

        Apartment[] building3Apartments = new Apartment[B_SIZE];
        building3Apartments[0] = new GardenApartment(101, 130, false, 60, true);
        building3Apartments[1] = new StandardApartment(201, 78, false, 2, new int[]{4, 5});
        building3Apartments[2] = new StandardApartment(202, 82, false, 1, new int[]{6});
        building3Apartments[3] = new StandardApartment(301, 76, false, 2, new int[]{5, 4});
        building3Apartments[4] = new StandardApartment(302, 88, false, 1, new int[]{5});
        building3Apartments[5] = new Penthouse(401, 200, false, 50);

        Building building3 = new Building("789 Pine Rd", building3Apartments);

        Building[] buildings = {building1, building2, building3};

        // ============================
        // Menu
        // ============================

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMENU OPTIONS:");
            System.out.println("1. Print all people with standard apartments");
            System.out.println("2. Print apartment details by number and building address");
            System.out.println("3. Print all standard apartments with 2 balconies that are not sold");
            System.out.println("4. Buy an apartment");
            System.out.println("5. Print all penthouse prices");
            System.out.println("6. Print the richest owner");
            System.out.println("7. Print most expensive apartment in each building");
            System.out.println("8. Print all garden apartments with pool that are not sold");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    int count = 0;
                    for (int i = 0; i < people.length; i++) {
                        count = people[i].countType("StandardApartment") > 0 ? count + 1 : count;
                    }
                    System.out.println("Number f people with Standarda partment: " + count);

                case 2:
                    // TODO
                    break;

                case 3:
                    // TODO
                    break;

                case 4:
                    // TODO
                    break;

                case 5:
                    // TODO
                    break;

                case 6:
                    // TODO
                    break;

                case 7:
                    // TODO
                    break;

                case 8:
                    // TODO
                    break;

                case 9:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 9);

    }
}