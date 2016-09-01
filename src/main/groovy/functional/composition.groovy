package functional

def add3 = { it + 3 }
def times2 = { it * 2 }

def times2add3 = add3 << times2
assert 13 == times2add3(5)
assert 13 == add3(times2(5))
assert 13 == (times2 >> add3)(5) // reverse composition

def add3times2 = times2 << add3
assert 16 == add3times2(5)
assert 16 == times2(add3(5))
