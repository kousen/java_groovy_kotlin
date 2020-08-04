package io

import java.io.File

class JumbleKotlin {
    private val wordMap =
            File("src/main/resources/dict/words").useLines { lineSeq ->
        lineSeq.filter { it.length == 5 || it.length == 6 }
                .groupBy(this::word2key)
    }

    private fun word2key(word: String) =
            word.toList().sorted().joinToString("")

    fun solve(clue: String) =
            wordMap[word2key(clue)] ?: listOf<String>()

    fun solveAll(vararg clues: String) =
            clues.map(this::solve)
}

fun main(args: Array<String>) {
    println(JumbleKotlin().solveAll(*args))
}