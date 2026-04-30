import java.awt.*;

public class Circle extends Shape {

    private double radius;

    public Circle(){
        super();
        this.setRadius(1.0);
    }
    public Circle(double radius){
        super();
        this.setRadius(radius);
    }
    public Circle(double radius, String color){
        super(color);
        this.setRadius(radius);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea(){
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString(){
        String shape=super.toString();
        return "Circle["+shape+",radius="+this.getRadius()+"]";
    }
}
