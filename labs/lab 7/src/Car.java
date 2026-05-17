
public class Car implements Moveable {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void moveLeft() {
        this.setPosition(position - 1);
    }

    @Override
    public void moveRight() {
        this.setPosition(position + 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return position == car.position;
    }

    @Override
    public String toString() {
        return "The car is in position: " + this.getPosition();
    }


}