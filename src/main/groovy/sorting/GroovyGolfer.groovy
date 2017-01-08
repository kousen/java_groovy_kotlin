package sorting

import groovy.transform.Sortable

// Add the @Sortable annotation
class GroovyGolfer {
    String first
    String last
    int score

    String toString() { "$score: $last, $first" }
}
