package baekjoon.tony.data_structure2

fun main() {
    val (N, M) = readln().split(" ").map(String::toInt)
    val nameMap = hashMapOf<String, Int>()
    val pokemonList = ArrayList<String>(N)
    pokemonList.add("number0")

    for (i in 1..N) {
        val pokemonName = readln()
        nameMap[pokemonName] = i
        pokemonList.add(pokemonName)
    }

    for (i in 1..M) {
        val input = readln()
        if (input.toIntOrNull() == null) println(nameMap[input])
        else println(pokemonList[input.toInt()])
    }
}