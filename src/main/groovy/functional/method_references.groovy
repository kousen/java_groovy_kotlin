package functional

List cart = []

def addToCart = cart.&add
def removeFromCart = cart.&remove

addToCart 'milk'
addToCart 'butter'
addToCart 'eggs'
addToCart 'double chocolate fudge'
removeFromCart 'double chocolate fudge'

println cart
