package lambdas

import java.util.stream.DoubleStream

[3, 1, 4, 1, 5, 9].stream()
                  .map { it * 2 }
                  .filter { it % 3 == 0 }
                  .forEach { println it }

println DoubleStream.generate(Math::random)
                    .limit(1000)
                    .mapToInt { (int) (it * 100) }
                    .filter { it % 3 == 0 }
                    .summaryStatistics()