public class GardenApartment extends Apartment {
    private int gardenSize;
    private boolean hasPool;

    public GardenApartment(int number, int area, boolean isSold, int gardenSize, boolean hasPool) {
        super(number, area, isSold);
        this.setGardenSize(gardenSize);
        this.setHasPool(hasPool);
    }

    public GardenApartment(GardenApartment gardenApartment) {
        super(gardenApartment.getNumber(), gardenApartment.getArea(), gardenApartment.isSold());
        this.setGardenSize(gardenApartment.getGardenSize());
        this.setHasPool(gardenApartment.hasPool);
    }

    public int getGardenSize() {
        return gardenSize;
    }

    public void setGardenSize(int gardenSize) {
        this.gardenSize = gardenSize;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }


    @Override
    public int getPrice() {
        int price = this.price + 80000 + (this.getGardenSize() * 1000);
        return this.isHasPool() ? price : price + 100000;
    }

    @Override
    public String toString() {
        String s = "Garden apartment [" + super.toString();
        s += ",garden size:" + this.getGardenSize() + ", Pool:" + this.isHasPool() + " ]";
        return s;
    }
}
