    var counter = 1
    val election =
        PollManagerInstance<BestTimeInMatch, ListOfPreferencesVote<BestTimeInMatch>>() initializedAs {
            +poll {
                -competition("Sport match") {
                    +competitor("competitorB") {
                    }

                    +competitor("competitorA") {
                    }

                    +competitor("competitorC") {
                    }
                }
                -condorcetAlgorithm {}

                +("competitorA" then "competitorB" then "competitorC" votedBy "anonym" + counter++)
                +("competitorA" then "competitorB" then "competitorC" votedBy "anonym" + counter++)
                +("competitorC" then "competitorA" then "competitorB" votedBy "anonym" + counter++)
                +("competitorC" then "competitorA" then "competitorB" votedBy "anonym" + counter++)
                +("competitorC" then "competitorA" then "competitorB" votedBy "anonym" + counter++)
                +("competitorC" then "competitorA" then "competitorB" votedBy "anonym" + counter++)
                +("competitorB" then "competitorC" then "competitorA" votedBy "anonym" + counter++)
                +("competitorA" then "competitorC" then "competitorB" votedBy "anonym" + counter++)
                +("competitorB" then "competitorA" then "competitorC" votedBy "anonym" + counter++)
                +("competitorC" then "competitorB" then "competitorA" votedBy "anonym" + counter++)
            } // competitorC, competitorA, competitorB
        }
    election.printRankings()
        // ** Ranking #1 **
        // Competition name is Sport match
        // Used algorithm is CondorcetAlgorithm
        // Placement #1 -> [competitorC]
        //      competitorC scores list :
        //         - no score available
        // Placement #2 -> [competitorA]
        //      competitorA scores list :
        //         - no score available
        // Placement #3 -> [competitorB]
        //      competitorB scores list :
        //         - no score available

    counter = 1
    election =
        PollManagerInstance<BestTimeInMatch, ListOfPreferencesVote<BestTimeInMatch>>() initializedAs {
            +poll {
                -competition("Sport match") {
                    +competitor("competitorB") {
                    }

                    +competitor("competitorA") {
                    }

                    +competitor("competitorC") {
                    }
                }
                -schultzeAlgorithm {}

                +("competitorA" then "competitorB" then "competitorC" votedBy "anonym" + counter++)
                +("competitorA" then "competitorB" then "competitorC" votedBy "anonym" + counter++)
                +("competitorC" then "competitorA" then "competitorB" votedBy "anonym" + counter++)
                +("competitorC" then "competitorA" then "competitorB" votedBy "anonym" + counter++)
                +("competitorC" then "competitorA" then "competitorB" votedBy "anonym" + counter++)
                +("competitorC" then "competitorA" then "competitorB" votedBy "anonym" + counter++)
                +("competitorB" then "competitorC" then "competitorA" votedBy "anonym" + counter++)
                +("competitorA" then "competitorC" then "competitorB" votedBy "anonym" + counter++)
                +("competitorB" then "competitorA" then "competitorC" votedBy "anonym" + counter++)
                +("competitorC" then "competitorB" then "competitorA" votedBy "anonym" + counter++)
            } // competitorC, competitorA, competitorB
        }
        
        election.printRankings()

        // ** Ranking #1 **
        // Competition name is Sport match
        // Used algorithm is SchultzeAlgorithm
        // Placement #1 -> [competitorC]
        //      competitorC scores list :
        //         - no score available
        // Placement #2 -> [competitorA]
        //      competitorA scores list :
        //         - no score available
        // Placement #3 -> [competitorB]
        //      competitorB scores list :
        //         - no score available
