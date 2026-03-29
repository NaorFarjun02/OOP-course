public class Customer {

    String firstName;
    String lastName;
    String phoneNumber;

    public Customer(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Customer(Customer customer) {
        this.firstName = customer.firstName;
        this.lastName = customer.lastName;
        this.phoneNumber = customer.phoneNumber;
    }

    public String toString() {
        String customerDetails = "";
        customerDetails += "Customer Details: /n";
        customerDetails += "Name: " + this.firstName + " " + this.lastName;
        customerDetails += "Phone: " + this.phoneNumber;

        return customerDetails;
    }

}
