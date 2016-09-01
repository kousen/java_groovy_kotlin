package sorting

class SortingDemoGroovy {
    List strings = 'this is a list of strings'.split()

    // Default sort
    List defaultSort() {
        strings.sort()
    }

    // Length sort with 2-arg closure
    List lengthSortWithTwoArgClosure() {
        strings.sort { s1, s2 -> s1.size() <=> s2.size() }
    }

    List lengthSortWithOneArgClosure() {
        strings.sort { it.size() }
    }

    List lengthSortThenAlphaSort() {
        strings.sort { s1, s2 ->
            s1.size() <=> s2.size() ?: s1 <=> s2
        }
    }
}
