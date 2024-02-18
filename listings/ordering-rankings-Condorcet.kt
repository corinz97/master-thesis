    //Condorcet
    //flatten, in order to extract ties from sets
    val flattenedOrdersInRankings = rankings.map { it.ranking.flatMap { it.key.map { it.name } } }
    // take final standing
    val condorcetFlattenedOrderInFinalRanking = flattenedOrdersInRankings.last()

    var m: Map<String, List<Int>> = mapOf()
    for (competitor in condorcetFlattenedOrderInFinalRanking) {
        var listOfPositionsPerCompetitor: List<Int> = listOf()
        for (ranking in rankings.map { it.ranking.keys.toList() }) {
            var index = ranking.indexOfFirst { it.map { it.name }.contains(competitor) }
            listOfPositionsPerCompetitor = listOfPositionsPerCompetitor + ++index
        }
        m = m + (competitor to listOfPositionsPerCompetitor)
    }