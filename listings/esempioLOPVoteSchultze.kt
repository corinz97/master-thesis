val election =
    PollManagerInstance<BestTimeInMatch, ListOfPreferencesVote<BestTimeInMatch>>() initializedAs {
        +poll {
                -competition("Sport match") {
                    +competitor("competitorB") {}
                    +competitor("competitorA") {}
                    +competitor("competitorC") {}
                }
                -schultzeAlgorithm {}
                +(("competitorA" then "competitorB" then "competitorC").asAnonymousVote())
                +(("competitorA" then "competitorB" then "competitorC").asAnonymousVote())
                +(("competitorC" then "competitorA" then "competitorB").asAnonymousVote())
                +(("competitorC" then "competitorA" then "competitorB").asAnonymousVote())
                +(("competitorC" then "competitorA" then "competitorB").asAnonymousVote())
                +(("competitorC" then "competitorA" then "competitorB").asAnonymousVote())
                +(("competitorB" then "competitorC" then "competitorA").asAnonymousVote())
                +(("competitorA" then "competitorC" then "competitorB").asAnonymousVote())
                +(("competitorB" then "competitorA" then "competitorC").asAnonymousVote())
                +(("competitorC" then "competitorB" then "competitorA").asAnonymousVote())
        }
    }
election.printRankings()