public class MainShapeArray {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[20];
        getShapes(shapes);
        printShapes(shapes);
        System.out.println();
        System.out.println();
        printLargestShapes(shapes);
    }

    public static void getShapes(Shape[] shapes) {
        System.out.println("Array of shapes:");
        System.out.println("*******************");

        for (int i = 0; i < shapes.length; i++) {
            int randomInt = randomInteger(0, 2);
            double randomD1 = randomDouble(0, 10);
            double randomD2 = randomDouble(0, 10);

            switch (randomInt) {
                case 0:
                    shapes[i] = new Circle(randomD1 / 2);
                    break;
                case 1:
                    shapes[i] = new Rectangle(randomD1, randomD2);
                    break;
                default:
                    shapes[i] = new Square(randomD1);
                    break;
            }
        }
    }

    public static int randomInteger(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static double randomDouble(int min, int max) {
        return Math.random() * (max - min) + min;
    }

    public static void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape.getArea() + "\t " + shape);
        }
    }

    public static void printLargestShapes(Shape[] shapes) {
        Circle circle = (Circle) getLargestShape(shapes, new Circle());
        if (circle == null) {
            System.out.println("There are no Circle in array!!!");
        } else {
            System.out.println("Largest Circle: \nArea =" + circle.getArea() + "\n" + circle + "\n");
        }

        Rectangle rectangle = (Rectangle) getLargestShape(shapes, new Rectangle());
        if (rectangle == null) {
            System.out.println("There are no Rectangle in array!!!");
        } else {
            System.out.println("Largest Rectangle: \nArea =" + rectangle.getArea() + "\n" + rectangle + "\n");
        }

        Square square = (Square) getLargestShape(shapes, new Square());
        if (square == null) {
            System.out.println("There are no Square in array!!!");
        } else {
            System.out.println("Largest Square: \nArea =" + square.getArea() + "\n" + square + "\n");
        }
    }

    public static Shape getLargestShape(Shape[] shapes, Shape newShape) {
        Shape largestShape = null;
        double largestArea = 0;

        for (Shape shape : shapes) {
            if (shape.getClass() == newShape.getClass() && shape.getArea() > largestArea) {
                largestShape = shape;
                largestArea = shape.getArea();
            }
        }

        return largestShape;
    }
}