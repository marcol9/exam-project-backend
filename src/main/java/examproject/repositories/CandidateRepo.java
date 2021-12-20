package examproject.repositories;

import examproject.entities.Candidate;
import examproject.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {
    List<Candidate> findCandidatesByParty(Party party);
    List<Candidate> findCandidateByPartyId(int partyId);
    Candidate findCandidateById(int id);
}
