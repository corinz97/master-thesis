val raceResults : Map<String, List<Pair<String, Int>>>() = ... 
val validCompetitors = raceResults.flatMap { it.value }.groupBy({ it.first }, { it.second })
val allCompetitorNames = validCompetitors.keys.fold(setOf<String>()) { s, element -> s + element }
var election =
    PollManagerInstance<Nothing, ListOfPreferencesVote<Nothing>>() initializedAs {
        var currentGPs: Map<String, List<Pair<String, Int>>> = mapOf()
        var index = 1
        for (raceResult in raceResults) {
            currentGPs = currentGPs + raceResult.toPair()
            +poll {
                -competition("F1 Pilots - Temporary Ranking - GPs #1 to #${index++}") {
                    allCompetitorNames.forEach {
                        +competitor(it) {}
                    }
                }
                -condorcetAlgorithm{} // or -schultzeAlgorithm
                currentGPs.entries.forEach { (runningField, competitors) ->
                    +(competitors.fold(listOf<String>()) { l, element -> l then element.first }
                            votedBy runningField
                    )
                }
            }
        }
    }
var rankings = election.computeAllPolls()