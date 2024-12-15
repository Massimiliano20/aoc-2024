fun main() {
    fun part1(input: InputDay04): Int = input.inputValues.sumOf { data ->
        if (input.rules.all {
                data.indexOf(it.first) == -1 || data.indexOf(it.second) == -1 || data.indexOf(it.first) < data.indexOf(it.second)})
            data[data.size / 2]
        else 0
    }

    fun part2(input: InputDay04): Int = input.inputValues.sumOf { data ->
        var brokenRule = input.rules.find {
            !(data.indexOf(it.first) == -1 || data.indexOf(it.second) == -1 || data.indexOf(it.first) < data.indexOf(it.second))}
        if(brokenRule == null) return@sumOf 0
        val mutableData = data.toMutableList()
        do {
            mutableData.remove(brokenRule?.first)
            mutableData.add(mutableData.indexOf(brokenRule?.second), brokenRule?.first ?: 0)
            brokenRule = input.rules.find {
                !(mutableData.indexOf(it.first) == -1 || mutableData.indexOf(it.second) == -1 || mutableData.indexOf(it.first) < mutableData.indexOf(it.second))}
        } while (brokenRule != null)
        mutableData[data.size / 2]
    }

    check(part1(readInputFormatted("Day05-test")) == 143)
    check(part2(readInputFormatted("Day05-test")) == 123)

    val input = readInputFormatted("Day05")
    part1(input).println()
    part2(input).println()
}

private fun readInputFormatted(file: String): InputDay04 {
    val file = readInput(file)
    val indexSeparator = file.indexOf("")
    return InputDay04(
        rules = file.take(indexSeparator).map { it.split("|") }.map { it.get(0).toInt() to it.get(1).toInt() },
        inputValues = file.takeLast(file.size - indexSeparator - 1).map { it.split(",").map { it.toInt() } }
    )
}

data class InputDay04(
    val rules: List<Pair<Int, Int>>,
    val inputValues: List<List<Int>>
)