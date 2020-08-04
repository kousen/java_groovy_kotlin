package lambdas

List cart = []

def addToCart = cart.&add
// addToCart = cart::add // okay as of Groovy 3.0
def removeFromCart = cart.&remove

addToCart 'milk'
addToCart 'butter'
addToCart 'eggs'
addToCart 'double chocolate fudge'
removeFromCart 'double chocolate fudge'

println cart
