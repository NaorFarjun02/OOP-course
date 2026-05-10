public abstract class Apartment {
    private int number;
    private int area;
    private boolean isSold;
    protected int price;

    public Apartment(int number, int area, boolean isSold) {
        this.setNumber(number);
        this.setArea(area);
        this.setSold(isSold);
        this.setPrice(700000);
    }

    public Apartment(Apartment apartment) {
        this.setNumber(apartment.getNumber());
        this.setArea(apartment.getArea());
        this.setSold(apartment.isSold());
        this.setPrice(apartment.getPrice());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean isSold) {
        this.isSold = isSold;
    }

    public abstract int getPrice();

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "{" +
                "number=" + number +
                ", area=" + area +
                ", price=" + price +
                '}';
    }
}
