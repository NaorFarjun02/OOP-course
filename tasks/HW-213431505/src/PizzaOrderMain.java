public class PizzaOrderMain {
    public void callCustomerToOrder(PizzaOrder openOrder[], PizzaOrder inProgressOrders[]) {
        int randomOrder = (int) (Math.random() * openOrder.length);
        inProgressOrders[randomOrder] = openOrder[randomOrder];
        openOrder[randomOrder] = null;
    }

    public void callCustomerToPickup(PizzaOrder inProgressOrders[]) {

    }
}
