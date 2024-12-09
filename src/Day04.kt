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
        if (input[row][column] == "X") direction.map { dir ->
            listOf("M", "A", "S").fold(Triple(row + dir.first, column + dir.second, true)) { acc, curr ->
                Triple(
                    acc.first + dir.first,
                    acc.second + dir.second,
                    acc.third && (input.getOrNull(acc.first)?.getOrNull(acc.second) ?: "") == curr
                )
            }.third
        }.count { it } else 0

    fun part1(input: List<List<String>>): Int = input.indices.sumOf { i ->
        (0..(input[i].size - 1)).sumOf { j -> countXmas(input, i, j) }
    }

    val directionPart2 = listOf(
        listOf(-1 to 1, 0 to 0, 1 to -1),
        listOf(-1 to -1, 0 to 0, 1 to 1),
    )

    fun countXmasPart2(input: List<List<String>>, row: Int, column: Int): Int =
        if (input[row][column] == "A" && directionPart2.all {
                listOf("MAS", "SAM").contains(it.joinToString("") { dir ->
                    input.getOrNull(row + dir.first)?.getOrNull(column + dir.second) ?: ""
                })
            }) 1 else 0

    fun part2(input: List<List<String>>): Int = input.indices.sumOf { i ->
        (0..(input[i].size - 1)).sumOf { j -> countXmasPart2(input, i, j) }
    }


    check(part1(readInputFormatted("Day04-test")) == 18)
    check(part2(readInputFormatted("Day04-test")) == 9)

    val input = readInputFormatted("Day04")
    part1(input).println()
    part2(input).println()
}

private fun readInputFormatted(file: String) = readInput(file).map { it.split("").filter { it != "" } }