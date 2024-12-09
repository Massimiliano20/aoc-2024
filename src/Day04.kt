fun main() {
    val direction = listOf(
        -1 to 1,
        0 to 1,
        1 to 1,
        1 to 0,
        1 to -1,
        0 to -1,
        -1 to -1,
        -1 to 0,
    )

    fun countXmas(input: List<List<String>>, row: Int, column: Int): Int =
        if(input[row][column] == "X") direction.map{ dir ->
            listOf("M","A","S").fold(Triple(row + dir.first, column + dir.second, true)) { acc, curr ->
                Triple(acc.first + dir.first, acc.second + dir.second, acc.third && (input.getOrNull(acc.first)?.getOrNull(acc.second) ?: "") == curr)
            }.third
        }.count{it}  else 0

    fun part1(input: List<List<String>>): Int = input.indices.sumOf { i ->
        (0..(input[i].size - 1)).sumOf { j -> countXmas(input, i, j) }
    }

    fun part2(input: List<List<String>>): Int = 0

    check(part1(readInputFormatted("Day04-test")) == 18)
//    check(part2(readInputFormatted("Day04-test")) == 4)

    val input = readInputFormatted("Day04")
    part1(input).println()
//    part2(input).println()
}

private fun readInputFormatted(file: String) = readInput(file).map {it.split("").filter {it != ""}}