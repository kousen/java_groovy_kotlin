package functional

// Define a closure
def add = { x,y -> x + y }

assert add.call(3,4) == 7
assert add(3,4) == 7
assert add('abc','def') == 'abcdef'

Date now = new Date()
Date then = add(now, 3)
assert then - now == 3

// Define a closure with a variable number of untyped args
def addAll = { ... values -> values.sum() }

assert addAll(1, 2, 3) == 6
assert addAll('a', 'b') == 'ab'

// Default args
def mult = { x, y = 2 -> x * y }

assert mult(3, 4) == 12
assert mult(3) == 6

// Curry
def add3 = add.curry(3)
assert add3(4) == 7

def times2 = mult.rcurry(2)
assert times2(4) == 8
assert times2('abc') == 'abcabc'