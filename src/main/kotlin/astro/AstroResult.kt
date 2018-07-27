package astro

data class AstroResult(val message: String,
                       val number: Number,
                       val people: List<Assignment>)

data class Assignment(val craft: String,
                      val name: String)
