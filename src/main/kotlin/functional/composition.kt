package functional

// from reference docs:
// https://kotlinlang.org/docs/reference/reflection.html#example-function-composition

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C =
        { x -> f(g(x)) }

fun length(s: String) = s.length

fun isOdd(x: Int) = x % 2 == 1

fun main() {
    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")

    strings.filter(oddLength)
            .also(::println)
}