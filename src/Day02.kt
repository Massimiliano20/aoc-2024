import kotlin.math.abs

fun main() {
    fun isValid(report: List<Int>): Boolean {
        val zippedReport = report.zipWithNext()
        val isDecreasing = zippedReport.all { (left, right) -> left > right }
        val isIncreasing = zippedReport.all { (left, right) -> left < right }
        val isDistanceMax3 = zippedReport.all { (left, right) -> abs(right - left) in 1..3 }
        return isDistanceMax3 && (isDecreasing || isIncreasing)
    }

    fun part1(input: List<List<Int>>): Int = input.map(::isValid).count { it }

    fun part2(input: List<List<Int>>): Int = input.map { report ->
        if (isValid(report)) true

        report.indices.any { idx ->
            val modifiedReport = report.toMutableList().apply { removeAt(idx) }
            isValid(modifiedReport)
        }
    }.count { it }

    check(part1(readInputFormatted("Day02-test")) == 2)
    check(part2(readInputFormatted("Day02-test")) == 4)

    val input = readInputFormatted("Day02")
    part1(input).println()
    part2(input).println()
}

private fun readInputFormatted(file: String) = readInput(file).map { it.split(" +".toRegex()).map { it.toInt() } }