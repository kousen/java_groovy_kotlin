package functional

List nums = [3, 1, 4, 1, 5, 9, 2, 6, 5]
assert nums.sum() ==
        nums.inject { acc, val ->
            acc + val
        }

List strings = 'this is a list of strings'.split()
List sorted = strings.sort(false)
println sorted
sorted.inject { prev, curr ->
    assert prev <= curr
    curr
}

