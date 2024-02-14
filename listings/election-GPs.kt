val raceResults : Map<String, List<Pair<String, Int>>>() = ... //get data from Ergast API

val validCompetitors = raceResults.flatMap { it.value }.groupBy({ it.first }, { it.second })

val allCompetitorNames = validCompetitors.keys.fold(setOf<String>()) { s, element -> s + element }

var election =
        PollManagerInstance<Nothing, ListOfPreferencesVote<Nothing>>() initializedAs {
            var currentGPs: Map<String, List<Pair<String, Int>>> = mapOf()
            var index = 1
            for (raceResult in raceResults) {
                // add incrementally a new GP, for each poll
                currentGPs = currentGPs + raceResult.toPair()
                +poll {
                    -competition("F1 Pilots - Partial Ranking - GPs #1 to #${index++}") {
                        allCompetitorNames.forEach {
                            +competitor(it) {}
                        }
                    }
                    -chosenLOPAlgorithm{}

                    // incremental set of votes
                    currentGPs.entries.forEach { (runningField, competitors) ->
                        +(
                            competitors.fold(listOf<String>()) { l, element -> l then element.first }
                                votedBy runningField
                            )
                    }
                }
            }
        }
        var rankings = election.computeAllPolls()