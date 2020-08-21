package io

import groovy.transform.CompileStatic

@CompileStatic
class Jumble1 {
    private List<String> wordList =
            new File('src/main/resources/dict/words').readLines()
                    .findAll { it.size() == 5 || it.size() == 6 }

    List<String> solve(String clue) {
        List<String> letters = clue.split('').toList()
        letters.permutations()
                .collect { it.join('') }
                .findAll { wordList.contains(it) }
    }
}

@CompileStatic
class Jumble2 {
    private Map<String, List<String>> wordMap =
            new File('src/main/resources/dict/words').readLines()
                    .findAll { it.size() == 5 || it.size() == 6 }
                    .groupBy(this.&word2key)

    private String word2key(String word) {
        word.toList().sort().join('')
    }

    List<String> solve(String clue) {
        wordMap[word2key(clue)]
    }
}



