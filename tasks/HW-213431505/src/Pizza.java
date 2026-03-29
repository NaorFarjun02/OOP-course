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
        this.size = size;
        this.extraCheese = extraCheese;
        this.olives = olives;
        this.onion = onion;
    }

    public Pizza(Pizza pizza) {
        this.size = pizza.size;
        this.extraCheese = pizza.extraCheese;
        this.olives = pizza.olives;
        this.onion = pizza.onion;
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
        String[] sizes = {"Small", "Medium", "Large>"};
        String pizzeDetails = "";
        pizzeDetails += "Pizza Details:/n";
        pizzeDetails += "Size: " + sizes[this.size] + "/n";
        pizzeDetails += "Extra Cheese: " + this.extraCheese + ", Olives: " + this.olives + ", Onions: " + this.onion + "/n";
        pizzeDetails += "Price: " + this.calcCost();
        return pizzeDetails;

    }
}
