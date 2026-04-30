public class MainTestShape {
    public static void main(String[] args) {
        System.out.println("\nreference-type:\tShape\tobject-type:\tCircle");
        System.out.println("=================================================");
        Shape s1 = new Circle(5.5, "red");
        System.out.println(s1);
        System.out.println("getArea=\t" + s1.getArea());
        System.out.println("perimeter=\t" + s1.getPerimeter());
        System.out.println("getColor=\t" + s1.getColor());
        // System.out.println(s1.getRadius()); // Compilation error: reference type is Shape

        System.out.println("\nreference-type:\tCircle\tobject-type:\tCircle");
        System.out.println("=================================================");
        Circle c1 = (Circle) s1;
        System.out.println(c1);
        System.out.println("getArea=\t" + c1.getArea());
        System.out.println("perimeter=\t" + c1.getPerimeter());
        System.out.println("getColor=\t" + c1.getColor());
        System.out.println("getRadius=\t" + c1.getRadius());

        // Shape s2 = new Shape(); // Compilation error: Shape is abstract

        System.out.println("\nreference-type:\tShape\tobject-type:\tRectangle");
        System.out.println("=================================================");
        Shape s3 = new Rectangle(1.0, 2.0, "red");
        System.out.println(s3);
        System.out.println("getArea=\t" + s3.getArea());
        System.out.println("perimeter=\t" + s3.getPerimeter());
        System.out.println("getColor=\t" + s3.getColor());
        // System.out.println(s3.getLength()); // Compilation error: reference type is Shape

        System.out.println("\nreference-type:\tRectangle\tobject-type:\tRectangle");
        System.out.println("=================================================");
        Rectangle r1 = (Rectangle) s3;
        System.out.println(r1);
        System.out.println("getArea=\t" + r1.getArea());
        System.out.println("getColor=\t" + r1.getColor());
        System.out.println("getLength=\t" + r1.getLength());

        System.out.println("\nreference-type:\tShape\tobject-type:\tSquare");
        System.out.println("=================================================");
        Shape s4 = new Square(6.6);
        System.out.println(s4);
        System.out.println("getArea=\t" + s4.getArea());
        System.out.println("getColor=\t" + s4.getColor());
        // System.out.println(s4.getSide()); // Compilation error: reference type is Shape

        System.out.println("\nreference-type:\tRectangle\tobject-type:\tSquare");
        System.out.println("=================================================");
        Rectangle r2 = (Rectangle) s4;
        System.out.println(r2);
        System.out.println("getArea=\t" + r2.getArea());
        System.out.println("getColor=\t" + r2.getColor());
        System.out.println("getLength=\t" + r2.getLength());
        // System.out.println(r2.getSide()); // Compilation error: reference type is Rectangle

        System.out.println("\nreference-type:\tSquare\tobject-type:\tSquare");
        System.out.println("=================================================");
        Square sq1 = (Square) r2;
        System.out.println(sq1);
        System.out.println("getArea=\t" + sq1.getArea());
        System.out.println("getColor=\t" + sq1.getColor());
        System.out.println("getSide=\t" + sq1.getSide());
        System.out.println("getLength=\t" + sq1.getLength());
    }
}
