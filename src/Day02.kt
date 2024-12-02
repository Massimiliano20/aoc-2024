import kotlin.math.abs

fun main() {
    fun part1(input: List<List<Int>>): Int = input.map { report ->
        val zippedReport = report.zipWithNext()
        val isDecreasing = zippedReport.all { (left, right) -> left > right }
        val isIncreasing = zippedReport.all { (left, right) -> left < right }

        val isDistanceMax3 = report.fold(true to report[0]) {
            acc, cur -> (acc.first && (abs(cur - acc.second) <= 3)) to cur
        }.first

        isDistanceMax3 && (isDecreasing || isIncreasing)
    }.count { it }


//        input.let { (left, right) ->
//        left.sorted().zip(right.sorted())
//    }.sumOf { (left, right) -> abs(left - right) }

//    fun part2(input: Pair<List<Int>, List<Int>>): Int =
//        input.first.sumOf { value -> value * input.second.count { value == it } }

    check(part1(readInputFormatted("Day02-test-part1")) == 2)
//    check(part2(readInputFormatted("Day01-test-part2")) == 31)

    val input = readInputFormatted("Day02")
    part1(input).println()
//    part2(input).println()
}

private fun readInputFormatted(file: String) = readInput(file).map { it.split(" +".toRegex()).map { it.toInt() } }