 var election = PollManagerInstance<BestTimeInMatch, SinglePreferenceVote<BestTimeInMatch>>() initializedAs {
            +poll {
                -competition("Race 1") {
                    +competitor("competitor1") {
                    }

                    +competitor("competitor2") {
                    }
                }

                -majorityVotesAlgorithm {
                    +ConstantParameter.AllowMultipleVoteInPollParameter
                }
                +("competitor1" votedBy "voter1")
                +("competitor2" votedBy "voter2")
                +("competitor1" votedBy "voter2")
            } // competitor1 wins

            +poll {
                -competition("Race 2") {
                    +competitor("competitor1") {
                        +(BestTimeInMatch realized (1.toDuration(DurationUnit.HOURS)))
                        +(BestTimeInMatch realized (4.toDuration(DurationUnit.HOURS)))
                    }

                    +competitor("competitor2") {
                        +(BestTimeInMatch realized (2.toDuration(DurationUnit.HOURS)))
                    }
                }
                -majorityVotesAlgorithm {
                    +ConstantParameter.AllowMultipleVoteInPollParameter
                }

                +("competitor1" votedBy "voter1")
                +("competitor2" votedBy "voter3")
                +("competitor2" votedBy "voter2")
                +("competitor1" votedBy "voter2")
            } // competitor1 and competitor2 have tie in votes
        }
        election.printRankings()

    //    ** Ranking #1 **
    //    Competition name is Race 1
    //    Used algorithm is MajorityVotesAlgorithm
    //    Placement #1 -> [competitor1] with 2 votes 
    //      competitor1 scores list :
    //            - no score available

    //    ** Ranking #2 **
    //    Competition name is Race 2
    //    Used algorithm is MajorityVotesAlgorithm
    //    Placement #1 -> [competitor1 | competitor2] with 2 votes 
    //      competitor1 scores list :
    //            - Score type is BestTimeInMatch with time = 1h -
    //            - Score type is BestTimeInMatch with time = 4h -
    //      competitor2 scores list :
    //            - Score type is BestTimeInMatch with time = 2h -
  


    election =
        PollManagerInstance<BestTimeInMatch, SinglePreferenceVote<BestTimeInMatch>>() initializedAs {
            +poll {
                -competition("Race 1") {
                    +competitor("competitor1") {
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
                +("competitor1" votedBy "voter2")
            } // competitor1 has more votes but select highest score anyway

            +poll {
                -competition("Race 2") {
                    +competitor("competitor1") {
                        // T = 0.5
                        +(BestTimeInMatch realized (T.toDuration(DurationUnit.HOURS)))
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
            } // same votes, competitor1 has the highest score

            +poll {
                -competition("Race 3") {
                    +competitor("competitor1") {
                        +(BestTimeInMatch realized (T.toDuration(DurationUnit.HOURS)))
                        +(BestTimeInMatch realized (1.toDuration(DurationUnit.HOURS)))
                        +(BestTimeInMatch realized (2.toDuration(DurationUnit.HOURS)))
                    }

                    +competitor("competitor2") {
                        +(BestTimeInMatch realized (2.toDuration(DurationUnit.HOURS)))
                    }
                }
                -majorityVotesHScoreAlgorithm {
                    +ConstantParameter.AllowMultipleVoteInPollParameter
                }

                +("competitor2" votedBy "voter1")
                +("competitor1" votedBy "voter1")
                +("competitor2" votedBy "voter2")
                +("competitor1" votedBy "voter2")
            } // same votes, same highest score
        }

        election.printRankings() 

   
        // ** Ranking #1 **
        // Competition name is Race 1
        // Used algorithm is MajorityVotesThenHighestScoreAlgorithm
        // Placement #1 -> [competitor1] with 2 votes 
        //      competitor1 scores list :
        //          - Score type is BestTimeInMatch with time = 2h -

        // ** Ranking #2 **
        // Competition name is Race 2
        // Used algorithm is MajorityVotesThenHighestScoreAlgorithm
        //  Placement #1 -> [competitor1] with 2 votes 
        //      competitor1 scores list :
        //          - Score type is BestTimeInMatch with time = 2h -
        //  Placement #2 -> [competitor2] with 2 votes 
        //      competitor2 scores list :
        //          - Score type is BestTimeInMatch with time = 1h -

        // ** Ranking #3 **
        // Competition name is Race 3
        // Used algorithm is MajorityVotesThenHighestScoreAlgorithm

        // Placement #1 -> [competitor2 | competitor1] with 2 votes 
        //      competitor2 scores list :
        //          - Score type is BestTimeInMatch with time = 2h -
        //      competitor1 scores list :
        //          - Score type is BestTimeInMatch with time = 2h -


        election =
        PollManagerInstance<BestTimeInMatch, SinglePreferenceVote<BestTimeInMatch>>() initializedAs {
            +poll {
                -competition("Race 1") {
                    +competitor("competitor1") {
                        +(BestTimeInMatch realized (1.toDuration(DurationUnit.HOURS)))
                        +(BestTimeInMatch realized (2.toDuration(DurationUnit.HOURS)))
                    }

                    +competitor("competitor2") {
                        +(BestTimeInMatch realized (1.toDuration(DurationUnit.HOURS)))
                    }
                }
                -majorityVotesLScoreAlgorithm {
                    +ConstantParameter.AllowMultipleVoteInPollParameter
                }

                +("competitor2" votedBy "voter1")
                +("competitor2" votedBy "voter2")
                +("competitor1" votedBy "voter2")
            } // same score, competitor2 has more votes

            +poll {
                -competition("Race 2") {
                    +competitor("competitor1") {
                        +(BestTimeInMatch realized (T.toDuration(DurationUnit.HOURS)))
                        +(BestTimeInMatch realized (1.toDuration(DurationUnit.HOURS)))
                        +(BestTimeInMatch realized (2.toDuration(DurationUnit.HOURS)))
                    }

                    +competitor("competitor2") {
                        +(BestTimeInMatch realized (1.toDuration(DurationUnit.HOURS)))
                    }
                }
                -majorityVotesLScoreAlgorithm {
                    +ConstantParameter.AllowMultipleVoteInPollParameter
                }

                +("competitor2" votedBy "voter1")
                +("competitor1" votedBy "voter1")
                +("competitor2" votedBy "voter2")
                +("competitor1" votedBy "voter2")
            } // same votes, competitor1 has the lowest score

            +poll {
                -competition("Race 3") {
                    +competitor("competitor1") {
                        +(BestTimeInMatch realized (T.toDuration(DurationUnit.HOURS)))
                        +(BestTimeInMatch realized (1.toDuration(DurationUnit.HOURS)))
                        +(BestTimeInMatch realized (2.toDuration(DurationUnit.HOURS)))
                    }

                    +competitor("competitor2") {
                        +(BestTimeInMatch realized (T.toDuration(DurationUnit.HOURS)))
                    }
                }
                -majorityVotesLScoreAlgorithm {
                    +ConstantParameter.AllowMultipleVoteInPollParameter
                }

                +("competitor2" votedBy "voter1")
                +("competitor1" votedBy "voter1")
                +("competitor2" votedBy "voter2")
                +("competitor1" votedBy "voter2")
            } // same votes, same lowest score
        }

    election.printRankings()

    // ** Ranking #1 **
    // Competition name is Race 1
    // Used algorithm is MajorityVotesThenLowestScoreAlgorithm
    // Placement #1 -> [competitor2] with 2 votes 
    //      competitor2 scores list :
    //          - Score type is BestTimeInMatch with time = 1h -

    // ** Ranking #2 **
    // Competition name is Race 2
    // Used algorithm is MajorityVotesThenLowestScoreAlgorithm
    // Placement #1 -> [competitor1] with 2 votes 
    //      competitor1 scores list :
    //          - Score type is BestTimeInMatch with time = 6m -
    // Placement #2 -> [competitor2] with 2 votes 
    //      competitor2 scores list :
    //          - Score type is BestTimeInMatch with time = 1h -
    
    //** Ranking #3 **
    //Competition name is Race 3
    //Used algorithm is MajorityVotesThenLowestScoreAlgorithm

    //Placement #1 -> [competitor2 | competitor1] with 2 votes 
    //      competitor2 scores list :
    //          - Score type is BestTimeInMatch with time = 6m -
    //      competitor1 scores list :
    //          - Score type is BestTimeInMatch with time = 6m -

