package collectors

List books = [
        new Book(1, "Java 8 in Action"),
        new Book(2, "Java SE8 for the Really Impatient"),
        new Book(3, "Core Java Volume I -- Fundamentals"),
        new Book(4, "Functional Programming in Java"),
        new Book(5, "Making Java Groovy"),
        new Book(6, "Head First Java"),
        new Book(7, "Effective Java"),
        new Book(8, "Java 8 Pocket Guide"),
        new Book(9, "Gradle Recipes for Android"),
        new Book(10, "Spring Boot in Action")
]

// Side-effects; works but not best approach
//Map bookMap = [:]
//books.each { b ->
//    bookMap[b.id] = b
//}

// Much better
Map bookMap = books.inject([:]) { map, b ->
    map[b.id()] = b
    map
}

bookMap.each { println it }