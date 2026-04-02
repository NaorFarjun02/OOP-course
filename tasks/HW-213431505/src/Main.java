// Assignment: 1
// Author: Naor Farjun, ID: 213431505

public class Main {

    public static void main(String[] args) {
        PizzaOrder order1 = new PizzaOrder("Joy", "Amar", "0508146795");
        PizzaOrder order2 = new PizzaOrder("Ben", "Biton", "0508564976");
        PizzaOrder order3 = new PizzaOrder("Hen", "Cohen", "0548167498");
        PizzaOrder order4 = new PizzaOrder("Mosha", "Turjeman", "0523546798");

        PizzaOrder openOrder[] = new PizzaOrder[]{order1, order2, order3, order4};
        PizzaOrder[] inProgressOrders = new PizzaOrder[4];

        int completeOrders = 0;
        while (completeOrders < 4) {
            PizzaOrderMain.callCustomerToOrder(openOrder, inProgressOrders);
            completeOrders = 0;
            for (int i = 0; i < inProgressOrders.length; i++) {
                if (inProgressOrders[i] != null && inProgressOrders[i].getIsOrdered()) {
                    completeOrders++;
                }
            }
        }

        int readyToPickupOrders = 0;
        while (readyToPickupOrders < 4) {
            PizzaOrderMain.callCustomerToPickup(inProgressOrders);
            readyToPickupOrders = 0;
            for (int i = 0; i < inProgressOrders.length; i++) {
                if (inProgressOrders[i] != null && inProgressOrders[i].getIsReady()) {
                    readyToPickupOrders++;
                }
            }
        }


    }
}
