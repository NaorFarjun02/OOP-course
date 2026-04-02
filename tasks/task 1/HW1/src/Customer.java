// Assignment: 1
// Author: Naor Farjun, ID: 213431505

/**
 * Represents a customer with basic contact information.
 * <p>
 * Stores the customer's first name, last name, and phone number,
 * and provides getters, setters, and a copy constructor to avoid
 * unintended reference sharing.
 * </p>
 */
public class Customer {

    String firstName;
    String lastName;
    String phoneNumber;

    /**
     * Constructs a new {@code Customer} with the given details.
     *
     * @param firstName   the customer's first name
     * @param lastName    the customer's last name
     * @param phoneNumber the customer's phone number
     */
    public Customer(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Copy constructor. Creates a new {@code Customer} that is an independent
     * copy of the given customer.
     *
     * @param customer the {@code Customer} to copy
     */
    public Customer(Customer customer) {
        this.firstName = customer.firstName;
        this.lastName = customer.lastName;
        this.phoneNumber = customer.phoneNumber;
    }

    /**
     * Returns a formatted string with the customer's details.
     *
     * @return a string in the format:
     *         {@code "Customer Details: \nName: <firstName> <lastName> Phone: <phoneNumber>"}
     */
    public String toString() {
        String customerDetails = "";
        customerDetails += "Customer Details: \n";
        customerDetails += "Name: " + this.firstName + " " + this.lastName;
        customerDetails += " Phone: " + this.phoneNumber;

        return customerDetails;
    }

    /**
     * Sets the customer's first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the customer's first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the customer's last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the customer's last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the customer's phone number.
     *
     * @param phoneNumber the new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the customer's phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

}