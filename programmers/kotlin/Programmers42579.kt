package programmers.kotlin

class Programmers42579 {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {

        val songForGenres = genres.indices.groupBy({ genres[it] }, { it })
            .mapValues { genre -> genre.value.sortedWith(
                compareByDescending<Int> { plays[it] }.thenBy { it }
            )}
        val genresRanking = songForGenres.map { it.key to it.value.sumOf { song -> plays[song] } }
            .sortedByDescending { it.second }
            .map { it.first }
        val answer = mutableListOf<Int>()

        genresRanking.forEach { genre ->
            answer.add(songForGenres[genre]!!.first())
            if (songForGenres[genre]!!.size > 1)
                answer.add(songForGenres[genre]!![1])
        }

        return answer.toIntArray()
    }
}