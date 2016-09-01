package functional

import groovy.transform.Memoized

def add = { x, y -> sleep 1000; x + y }.memoize()

println add(3, 4)      // takes 1 sec
println add(3, 4)      // immediate
println add('a','b')   // takes 1 sec
println add('a','b')   // immediate

def fib = { n ->
    if (n < 2) 1
    else call(n - 1) + call(n - 2)
}.memoize()

println fib(10)

@Memoized
long fib1(long n) {
    if (n < 2) 1
    else fib1(n - 1) + fib1(n - 2)
}

println fib1(100)