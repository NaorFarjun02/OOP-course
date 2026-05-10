public class Penthouse extends Apartment {

    private int balconieSize;

    public Penthouse(int number, int area, boolean isSold, int balconieSize) {
        super(number, area, isSold);
        this.setBalconieSize(balconieSize);
    }

    public Penthouse(Penthouse penthouse) {
        super(penthouse.getNumber(), penthouse.getArea(), penthouse.isSold());
        this.setBalconieSize(penthouse.balconieSize);
    }

    public int getBalconieSize() {
        return balconieSize;
    }

    public void setBalconieSize(int balconieSize) {
        this.balconieSize = balconieSize;
    }

    public boolean isLuxury() {
        return this.getArea() > 200 && this.getBalconieSize() > 50;
    }


    @Override
    public int getPrice() {
        return this.price + (this.getArea() * 3000) + (this.getBalconieSize() * 2000);
    }

    @Override
    public String toString() {
        String s = "Garden apartment [" + super.toString();

        return s;
    }
}
