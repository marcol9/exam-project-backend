package examproject.rest;

import examproject.entities.Candidate;
import examproject.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @GetMapping("/candidates")
    public List<Candidate> getAllCandidates(){
        return candidateService.getAllCandidates();
    }

    @GetMapping("/candidates/party/{partyId}")
    public List<Candidate> getCandidatesByParty(@PathVariable int partyId){
        return candidateService.getCandidatesByParty(partyId);
    }

    @DeleteMapping("/candidate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCandidateById(@PathVariable int id){
        candidateService.deleteCandidate(id);
    }

    @PostMapping("/candidate")
    @ResponseStatus(HttpStatus.CREATED)
    public Candidate createCandidate(@RequestBody Candidate candidate){
    return candidateService.createCandidate(candidate);
    }

    @PutMapping("/candidate/{candidateId}")
    public Candidate updateCandidate(@PathVariable int candidateId, @RequestBody Candidate candidate){
        return candidateService.editCandidate(candidateId,candidate);
    }

    @GetMapping("/candidate/{candidateId}")
    public Candidate getById(@PathVariable int candidateId){
        return candidateService.getById(candidateId);
    }
}
