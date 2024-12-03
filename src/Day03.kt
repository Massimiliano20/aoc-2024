fun main() {

    fun part1(input: List<String>): Int = input.sumOf {
        Regex("""mul\(([0-9]{1,3}),([0-9]{1,3})\)""").findAll(it).map {
            val (left, right) = it.destructured
            left.toInt() * right.toInt()
        }.sum()
    }

    fun part2(input: List<String>): Int {
        var enabled = true
        return input.sumOf {
            Regex("""mul\(([0-9]{1,3}),([0-9]{1,3})\)|(do\(\))|(don't\(\))""").findAll(it).map {
                enabled = when(it.value) {
                    "do()" -> true
                    "don't()" -> false
                    else -> return@map if(enabled)(it.groups[1]?.value?.toInt() ?: 0) * (it.groups[2]?.value?.toInt() ?: 0) else 0
                }
                0
            }.sum()
        }
    }

    check(part1(readInputFormatted("Day03-test-part1")) == 161)
    check(part2(readInputFormatted("Day03-test-part2")) == 48)

    val input = readInputFormatted("Day03")
    part1(input).println()
    part2(input).println()
}

private fun readInputFormatted(file: String) = readInput(file)