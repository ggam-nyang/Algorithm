class OooAhOnboarding {
    fun solution7(
        user: String,
        friends: List<List<String>>,
        visitors: List<String>
    ): List<String> {
        val friendsMap = hashMapOf<String, HashSet<String>>()
        friends.forEach { relation ->
            val person = relation.first()
            val another = relation.last()
            friendsMap.getOrPut(person) { hashSetOf() }.add(another)
            friendsMap.getOrPut(another) { hashSetOf() }.add(person)
        }
        friendsMap.forEach {
            println(it.key)
        }


        return arrayListOf()
    }
}