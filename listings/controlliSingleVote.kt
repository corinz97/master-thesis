   if (candidates.groupingBy { it.name }.eachCount().any { it.value > 1 }) {
            error("Candidate already declared")
        }

        require(votes.any())
        
        if (votes.map { it.votedCompetitor }.any { it !in candidates }) {
            error("Voted candidate doesn't exist as object")
        }

        when (pollAlgorithmParameters.count { it == ConstantParameter.AllowMultipleVoteInPollParameter }) {
            0 -> {
                if (votes.groupingBy { it.voter.identifier }.eachCount().any { it.value > 1 }) {
                    error("Each voter can vote only once")
                }
            }
            1 -> {
                // multiple vote allowed
                if (votes.groupingBy {
                        Pair(
                            it.votedCompetitor.name,
                            it.voter.identifier,
                        )
                    }.eachCount().any { it.value > 1 }
                ) {
                    error("Each voter can vote just once for each competitor")
                }
            }
            else -> error("Parameter can't be repeated more than once")
        }