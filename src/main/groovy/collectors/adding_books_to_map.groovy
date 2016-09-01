package collectors

List books = [
        new Book(id: 1, name: "Java 8 in Action", price: 49.99),
        new Book(id: 2, name: "Java SE8 for the Really Impatient", price: 39.99),
        new Book(id: 3, name: "Core Java Volume I -- Fundamentals", price: 43.30),
        new Book(id: 4, name: "Functional Programming in Java", price: 27.64),
        new Book(id: 5, name: "Making Java Groovy", price: 45.99),
        new Book(id: 6, name: "Head First Java", price: 26.97),
        new Book(id: 7, name: "Effective Java", price: 35.47),
        new Book(id: 8, name: "Java 8 Pocket Guide", price: 10.40),
        new Book(id: 9, name: "Gradle Recipes for Android", price: 23.76),
        new Book(id: 10, name: "Spring Boot in Action", price: 39.97)
]

Map bookMap = [:]
books.each { b ->
    bookMap[b.id] = b
}

bookMap.each { println it }