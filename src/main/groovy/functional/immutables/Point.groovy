package functional.immutables

import groovy.transform.Immutable
import groovy.transform.TupleConstructor

@Immutable
class Point {
    double x
    double y

    static Point createPoint(double x, double y) {
        new Point(x, y)
    }

    Point translate(double dx = 0, double dy = 0) {
        new Point(x + dx, y + dy)
    }

    Point rotate(double radians) {
        double r = Math.sqrt(x * x + y + y)
        new Point(r * Math.cos(radians), r * Math.sin(radians))
    }

    Point plus(Point p) {
        new Point(x + p.x, y + p.y)
    }

    Point minus(Point p) {
        new Point(x - p.x, y - p.y)
    }
}
