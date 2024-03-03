val realWorldFlattenedOrderInFinalRanking = condorcetFlattenedOrderInFinalRanking
var m: Map<String, List<Int>> = mapOf()
for (competitor in realWorldFlattenedOrderInFinalRanking) {
    var listOfPositionsPerCompetitor: List<Int> = listOf()

    for (ranking in raceResults.map { it.value }) {
        val index = ranking.firstOrNull { it.first == competitor }?.second
            ?: ranking.maxOf { it.second }

        listOfPositionsPerCompetitor = listOfPositionsPerCompetitor + index
    }
    m = m + (competitor to listOfPositionsPerCompetitor)
}