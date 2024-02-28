val election = 
    PollManagerInstance<BestTimeInMatch, SinglePreferenceVote<BestTimeInMatch>>() initializedAs {
        +poll {
                -competition("Race 1") {
                    +competitor("competitor1") {}
                    +competitor("competitor2") {}
                }
                -majorityVotesAlgorithm {
                    +ConstantParameter.AllowMultipleVoteInPollParameter
                }
                +("competitor1".asAnonymousVote())
                +("competitor2".asAnonymousVote())
                +("competitor1".asAnonymousVote())
            }
    }
election.printRankings()