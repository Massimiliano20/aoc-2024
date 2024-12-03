fun main() {

    fun part1(input: List<String>): Int = input.sumOf {
        Regex("""mul\(([0-9]{1,3}),([0-9]{1,3})\)""").findAll(it).map {
            val (left, right) = it.destructured
            left.toInt() * right.toInt()
        }.sum()
    }

    fun part2(input: List<String>): Int = 0

    check(part1(readInputFormatted("Day03-test")) == 161)
//    check(part2(readInputFormatted("Day02-test")) == 4)

    val input = readInputFormatted("Day03")
    part1(input).println()
//    part2(input).println()
}

private fun readInputFormatted(file: String) = readInput(file)