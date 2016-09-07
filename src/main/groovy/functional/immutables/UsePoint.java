package functional.immutables;

public class UsePoint {
    public static void main(String[] args) {
        Point p = Point.createPoint(1, 0);
        System.out.println(p);
        System.out.printf("(%s,%s)%n", p.getX(), p.getY());

        Point p1 = p.translate(2, 3);
        System.out.println(p1); // should be (3,3)

        Point p2 = p.rotate(Math.PI / 2);
        System.out.println(p2); // should be (0,1)
    }
}
