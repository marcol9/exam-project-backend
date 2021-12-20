package examproject.unitTests;

import examproject.entities.Candidate;
import examproject.repositories.CandidateRepo;
import examproject.repositories.PartyRepo;
import examproject.services.CandidateService;
import examproject.services.ICandidateService;
import examproject.services.PartyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@ComponentScan("examproject")
public class UnitTests {
    @Autowired
    CandidateService candidateService;
    @Autowired
    CandidateRepo candidateRepo;
    @Autowired
    PartyRepo partyRepo;
    @Autowired
    PartyService partyService;


    @Test
    @Sql("/prepareData.sql")
    void getAllFromRepo(){
        List<Candidate> candidates = candidateRepo.findAll();
        int length = candidates.size();
        assertEquals(4,length);
    }

    @Test
    @Sql("/prepareData.sql")
    void getAllFromService(){
        List<Candidate> candidates = candidateService.getAllCandidates();
        int length = candidates.size();
        assertEquals(4,length);
    }

    @Test
    @Sql("/prepareData.sql")
    void deleteFromService(){
        candidateService.deleteCandidate(1);
        List<Candidate> candidates = candidateService.getAllCandidates();
        int length = candidates.size();
        assertEquals(3,length);
    }

    @Test
    @Sql("/prepareData.sql")
    void createFromService(){
        candidateService.createCandidate(new Candidate("Hello",partyRepo.getById(1)));
        List<Candidate> candidates = candidateService.getAllCandidates();
        String name = candidates.get(4).getName();
        assertEquals("Hello",name);
    }

}
