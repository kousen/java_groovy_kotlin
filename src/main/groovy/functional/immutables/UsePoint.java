package functional.immutables;

public class UsePoint {
    public static void main(String[] args) {
        Point p = Point.createPoint(3, 5);
        System.out.println(p);
        System.out.printf("(%s,%s)%n", p.getX(), p.getY());
    }
}
