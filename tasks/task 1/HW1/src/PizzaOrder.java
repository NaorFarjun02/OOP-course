// Assignment: 1
// Author: Naor Farjun, ID: 213431505

import java.util.Scanner;

/**
 * Represents a pizza order placed by a customer.
 * <p>
 * An order holds a reference to a {@link Customer}, an array of {@link Pizza} objects,
 * and two status flags: {@code isOrdered} (the customer has completed ordering)
 * and {@code isReady} (the order is ready for pickup).
 * </p>
 */
public class PizzaOrder {

    Customer customer;
    Pizza[] pizzas;
    boolean isOrdered;
    boolean isReady;

    /**
     * Constructs a new {@code PizzaOrder} for a customer identified by name and phone number.
     * <p>
     * The order starts with no pizzas, and both status flags set to {@code false}.
     * </p>
     *
     * @param firstName   the customer's first name
     * @param lastName    the customer's last name
     * @param phoneNumber the customer's phone number
     */
    public PizzaOrder(String firstName, String lastName, String phoneNumber) {
        this.setCustomer(new Customer(firstName, lastName, phoneNumber));
        this.pizzas = null;
        this.isOrdered = false;
        this.isReady = false;
    }

    /**
     * Copy constructor. Creates a new {@code PizzaOrder} copied from an existing one.
     * <p>
     * Note: if the source order's {@code pizzas} array is {@code null} (order not yet placed),
     * calling {@link #setPizzas} will throw a {@code NullPointerException}.
     * </p>
     *
     * @param order the {@code PizzaOrder} to copy
     */
    public PizzaOrder(PizzaOrder order) {
        this.setCustomer(order.customer);
        this.setPizzas(order.pizzas);
        this.setOrdered(order.isOrdered);
        this.setReady(order.isReady);
    }

    /**
     * Interactively collects pizza details from the user via the console.
     * <p>
     * Prompts the user to enter the number of pizzas and, for each pizza,
     * its size and toppings. Sets {@code isOrdered} to {@code true} upon completion.
     * </p>
     */
    public void order() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter number of pizzas for " + this.customer.firstName + ": ");
        int numberOfPizzas = input.nextInt();
        this.pizzas = new Pizza[numberOfPizzas];
        for (int i = 1; i <= numberOfPizzas; i++) {
            System.out.println("Pizza #" + i);
            System.out.print("Size (0=Small,1=Medium,2=Large): ");
            int size = input.nextInt();
            System.out.print("Extra Cheese (true/false): ");
            boolean extraCheese = input.nextBoolean();
            System.out.print("Olives (true/false): ");
            boolean olives = input.nextBoolean();
            System.out.print("Onion (true/false): ");
            boolean onion = input.nextBoolean();
            pizzas[i - 1] = new Pizza(size, extraCheese, olives, onion);
        }
        this.isOrdered = true;

    }

    /**
     * Calculates the total cost of all pizzas in this order.
     *
     * @return the sum of {@link Pizza#calcCost()} for every pizza in the order
     */
    public int calcTotal() {
        int total = 0;
        for (int i = 0; i < this.pizzas.length; i++) {
            total += pizzas[i].calcCost();
        }
        return total;
    }

    /**
     * Sets the customer for this order using a defensive copy.
     *
     * @param customer the {@code Customer} to associate with this order
     */
    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer);
    }

    /**
     * Returns the customer associated with this order.
     *
     * @return the {@link Customer}
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Sets the pizzas array for this order using a shallow copy of the given array.
     *
     * @param pizzas the array of {@link Pizza} objects to set
     */
    public void setPizzas(Pizza[] pizzas) {
        this.pizzas = new Pizza[pizzas.length];
        for (int i = 0; i < pizzas.length; i++) {
            this.pizzas[i] = pizzas[i];
        }
    }

    /**
     * Returns the array of pizzas in this order.
     *
     * @return the {@link Pizza} array
     */
    public Pizza[] getPizzas() {
        return pizzas;
    }

    /**
     * Sets whether the customer has completed placing the order.
     *
     * @param ordered {@code true} if the order has been placed
     */
    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }

    /**
     * Returns whether the customer has completed placing the order.
     *
     * @return {@code true} if the order has been placed
     */
    public boolean getIsOrdered() {
        return isOrdered;
    }

    /**
     * Sets whether the order is ready for pickup.
     *
     * @param ready {@code true} if the order is ready
     */
    public void setReady(boolean ready) {
        isReady = ready;
    }

    /**
     * Returns whether the order is ready for pickup.
     *
     * @return {@code true} if the order is ready
     */
    public boolean getIsReady() {
        return isReady;
    }

    /**
     * Returns a formatted string summarizing the entire order.
     * <p>
     * Includes customer details, each pizza's details, and the total price.
     * </p>
     *
     * @return a multi-line string describing the order
     */
    public String toString() {
        String pizzaOrder = "";
        pizzaOrder += this.customer.toString() + '\n';
        for (int i = 0; i < this.pizzas.length; i++) {
            pizzaOrder += "Pizza #" + (i + 1) + ": \n" + this.pizzas[i].toString();
        }
        pizzaOrder += "Total Price: " + this.calcTotal() + '\n';

        return pizzaOrder;
    }
}