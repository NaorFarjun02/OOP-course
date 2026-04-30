public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(){
        super();
        this.setWidth(1.0);
        this.setLength(1.0);
    }
    public Rectangle(double width, double length){
        super();
        this.setWidth(width);
        this.setLength(length);
    }
    public Rectangle(double width, double length, String color){
        super(color);
        this.setWidth(width);
        this.setLength(length);
    }
    public double getWidth(){
        return width;
    }
    public double getLength(){
        return this.length;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public void setLength(double length){
        this.length = length;
    }

    @Override
    public double getArea(){
        return width * length;
    }

    @Override
    public double getPerimeter(){
        return width * length;
    }

    @Override
    public String toString(){
        String shape = super.toString();
        return "Rectangle["+shape+",width=" + width + ", length=" + length + "]";
    }
}
