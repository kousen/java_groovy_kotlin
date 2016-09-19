package collectors

List books = [
        new Book(id: 1, name: "Java 8 in Action"),
        new Book(id: 2, name: "Java SE8 for the Really Impatient"),
        new Book(id: 3, name: "Core Java Volume I -- Fundamentals"),
        new Book(id: 4, name: "Functional Programming in Java"),
        new Book(id: 5, name: "Making Java Groovy"),
        new Book(id: 6, name: "Head First Java"),
        new Book(id: 7, name: "Effective Java"),
        new Book(id: 8, name: "Java 8 Pocket Guide"),
        new Book(id: 9, name: "Gradle Recipes for Android"),
        new Book(id: 10, name: "Spring Boot in Action")
]

// Side-effects; works but not best approach
//Map bookMap = [:]
//books.each { b ->
//    bookMap[b.id] = b
//}

// Much better
Map bookMap = books.inject([:]) { map, b ->
    map[b.id] = b
    map
}

bookMap.each { println it }