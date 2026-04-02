// Assignment: 1
// Author: Naor Farjun, ID: 213431505

/**
 * Represents a pizza with a chosen size and optional toppings.
 * <p>
 * Size is represented as an integer:
 * <ul>
 *   <li>0 – Small (base price: 35)</li>
 *   <li>1 – Medium (base price: 45)</li>
 *   <li>2 – Large (base price: 60)</li>
 * </ul>
 * Optional toppings (extra cheese, olives, onion) each add a fixed cost
 * that depends on the chosen size.
 * </p>
 */
public class Pizza {
    int size;
    boolean extraCheese;
    boolean olives;
    boolean onion;

    /**
     * Constructs a default {@code Pizza} with size 0 (Small) and no toppings.
     */
    public Pizza() {
        this.size = 0;
        this.extraCheese = false;
        this.olives = false;
        this.onion = false;
    }

    /**
     * Constructs a {@code Pizza} with the specified size and toppings.
     *
     * @param size        the pizza size (0=Small, 1=Medium, 2=Large)
     * @param extraCheese {@code true} if extra cheese is requested
     * @param olives      {@code true} if olives are requested
     * @param onion       {@code true} if onion is requested
     */
    public Pizza(int size, boolean extraCheese, boolean olives, boolean onion) {
        this.setSize(size);
        this.setExtraCheese(extraCheese);
        this.setOlives(olives);
        this.setOnion(onion);
    }

    /**
     * Copy constructor. Creates a new {@code Pizza} that is an independent
     * copy of the given pizza.
     *
     * @param pizza the {@code Pizza} to copy
     */
    public Pizza(Pizza pizza) {
        this.setSize(pizza.size);
        this.setExtraCheese(pizza.extraCheese);
        this.setOlives(pizza.olives);
        this.setOnion(pizza.onion);
    }

    /**
     * Sets the pizza size.
     *
     * @param size the size (0=Small, 1=Medium, 2=Large)
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Returns the pizza size.
     *
     * @return the size (0=Small, 1=Medium, 2=Large)
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Sets whether extra cheese is added.
     *
     * @param extraCheese {@code true} to add extra cheese
     */
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    /**
     * Returns whether the pizza has extra cheese.
     *
     * @return {@code true} if extra cheese was requested
     */
    public boolean getExtraCheese() {
        return this.extraCheese;
    }

    /**
     * Sets whether olives are added.
     *
     * @param olives {@code true} to add olives
     */
    public void setOlives(boolean olives) {
        this.olives = olives;
    }

    /**
     * Returns whether the pizza has olives.
     *
     * @return {@code true} if olives were requested
     */
    public boolean getOlives() {
        return this.olives;
    }

    /**
     * Sets whether onion is added.
     *
     * @param onion {@code true} to add onion
     */
    public void setOnion(boolean onion) {
        this.onion = onion;
    }

    /**
     * Returns whether the pizza has onion.
     *
     * @return {@code true} if onion was requested
     */
    public boolean getOnion() {
        return this.onion;
    }

    /**
     * Calculates the total cost of this pizza based on its size and toppings.
     * <p>
     * Base prices and topping costs per size:
     * <ul>
     *   <li>Small  (0): base 35, each topping +6</li>
     *   <li>Medium (1): base 45, each topping +7</li>
     *   <li>Large  (2): base 60, each topping +9</li>
     * </ul>
     * </p>
     *
     * @return the total cost in currency units
     */
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

    /**
     * Returns a formatted string with this pizza's details.
     *
     * @return a string describing the size, toppings, and price of the pizza
     */
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