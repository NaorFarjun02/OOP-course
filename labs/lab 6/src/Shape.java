public abstract class Shape {
    private String color;

    public Shape() {
        this.setColor("red");
    }
    public Shape(String color) {
        this.setColor(color);
    }


    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public String toString(){
        return "Shape[color=" + this.getColor() + "]";
    }
}
