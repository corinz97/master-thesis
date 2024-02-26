val election =
    PollManagerInstance<BestTimeInMatch, SinglePreferenceVote<BestTimeInMatch>>() initializedAs {
        +poll {
                -competition("Race 2") {
                    +competitor("competitor1") {
                        +(BestTimeInMatch realized (0.toDuration(DurationUnit.HOURS)))
                        +(BestTimeInMatch realized (1.toDuration(DurationUnit.HOURS)))
                        +(BestTimeInMatch realized (2.toDuration(DurationUnit.HOURS)))
                    }
                    +competitor("competitor2") {
                        +(BestTimeInMatch realized (1.toDuration(DurationUnit.HOURS)))
                    }
                }
                -majorityVotesHScoreAlgorithm {
                    +ConstantParameter.AllowMultipleVoteInPollParameter
                }
                +("competitor2" votedBy "voter1")
                +("competitor1" votedBy "voter1")
                +("competitor2" votedBy "voter2")
                +("competitor1" votedBy "voter2")
        }          // same votes, competitor1 has the highest score
    }
election.printRankings()