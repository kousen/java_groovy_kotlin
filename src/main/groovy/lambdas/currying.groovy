package lambdas

Closure add = { x,y -> x + y }

assert 7 == add.call(3, 4)
assert 7 == add(3,4)
assert 'abcdef' == add('abc', 'def')

Closure add3 = add.curry(3)

assert 7 == add3(4)
assert 0 == add3(-3)

