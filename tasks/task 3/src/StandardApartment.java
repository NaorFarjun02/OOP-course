public class StandardApartment extends Apartment {

    private int[] balconiesSize = new int[2];

    public StandardApartment(int number, int area, boolean isSold, int[] balconiesSize) {
        super(number, area, isSold);
        this.balconiesSize = balconiesSize;
    }

    public StandardApartment(StandardApartment standardApartment) {
        super(standardApartment.getNumber(), standardApartment.getArea(), standardApartment.isSold());
        this.setBalconiesSize(standardApartment.getBalconiesSize());
    }

    public int[] getBalconiesSize() {
        return this.balconiesSize;
    }

    public void setBalconiesSize(int[] balconiesSize) {
        this.balconiesSize = balconiesSize;
    }

    @Override
    public int getPrice() {
        return this.price + (getNumBalconies() * 12000);
    }

    public int getNumBalconies() {
        int num = 0;
        num = this.balconiesSize[0] > 0 ? num : num++;
        num = this.balconiesSize[1] > 0 ? num : num++;
        return num;
    }

    @Override
    public String toString() {
        String s = "Standart apartment [" + super.toString();
        s += ", balconiesSize={ B1:" + this.balconiesSize[0] + ", B2:" + this.balconiesSize[1] + " }]";
        return s;
    }
}
