package sorting

import groovy.transform.Sortable

@Sortable(includes = ['score', 'last', 'first'])
class GroovyGolfer {
    String first
    String last
    int score

    String toString() { "$score: $last, $first" }
}
