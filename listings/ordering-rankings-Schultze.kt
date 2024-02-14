    //Schultze
    //reuse same order
    val schultzeFlattenedOrderInFinalRanking = condorcetFlattenedOrderInFinalRanking
    var m: Map<String, List<Int>> = mapOf()
    for (competitor in schultzeFlattenedOrderInFinalRanking) {
        var listOfPositionsPerCompetitor: List<Int> = listOf()
        for (ranking in rankings.map { it.ranking.keys.toList() }) {
            var index = ranking.indexOfFirst { it.map { it.name }.contains(competitor) }

            listOfPositionsPerCompetitor = listOfPositionsPerCompetitor + ++index
        }
        m = m + (competitor to listOfPositionsPerCompetitor)
    }