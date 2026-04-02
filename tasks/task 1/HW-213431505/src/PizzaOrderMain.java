// Assignment: 1
// Author: Naor Farjun, ID: 213431505

public class PizzaOrderMain {


    static void callCustomerToOrder(PizzaOrder openOrder[], PizzaOrder inProgressOrders[]) {
        if (openOrder == null || inProgressOrders == null) {
            System.out.println("Error - order arrays can't be null.");
            return;
        }
        int randomOrder = (int) (Math.random() * openOrder.length);
        PizzaOrder customerOrder = openOrder[randomOrder];

        if (customerOrder != null && !customerOrder.getIsOrdered()) {
            inProgressOrders[randomOrder] = openOrder[randomOrder];
            customerOrder.order();
            System.out.print(customerOrder.toString());
            openOrder[randomOrder] = null;
        }


    }

    static void callCustomerToPickup(PizzaOrder inProgressOrders[]) {
        int randomOrder = (int) (Math.random() * inProgressOrders.length);
        PizzaOrder pickupOrder = inProgressOrders[randomOrder];

        if (pickupOrder != null && pickupOrder.getIsOrdered()) {
            pickupOrder.setReady(true);
            System.out.print(pickupOrder.getCustomer().getFirstName() + ", your order is ready! Please come and collect it.\n");
            inProgressOrders[randomOrder] = null;
        }
    }
}
