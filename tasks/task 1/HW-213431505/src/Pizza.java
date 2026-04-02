// Assignment: 1
// Author: Naor Farjun, ID: 213431505

public class Pizza {
    int size;
    boolean extraCheese;
    boolean olives;
    boolean onion;

    public Pizza() {
        this.size = 0;
        this.extraCheese = false;
        this.olives = false;
        this.onion = false;
    }

    public Pizza(int size, boolean extraCheese, boolean olives, boolean onion) {
        this.setSize(size);
        this.setExtraCheese(extraCheese);
        this.setOlives(olives);
        this.setOnion(onion);
    }

    public Pizza(Pizza pizza) {
        this.setSize(pizza.size);
        this.setExtraCheese(pizza.extraCheese);
        this.setOlives(pizza.olives);
        this.setOnion(pizza.onion);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public boolean getExtraCheese() {
        return this.extraCheese;
    }

    public void setOlives(boolean olives) {
        this.olives = olives;
    }

    public boolean getOlives() {
        return this.olives;
    }

    public void setOnion(boolean onion) {
        this.onion = onion;
    }

    public boolean getOnion() {
        return this.onion;
    }


    public int calcCost() {
        int totalCost = 0;
        if (this.size == 0) {
            totalCost += 35;
            totalCost = this.extraCheese ? totalCost + 6 : totalCost + 0;
            totalCost = this.olives ? totalCost + 6 : totalCost + 0;
            totalCost = this.onion ? totalCost + 6 : totalCost + 0;
        } else if (this.size == 1) {
            totalCost += 45;
            totalCost = this.extraCheese ? totalCost + 7 : totalCost + 0;
            totalCost = this.olives ? totalCost + 7 : totalCost + 0;
            totalCost = this.onion ? totalCost + 7 : totalCost + 0;
        } else if (this.size == 2) {
            totalCost += 60;
            totalCost = this.extraCheese ? totalCost + 9 : totalCost + 0;
            totalCost = this.olives ? totalCost + 9 : totalCost + 0;
            totalCost = this.onion ? totalCost + 9 : totalCost + 0;
        }

        return totalCost;
    }


    public String toString() {
        String[] sizes = {"Small", "Medium", "Large"};
        String pizzeDetails = "";
        pizzeDetails += "Pizza Details:\n";
        pizzeDetails += "Size: " + sizes[this.size] + "\n";
        pizzeDetails += "Extra Cheese: " + this.extraCheese + ", Olives: " + this.olives + ", Onions: " + this.onion + "\n";
        pizzeDetails += "Price: " + this.calcCost() + "\n";
        return pizzeDetails;

    }
}
