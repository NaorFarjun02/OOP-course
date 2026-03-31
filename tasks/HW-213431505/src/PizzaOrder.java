import java.util.Scanner;

public class PizzaOrder {

    Customer customer;
    Pizza[] pizzas;
    boolean isOrdered;
    boolean isReady;

    public PizzaOrder(String firstName, String lastName, String phoneNumber) {
        this.setCustomer(new Customer(firstName, lastName, phoneNumber));
        this.pizzas = null;
        this.isOrdered = false;
        this.isReady = false;
    }

    public PizzaOrder(PizzaOrder order) {
        this.setCustomer(order.customer);
        this.setPizzas(order.pizzas);
        this.setOrdered(order.isOrdered);
        this.setReady(order.isReady);
    }

    public void order() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of pizzas for " + this.customer.firstName + ": ");
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

    public int calcTotal() {
        int total = 0;
        for (int i = 0; i < this.pizzas.length; i++) {
            total += pizzas[i].calcCost();
        }
        return total;
    }


    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer);
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setPizzas(Pizza[] pizzas) {
        this.pizzas = new Pizza[pizzas.length];
        for (int i = 0; i < pizzas.length; i++) {
            this.pizzas[i] = pizzas[i];
        }
    }

    public Pizza[] getPizzas() {
        return pizzas;
    }


    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }

    public boolean isOrdered() {
        return isOrdered;
    }


    public void setReady(boolean ready) {
        isReady = ready;
    }

    public boolean isReady() {
        return isReady;
    }


    public String toString() {
        String pizzaOrder = "";
        pizzaOrder += this.customer.toString();
        for (int i = 0; i < this.pizzas.length; i++) {
            pizzaOrder += "Pizza #" + (i + 1) + ": /n" + this.pizzas[i].toString();
        }
        pizzaOrder += "Total Price: " + this.calcTotal();

        return pizzaOrder;
    }
}
