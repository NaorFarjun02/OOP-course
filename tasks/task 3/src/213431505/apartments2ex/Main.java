package apartments2ex;

import java.util.Arrays;
import java.util.Scanner;

// Assignment: 2
// Author: Naor Farjun, ID: 213431505
/**
 * Entry point for the Real Estate Management System.
 * Handles the user interface, menu logic, and coordinates between People, Buildings, and Apartments.
 */
public class Main {

    static final int NUM_BUILDINGS = 3;
    static final int NUM_PEOPLE = 4;
    static final int B_SIZE = 6;
    static Scanner input = new Scanner(System.in);

    /**
     * Menu Option 2: Prompts for address and number to find a specific apartment.
     *
     * @param buildings The array of buildings to search in.
     */
    private static void menu_2(Building[] buildings) {
        System.out.print("Enter address: ");
        String address = input.nextLine();
        System.out.print("Enter apartment number: ");
        int number = input.nextInt();
        input.nextLine();
        for (int i = 0; i < buildings.length; i++) {
            if (buildings[i].getAddress().equals(address)) {
                System.out.println(buildings[i].findApartmentByNumber(number));
                break;
            }
        }
    }

    /**
     * Utility method to get the simple class name of an apartment.
     *
     * @param apartment The apartment to check.
     * @return The class name as a String.
     */
    private static String getAptType(Apartment apartment) {
        return apartment.getClass().getSimpleName();
    }

    /**
     * Menu Option 3: Prints all available standard apartments across all buildings.
     *
     * @param buildings The array of buildings to check.
     */
    private static void menu_3(Building[] buildings) {
        System.out.println("Available Standart apartments:");
        for (int i = 0; i < buildings.length; i++) {
            Apartment[] apt = buildings[i].getApartments();
            System.out.println("\nBuilding-" + (i + 1) + " Address:" + buildings[i].getAddress());
            for (int j = 0; j < apt.length; j++) {
                if (getAptType(apt[j]) == "StandardApartment" && !apt[j].isSold()) {
                    System.out.println(apt[j]);
                }
            }
            System.out.println();
        }
    }

    /**
     * Menu Option 4: Executes a purchase flow including budget check and buyer registration.
     *
     * @param buildings Array of buildings.
     * @param people    Array of current people/potential buyers.
     */
    private static Person[] menu_4(Building[] buildings, Person[] people) {
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        int personIndex = 0;
        int budget = -1;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getName().equals(firstName + " " + lastName)) {
                personIndex = i;
                System.out.print("Enter your budget: ");
                budget = input.nextInt();
                input.nextLine();
                break;
            }
        }
        if (budget == -1) {
            Person[] newPeople = Arrays.copyOf(people, people.length + 1);
            newPeople[people.length] = new Person(firstName, lastName);
            personIndex = people.length;
            people = newPeople;
            System.out.print("Enter your budget: ");
            budget = input.nextInt();
            input.nextLine();
        }

        int numOfAptToBuy = 0;
        for (int i = 0; i < buildings.length; i++) {
            numOfAptToBuy += buildings[i].printAptToBuyByBudget(budget);
        }
        if (numOfAptToBuy > 0) {
            System.out.print("Enter the address of the building you want to buy an apartment in: ");
            String add = input.nextLine();
            System.out.print("Enter the apartment number: ");
            int aptNumber = input.nextInt();
            input.nextLine();

            for (int i = 0; i < buildings.length; i++) {
                if (buildings[i].getAddress().equals(add)) {
                    if (buildings[i].buyApartmentByNumber(aptNumber)) {
                        people[personIndex].addApartment(buildings[i].findApartmentByNumber(aptNumber));
                        //If the but was ok then add the apt to person data
                    }
                }
            }
        }

        return people;
    }

    /**
     * Menu Option 5: Prints details of the last apartment (often Penthouse) in each building.
     *
     * @param buildings Array of buildings.
     */
    private static void menu_5(Building[] buildings) {
        for (Building b : buildings) {
            System.out.println(b.getApartments()[b.getApartments().length - 1]);
        }
    }

    /**
     * Menu Option 6: Finds and prints details of the person with the highest property value.
     *
     * @param people Array of Person objects.
     */
    private static void menu_6(Person[] people) {
        Person person = null;
        for (int i = 0; i < people.length; i++) {
            if (person == null || people[i].getTotalPropertyValue() >= person.getTotalPropertyValue()) {
                person = people[i];
            }
        }
        if (person != null) {
            person.printOwnershipDetails();
        }
    }

    /**
     * Menu Option 7: Prints the most expensive apartment for each building.
     *
     * @param buildings Array of buildings.
     */
    private static void menu_7(Building[] buildings) {
        for (Building b : buildings) {
            b.printMostExpensiveApt();
        }
    }

    /**
     * Menu Option 8: Prints available Garden Apartments that have a pool.
     *
     * @param buildings Array of buildings.
     */
    private static void menu_8(Building[] buildings) {
        for (Building b : buildings) {
            if (b.getApartments()[0] instanceof GardenApartment) {
                GardenApartment gApt = (GardenApartment) b.getApartments()[0];
                if (!gApt.isSold() && gApt.isHasPool()) {
                    System.out.println(gApt);
                }
            }
        }
    }

    /**
     * Main execution method. Initializes data and manages the interactive menu.
     *
     * @param args Command line arguments.
     */
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
                    System.out.println("Number 0f people with Standarda partment: " + count);
                    break;

                case 2:
                    menu_2(buildings);
                    break;

                case 3:
                    menu_3(buildings);
                    break;

                case 4:
                    people = menu_4(buildings, people);
                    break;

                case 5:
                    menu_5(buildings);
                    break;

                case 6:
                    menu_6(people);
                    break;

                case 7:
                    menu_7(buildings);
                    break;

                case 8:
                    menu_8(buildings);
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