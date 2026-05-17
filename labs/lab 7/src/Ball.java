public class Ball implements Moveable {
    private int x = 0;
    private int y = 0;
    private int speed = 0;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public Point getPosition() {
        return new Point(x, y);
    }

    @Override
    public void moveLeft() {
        this.setX(this.getX() - 1);
    }

    @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        if (x != ball.x) return false;
        if (y != ball.y) return false;
        return speed == ball.speed;
    }


    @Override
    public String toString() {
        return "The ball is in position: " + this.getPosition() + "and his speed is " + this.getSpeed();
    }
}
