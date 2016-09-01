package functional

class Discount {
    def percentage

    def call(amount) {
        percentage * amount
    }
}

Discount disc = new Discount(percentage: 0.1)
assert disc(1000) == 100

disc.percentage = 0.15
assert disc(1000) == 150