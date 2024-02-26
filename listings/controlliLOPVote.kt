if (candidates.groupingBy { it.name }.eachCount().any { it.value > 1 }) {
        error("Candidate already declared")
    }
    require(votes.any())
    when (pollAlgorithmParameters.count { it == ConstantParameter.AllowMultipleVoteInPollParameter }) {
        0 -> {
            if (votes.groupingBy { it.voter.identifier }.eachCount().any { it.value > 1 }) {
                error("Each voter can vote only once")
            }
        }
        1 -> {
            if (votes.groupingBy {
                    Pair(it.votedCompetitors.map { c -> c.name }, it.voter.identifier)
                }.eachCount().any { it.value > 1 }
            ) {
                error("Each voter can vote just once for each list of preferences")
            }
        }
        else -> error("Parameter can't be repeated more than once")
    }
    votes.map { it.votedCompetitors }.forEach {
        val setOfCompetitors = it.toSet()
        if (setOfCompetitors != candidates) {
            if ((setOfCompetitors - candidates).isNotEmpty()) {
                error("A list of preferences contains one o more not allowed candidate")
            }
            if ((candidates - setOfCompetitors).isNotEmpty()) {
                error("Every allowed candidate must be present in every list of preferences")
            }
        }
        val groupCount = it.groupingBy { comp -> comp }.eachCount()
        if (groupCount.any { count -> count.value > 1 }) {
            error("Every allowed candidate can be present only once in the list of competitors")
        }
    }