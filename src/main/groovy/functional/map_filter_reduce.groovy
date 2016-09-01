package functional

List nums = [3, 1, 4, 1, 5, 9, 2, 6, 5]

assert 36 == nums.collect { it * 2 }  // map
            .findAll { it % 3 == 0 }  // filter
            .sum()                    // reduce

List cities = ['Boston', 'New York', 'London', 'Hyderabad']

assert cities.collect { String s -> s.toUpperCase() }
              .sort()
              .join(', ') ==
        'BOSTON, HYDERABAD, LONDON, NEW YORK'

println cities.collect { it.toUpperCase() }
        .sort { it.size() }
        .join(', ')

