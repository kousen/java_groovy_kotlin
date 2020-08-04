package functional

def nums = [3, 1, 4, 1, 5, 9, 2, 6, 5]

int total = nums
        .findAll { it % 3 == 0 }
        .collect { it * 2 }
        .inject(0) { acc, val -> acc + val }

assert total == 36

// or simply
total = nums
        .findAll { it % 3 == 0 }
        .collect { it * 2 }
        .sum()

assert total == 36