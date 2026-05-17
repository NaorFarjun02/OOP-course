/**
 * This is a simple solution.Point class that represents a point in a 2D space.
 */
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of the point.
     * @return the x-coordinate of the point as an int.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the point.
     * @return the y-coordinate of the point as an int.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the x-coordinate of the point.
     * @param x the new x-coordinate of the point.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of the point.
     * @param y the new y-coordinate of the point.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns a String representation of the point.
     * @return a String representation of the point.
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
