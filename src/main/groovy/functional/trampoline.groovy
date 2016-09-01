package functional

def fact
fact = { n, total ->
    n == 0 ? total : fact.trampoline(n - 1, n * total)
}.trampoline()
def factorial = { n -> fact(n, 1G)}
println factorial(20) // => 2432902008176640000

def fib
fib = { n, a = BigInteger.ZERO, b = BigInteger.ONE ->
    n == 0 ? a : fib.trampoline(n - 1, b, a + b)
}.trampoline()

def result = fib(1001)
println "$result".size() // 209 digits