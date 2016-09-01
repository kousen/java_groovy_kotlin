package sorting

import groovy.transform.*

// Caddyshack golfers

@Sortable(includes = ['height', 'score', 'last', 'first'])
class GolferCS {
    String first
    String last
    int score
    int height

    void setHeight(int height) { this.height = -height }

    String toString() { "$score: $last, $first (${height.abs()})" }
}

def golfers = [
        new GolferCS(height: 70, score: 68, last: 'Nicklaus', first: 'Jack'),
        new GolferCS(height: 73, score: 70, last: 'Woods', first: 'Tiger'),
        new GolferCS(height: 69, score: 70, last: 'Watson', first: 'Tom'),
        new GolferCS(height: 76, score: 68, last: 'Webb', first: 'Ty'),
        new GolferCS(height: 75, score: 70, last: 'Watson', first: 'Bubba')]

golfers.sort().each { println it }