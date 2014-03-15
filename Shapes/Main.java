package name.sundrop.shapes;

public class Main {
    public static void main (String[] args) throws CloneNotSupportedException {
        Triangle triangle = new Triangle(new Point(1,1), new Point(1,4), new Point(5,1));
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());
        System.out.println("Площадь треугольника: " + triangle.getArea());

        Square square = new Square(new Point(1,1), new Point(3,3));
        System.out.println("Периметр прямоугольника: " + square.getPerimeter());
        System.out.println("Площадь прямоугольника: " + square.getArea());

        Circle circle = new Circle(new Point(0,0), 10);
        System.out.println("Периметр круга: " + circle.getPerimeter());
        System.out.println("Площадь круга: " + circle.getArea());
    }
}
