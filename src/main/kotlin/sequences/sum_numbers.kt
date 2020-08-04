package sequences

fun getTotal(nums: List<Int>) =
        nums.filter { it % 3 == 0 }
                .map { it * 2 }
                // .sum()
                .fold(0) { acc, i -> acc + i }

fun getTotalUsingSequences(nums: List<Int>) =
        nums.asSequence()
                .filter { it % 3 == 0 }
                .map { it * 2 }
                .sum()