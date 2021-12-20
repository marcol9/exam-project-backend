package examproject.services;

import examproject.entities.Candidate;
import examproject.entities.Party;

import java.util.List;

public interface ICandidateService {
    List<Candidate> getAllCandidates();
    List<Candidate> getCandidatesByParty(int partyId);
    Candidate createCandidate(Candidate candidate);
    Candidate editCandidate(int candidateId,Candidate candidate);
    void deleteCandidate(int candidateId);
    Candidate getById(int candidateId);
}
