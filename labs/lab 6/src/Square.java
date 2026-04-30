import java.awt.*;

public class Square extends Rectangle{

    public Square(){
        super();
        this.setSide(1.0);
    }
    public Square(double side){
        super();
        this.setSide(side);
    }
    public Square(double side, String color){
        super(side,side,color);
        this.setSide(side);
    }

    public void setSide(double side){
        this.setWidth(side);
        this.setLength(side);
    }
    public double getSide(){
        return super.getWidth();
    }

    @Override
    public void setWidth(double side){
        super.setWidth(side);
    }

    @Override
    public void setLength(double side){
        super.setLength(side);
    }

    @Override
    public String toString(){
        String shape = super.toString();
        return "Square["+shape+"]";
    }
}
