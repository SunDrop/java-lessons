package name.sundrop.shapes;

/**
 * Класс для работы с кругом
 */
public class Circle extends Shape {
    private Point cender;

    private double radius;

    public Circle(Point a, double r) throws CloneNotSupportedException {
        setCircle(a, r);
    }

    public void setCircle(Point a, double r) throws CloneNotSupportedException {
        this.cender = a.clone();
        this.radius = r;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
