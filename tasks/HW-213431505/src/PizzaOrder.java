public class PizzaOrder {

    Customer customer;
    Pizza[] pizzas;
    boolean isOrdered;
    boolean isReady;

    public PizzaOrder(String firstName, String lastName, String phoneNumber) {
        this.customer = new Customer(firstName, lastName, phoneNumber);
        this.pizzas = null;
        this.isOrdered = false;
        this.isReady = false;
    }

    public PizzaOrder(PizzaOrder order) {
        this.customer = new Customer(order.customer);
        this.pizzas = new Pizza[order.pizzas.length];
        for (int i = 0; i < order.pizzas.length; i++) {
            this.pizzas[i] = order.pizzas[i];
        }
        this.isOrdered = order.isOrdered;
        this.isReady = order.isReady;
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
}
