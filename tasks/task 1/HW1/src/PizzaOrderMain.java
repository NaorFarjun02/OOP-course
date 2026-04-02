// Assignment: 1
// Author: Naor Farjun, ID: 213431505

/**
 * Utility class containing static methods that drive the pizza ordering workflow.
 * <p>
 * Provides two main operations:
 * <ul>
 *   <li>{@link #callCustomerToOrder} – randomly selects a pending order and prompts the customer to place it.</li>
 *   <li>{@link #callCustomerToPickup} – randomly selects a completed order and notifies the customer that it is ready.</li>
 * </ul>
 * </p>
 */
public class PizzaOrderMain {

    /**
     * Randomly selects a pending order from {@code openOrder} and initiates the ordering process.
     * <p>
     * A random index is chosen from the {@code openOrder} array. If the slot is non-null
     * and not yet ordered, the customer is prompted to place their order via
     * {@link PizzaOrder#order()}, the result is printed, the order is moved to
     * {@code inProgressOrders} at the same index, and the original slot is set to {@code null}.
     * If the randomly chosen slot is already ordered or null, the method returns without action.
     * </p>
     *
     * @param openOrder        array of orders waiting to be placed; slots are set to {@code null} once processed
     * @param inProgressOrders array where orders are stored after being placed
     */
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

    /**
     * Randomly selects a completed order from {@code inProgressOrders} and marks it as ready for pickup.
     * <p>
     * A random index is chosen. If the slot is non-null and the order has been placed
     * ({@link PizzaOrder#getIsOrdered()} is {@code true}), the order is marked as ready,
     * a pickup notification is printed to the console, and the slot is set to {@code null}.
     * If the randomly chosen slot is null or not yet ordered, the method returns without action.
     * </p>
     * <p>
     * Note: {@code inProgressOrders} is not null-checked in this method.
     * </p>
     *
     * @param inProgressOrders array of orders that have been placed and are being prepared
     */
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