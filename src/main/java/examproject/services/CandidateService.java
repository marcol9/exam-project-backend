package examproject.services;

import examproject.entities.Candidate;
import examproject.entities.Party;
import examproject.repositories.CandidateRepo;
import examproject.repositories.PartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService implements ICandidateService{
    @Autowired
    CandidateRepo candidateRepo;
    @Autowired
    PartyRepo partyRepo;

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepo.findAll();
    }

    @Override
    public List<Candidate> getCandidatesByParty(int partyId) {
        return candidateRepo.findCandidateByPartyId(partyId);
    }

    @Override
    public Candidate createCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    @Override
    public Candidate editCandidate(int candidateId, Candidate candidate) {
        Candidate updatedCandidate = candidateRepo.findById(candidateId)
                .orElseThrow( () -> new ResourceNotFoundException("The candidate with this is id does not exist"));
        if(candidate.getName()!=null){
            updatedCandidate.setName(candidate.getName());
        }
        if(candidate.getVotes() != null){
            updatedCandidate.setVotes(candidate.getVotes());
        }
        if(candidate.getParty() != null){
            if(partyRepo.existsById(candidate.getParty().getId())){
                updatedCandidate.setParty(candidate.getParty());
            }else{
                throw  new ResourceNotFoundException("The party with this id does not exist");
            }
        }
        candidateRepo.save(updatedCandidate);
        return updatedCandidate;
    }

    @Override
    public void deleteCandidate(int candidateId) {
    candidateRepo.deleteById(candidateId);
    }

    @Override
    public Candidate getById(int candidateId) {
        Candidate candidate =  candidateRepo.findCandidateById(candidateId);
        if(candidate == null){
            throw new ResourceNotFoundException("The candidate with this id does not exist");
        }else{
            return candidate;
        }

    }
}
