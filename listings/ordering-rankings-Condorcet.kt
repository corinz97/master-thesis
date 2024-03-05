val flattenedOrdersInRankings = rankings.map { it.ranking.flatMap { it.key.map { it.name } } }
val condorcetFlattenedOrderInFinalRanking = flattenedOrdersInRankings.last()
var m: Map<String, List<Int>> = mapOf()
for (competitor in condorcetFlattenedOrderInFinalRanking) {
    var listOfPositionsPerCompetitor: List<Int> = listOf()
    for (ranking in rankings.map { it.ranking.keys.toList() }) {
        var index = ranking.indexOfFirst { it.map { it.name }.contains(competitor) }
        ++index
        listOfPositionsPerCompetitor = listOfPositionsPerCompetitor + index
    }
    m = m + (competitor to listOfPositionsPerCompetitor)
}