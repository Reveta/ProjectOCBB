package ua.somedomen.obcc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.somedomen.obcc.entity.Voting;

public interface VotingDAO extends JpaRepository<Voting, Integer> {
}
