package functional.immutables

import spock.lang.Specification

class PointSpec extends Specification {
    def 'tuple constructor'() {
        expect: new Point(3, 4)
    }

    def "Translate"() {
        given:
        Point start = new Point(1, 0)
        Point end = new Point(3, 3)

        when:
        Point p = start.translate(2, 3)

        then:
        assert (p.x - end.x).abs() < 1e-10
        assert (p.y - end.y).abs() < 1e-10

    }

    def "Rotate 90 deg"() {
        given:
        Point p = new Point(1, 0)

        when:
        p = p.rotate(Math.PI / 2)

        then:
        p.x.abs() < 1e-10
        p.y == 1
    }

    def "Rotate 180 deg"() {
        given:
        Point p = new Point(1, 0)

        when:
        p = p.rotate(Math.PI)

        then:
        p.x == -1
        p.y.abs() < 1e-10
    }

    def "Plus"() {
        given:
        Point p1 = new Point(1, 2)
        Point p2 = new Point(3, 4)

        when:
        Point p = p1 + p2

        then:
        p.x == 4
        p.y == 6
    }

    def "Minus"() {
        given:
        Point p1 = new Point(1, 2)
        Point p2 = new Point(3, 4)

        when:
        Point p = p1 - p2

        then:
        p.x == -2
        p.y == -2
    }

    def "can't change x"() {
        given:
        Point p = new Point(1, 2)

        when:
        p.x = 5

        then:
        thrown(ReadOnlyPropertyException)
    }

    def "can't change y"() {
        given:
        Point p = new Point(1, 2)

        when:
        p.y = 5

        then:
        thrown(ReadOnlyPropertyException)
    }
}
