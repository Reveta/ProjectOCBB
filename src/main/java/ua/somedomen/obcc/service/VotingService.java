package ua.somedomen.obcc.service;

import ua.somedomen.obcc.entity.Voting;

import java.util.List;

public interface VotingService{

    void addVoting(Voting voting);

    List<Voting> findALL();

}
