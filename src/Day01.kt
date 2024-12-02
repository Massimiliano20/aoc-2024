import kotlin.math.abs

fun main() {
    fun part1(input: Pair<List<Int>, List<Int>>): Int = input.let { (left, right) ->
        left.sorted().zip(right.sorted())
    }.sumOf { (left, right) -> abs(left - right) }

    fun part2(input: Pair<List<Int>, List<Int>>): Int =
        input.first.sumOf { value -> value * input.second.count { value == it } }

    check(part1(readInputFormatted("Day01-test-part1")) == 11)
    check(part2(readInputFormatted("Day01-test-part2")) == 31)

    val input = readInputFormatted("Day01")
    part1(input).println()
    part2(input).println()
}

private fun readInputFormatted(file: String) = readInput(file).map { it.split(" +".toRegex()) }
    .map { parts -> parts.map { it.toInt() }.getOrElse(0) { 0 } to parts.map { it.toInt() }.getOrElse(1) { 0 } }
    .unzip()