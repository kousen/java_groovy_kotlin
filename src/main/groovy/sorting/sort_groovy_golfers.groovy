package sorting

def golfers = [
        new GroovyGolfer(score: 68, last: 'Nicklaus', first: 'Jack'),
        new GroovyGolfer(score: 70, last: 'Woods', first: 'Tiger'),
        new GroovyGolfer(score: 70, last: 'Watson', first: 'Tom'),
        new GroovyGolfer(score: 68, last: 'Webb', first: 'Ty'),
        new GroovyGolfer(score: 70, last: 'Watson', first: 'Bubba')]

List sorted = golfers.toSorted()

assert sorted.first().score == 68
assert sorted.first().last == 'Nicklaus'
assert sorted.last().first == 'Tiger'

// print the scoreboard
sorted.each { println it }
// sorted.forEach(System.out.&println)

// print the last names in sorted order
println sorted.last

// sort by last name only
println golfers.sort(false) { it.last }