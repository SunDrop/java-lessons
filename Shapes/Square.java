package name.sundrop.shapes;

public class Square implements Shape {

    private Point a, b;

    public Square(Point a, Point b) throws CloneNotSupportedException {
        setSquare(a, b);
    }

    public void setSquare(Point a, Point b) throws CloneNotSupportedException {
        this.a = a.clone();
        this.b = b.clone();
    }


    @Override
    public double getArea() {
        Point z = a.squareProjection(b);
        return a.distance(z) * b.distance(z);
    }

    @Override
    public double getPerimeter() {
        Point z = a.squareProjection(b);
        return 2 * (a.distance(z) + b.distance(z));
    }
}
