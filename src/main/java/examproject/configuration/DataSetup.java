package examproject.configuration;

import examproject.entities.Candidate;
import examproject.entities.Party;
import examproject.repositories.CandidateRepo;
import examproject.repositories.PartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;

@Configuration
public class DataSetup implements CommandLineRunner {
    @Autowired
    CandidateRepo candidateRepo;
    @Autowired
    PartyRepo partyRepo;

    @Override
    public void run(String... args) throws Exception {
        Party party1 = partyRepo.save(new Party('A', "Socialdemokratiet"));
        Party party2 = partyRepo.save(new Party('C', "Det konservative Folkeparti"));
        Party party3 = partyRepo.save(new Party('F', "SF, Socialistisk Folkeparti"));
        Party party4 = partyRepo.save(new Party('O', "Dansk Folkeparti"));
        Party party5 = partyRepo.save(new Party('V', "Venstre, Danmarks Liberale Parti"));
        Party party6 = partyRepo.save(new Party('Ø', "Enhedslisten + De Rød Grønne"));
        candidateRepo.save(new Candidate("Marcel Meijer",party1));
        candidateRepo.save(new Candidate("Michael Kristensen",party1));
        candidateRepo.save(new Candidate("Helle Hansen",party1));
        candidateRepo.save(new Candidate("Karina Knobelauch",party1));
        candidateRepo.save(new Candidate("Stefan Hafstein Wolffbrandt",party1));
        candidateRepo.save(new Candidate("Robert V. Rasmussen",party1));
        candidateRepo.save(new Candidate("Pia Ramsing",party1));
        candidateRepo.save(new Candidate("Anders Baun Sørensen",party1));
        candidateRepo.save(new Candidate("Per Urban Olsen",party2));
        candidateRepo.save(new Candidate("Peter Askjær",party2));
        candidateRepo.save(new Candidate("Martin Sørensen",party2));
        candidateRepo.save(new Candidate("Louise Bramstorp",party2));
        candidateRepo.save(new Candidate("Sigfred Jensen",party2));
        candidateRepo.save(new Candidate("Jørn C. Nissen",party2));
        candidateRepo.save(new Candidate("Morten Ø. Kristensen",party2));
        candidateRepo.save(new Candidate("Susanne Andersen",party2));
        candidateRepo.save(new Candidate("Iulian V. Paiu",party2));
        candidateRepo.save(new Candidate("Per Hingel",party2));
        candidateRepo.save(new Candidate("Ulla Holm",party3));
        candidateRepo.save(new Candidate("Kjeld Bønkel",party3));
        candidateRepo.save(new Candidate("Anne Grethe Olsen",party3));
        candidateRepo.save(new Candidate("Lone Krag",party3));
        candidateRepo.save(new Candidate("Børge S. Buur",party3));
        candidateRepo.save(new Candidate("Per Mortensen",party4));
        candidateRepo.save(new Candidate("Søren Wiese",party5));
        candidateRepo.save(new Candidate("Anita Elgaard Højholt Olesen",party5));
        candidateRepo.save(new Candidate("Carsten Bruun",party5));
        candidateRepo.save(new Candidate("Mogens Exner",party5));
        candidateRepo.save(new Candidate("Anja Guldborg",party5));
        candidateRepo.save(new Candidate("Klaus Holdorf",party5));
        candidateRepo.save(new Candidate("Katrine Høegh Mc Quaid",party6));
        candidateRepo.save(new Candidate("Jette M. Søgaard",party6));
        candidateRepo.save(new Candidate("Søren Caspersen",party6));
        candidateRepo.save(new Candidate("Pia Birkmand",party6));
        
        List<Candidate> candidateList = candidateRepo.findAll();
        Random r = new Random();

        for (Candidate candidate: candidateList
             ) {
            candidate.setVotes(r.nextInt(10000));
            candidateRepo.save(candidate);
        }
    }
}
